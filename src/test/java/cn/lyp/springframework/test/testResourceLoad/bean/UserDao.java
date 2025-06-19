package cn.lyp.springframework.test.testResourceLoad.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 14:22
 * @Description:
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "陆熠鹏");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}

