package cn.white.service;

import cn.white.entity.User;

public interface UserService {
    void register(User user);

    User selectUserByCode(String code);

    String updateUserState(String code);
}
