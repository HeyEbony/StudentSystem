package ZXKBEST.controllor;

import ZXKBEST.pojo.User;
import ZXKBEST.service.UserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServletForAjax")
public class UserServletForAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
    }
//处理UserServlet对Ajax的请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService =new UserService();
        List<User> allUser = userService.findAllUser();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        //将对象转化为Jason字符串
        String jsonStr= JSON.toJSONString(allUser);
        out.print(jsonStr);
        out.close();


        System.out.println("do Get");

    }
}
