package cn.lyp.springframework.test.bean;

/**
 * @Author: 53256
 * @Date: 2025/4/30 10:47
 * @Description:
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}

