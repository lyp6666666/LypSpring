package cn.lyp.springframework.test.testResourceLoad.bean;

/**
 * @Author: LypCoding
 * @Date: 2025/6/19 14:23
 * @Description:
 */

public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
