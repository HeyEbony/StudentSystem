package ZXKBEST.service;

import ZXKBEST.dao.UserDAO;
import ZXKBEST.pojo.User;

import java.util.List;

public class UserService {
    UserDAO dao = new UserDAO();
//存用户数据
    public List<User> findAllUser(){

        return dao.findAllUser();
    }

    public boolean login(User user) {
        int temp = dao.login(user);
        if (temp == 0)
            return false;
        else
            return true;
    }
}
//服务层，给控制层提供服务