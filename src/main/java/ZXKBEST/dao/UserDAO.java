package ZXKBEST.dao;
//DAO：数据访问对象
import ZXKBEST.dbutil.DBUtils;
import ZXKBEST.pojo.User;

import java.util.List;


public class UserDAO {
    public List<User> findAllUser(){
        DBUtils dbUtils= new DBUtils();

        return dbUtils.findAllUser();
    }
    //返回0或1
    public  int login(User user){

        DBUtils dbUtils=new DBUtils();

        int temp=dbUtils.login(user);

        return temp;
    }
}
