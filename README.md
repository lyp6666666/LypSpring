# Spring 核心容器实现说明

本项目是对 Spring 核心类库的一个轻量化实现，并且拓展rag相关能力，核心目标是：

- 体现 **IoC 容器的基本原理**
- 展示 **设计模式的运用与解耦思想**
- 提供一个具备高扩展性和清晰分层架构的简化实现
- 提供高效的rag实现接口，保证embedding模型的多样选择

<img width="4839" alt="8ba6a7c3a51775c98c0f201774a86de" src="https://github.com/user-attachments/assets/4f123e92-adb8-479f-9e1b-b1a30d3a94a0" />



## 🔹 核心设计思想

1. **职责分离，分层设计**：容器从 **Bean 定义、Bean 注册、Bean 实例化、依赖注入、上下文扩展** 等环节逐层解耦。
2. **模板方法模式**：如 `AbstractAutowireCapableBeanFactory` 中通过抽象方法定义流程骨架，具体实现由子类扩展。
3. **策略模式**：通过不同的 `Resource` 实现类，实现多种配置文件加载方式，调用方只依赖统一接口。
4. **观察者/回调机制**：`BeanPostProcessor`、`Aware` 系列接口提供扩展点，保证 Bean 生命周期的可插拔增强。
5. **高扩展性与开闭原则**：通过接口抽象和层次化设计，允许开发者扩展实例化方式、属性注入方式、资源解析方式等。



## 部分功能实现说明（分层按照需求逻辑说明）

### 1. **构造函数实例化 Bean**

- **问题**：如何支持带参数构造函数的 Bean 实例化？

- **实现**：在 `BeanFactory` 中新增

  ```
  Object getBean(String name, Object... args);
  ```

  接口方法，允许在获取 Bean 时传递构造参数。

- **技术点**：

  - 使用 **Cglib 或反射** 创建实例，支持多构造函数选择。
  - 可扩展为不同的 **实例化策略**（如 JDK 反射 / Cglib 子类代理）。

**设计模式体现：策略模式（InstantiationStrategy 可插拔）**

------

### 2. **属性填充（依赖注入）**

- **实现步骤**：
  1. 在 `AbstractAutowireCapableBeanFactory.createBean()` 中调用 `applyPropertyValues()`。
  2. 在 `BeanDefinition` 中维护 `PropertyValues` 集合，支持属性配置。
  3. 依赖注入时，区分普通值与 Bean 引用（`BeanReference`），引用类型通过 `getBean()` 递归解析。

**设计模式体现：模板方法模式（定义流程骨架，属性注入作为扩展步骤）**

------

### 3. **资源加载与 Bean 注册**

- **流程**：
   `ResourceLoader` → `Resource` → `BeanDefinitionReader` → 注册到 `BeanFactory`
- **实现**：
  - `Resource` 接口抽象了统一的资源访问方式，支持 **classpath、文件系统、URL** 三种实现。
  - `BeanDefinitionReader` 依赖 `ResourceLoader` 获取资源，再进行解析（如 `XmlBeanDefinitionReader`）。

**设计模式体现**：

- 策略模式（多种 Resource 实现）
- 依赖倒置原则（上层只依赖 ResourceLoader，不关心底层文件读取逻辑）**

------

### 4. **应用上下文（ApplicationContext）**

- **作用**：整合 Bean 的生命周期管理与扩展机制，对外提供更完整的 IoC 容器能力。
- **实现**：
  - 在容器刷新过程中，注册并调用 `BeanPostProcessor`。
  - 扫描并执行 `Aware` 接口回调（如 `ApplicationContextAware`），让 Bean 感知容器。
  - 对外暴露统一的 `ApplicationContext` 接口，屏蔽底层复杂实现。

 **设计模式体现：观察者模式（BeanPostProcessor/Aware 回调）**



## 5. **Bean 销毁与适配器模式**

- **问题**：不同 Bean 可能有不同的销毁方式，比如：
  1. 实现 `DisposableBean` 接口，重写 `destroy()` 方法。
  2. 在 XML/配置文件中指定自定义的销毁方法（如 `<bean destroy-method="close"/>`）。
- **挑战**：
  - 容器需要在销毁阶段统一处理不同的销毁方式。
  - 但不能在容器内部硬编码“如果实现了接口就调用 A，否则调用 B”，否则扩展性和解耦性都差。
- **解决方案**：
   使用 **适配器模式**，定义 `DisposableBeanAdapter`：
  - 它实现统一的 `DisposableBean` 接口。
  - 内部持有目标 Bean 和销毁方法的信息。
  - 容器在销毁时统一调用 `adapter.destroy()`，由适配器去决定调用哪种销毁逻辑。













