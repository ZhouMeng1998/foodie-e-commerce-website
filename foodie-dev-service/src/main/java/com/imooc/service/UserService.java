package com.imooc.service;

import com.imooc.pojo.bo.UserBO;
import com.imooc.pojo.Users;
import org.apache.catalina.User;

public interface UserService {
    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);

    public Users queryUserByLogin(String username, String password);
}
