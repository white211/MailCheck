package cn.white.dao;

import cn.white.entity.User;

public interface UserDao {
    void register(User user);

    User selectUserByCode(String code);

    void updateUserState(String code);

}
