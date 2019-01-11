package ZXKBEST.controllor;

import ZXKBEST.pojo.User;
import ZXKBEST.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        request.setCharacterEncoding("utf-8");
        //获取do post中的参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String role = request.getParameter("role");
/*硬编码, 不从数据库获取信息，直接验证
        if (uname.equals("admin") && upwd.equals("123456")) {
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("loginServlet.html");
        }*/

//        从服务层获取值
        UserService userService = new UserService();
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        user.setRole(role);
        if (userService.login(user)) {
            if (uname.equals("admin") && upwd.equals("123456")) {
                response.sendRedirect("showUserInfo.jsp");
            } else {
                response.sendRedirect("login.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("My servlet");
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String role = request.getParameter("role");
        System.out.println("doGet");
        System.out.println(uname + ":" + upwd + "-" + role);

        UserService userService = new UserService();

        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        user.setRole(role);
        boolean login = userService.login(user);
        PrintWriter out = response.getWriter();
        if (login)
            out.print("1");
        else
            out.print("0");
        out.close();

    }
}
