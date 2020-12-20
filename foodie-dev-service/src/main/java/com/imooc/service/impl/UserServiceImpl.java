package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.pojo.bo.UserBO;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FACE = "https://banner2.cleanpng.com/20180806/tjy/kisspng-computer-icons-portable-network-graphics-user-symb-profile-svg-png-icon-free-download-446808-onl-5b68e60de80c24.8285058715336012939505.jpg";

    @Autowired
    private Sid sid;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users == null ? false : true;
    }

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        user.setFace(USER_FACE);
        user.setSex(Sex.SECRET.type);
        user.setNickname(userBO.getUsername());
        user.setId(sid.nextShort());
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        usersMapper.insert(user);
        return user;
    }
}
