package com.imooc.service;

import com.imooc.pojo.bo.UserBO;
import com.imooc.pojo.Users;

public interface UserService {
    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);
}
