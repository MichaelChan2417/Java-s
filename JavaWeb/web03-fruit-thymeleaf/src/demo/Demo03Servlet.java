package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// session的保存作用域(一次会话内有效，只要session没有过期)
@WebServlet("/demo03")
public class Demo03Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 向session保存作用域 保存数据
        req.getSession().setAttribute("uname", "Bala");
        // 2. 客户端重定向
        resp.sendRedirect("demo04");
        // 2p.内部转发
        // req.getRequestDispatcher("demo04").forward(req, resp);
    }
}
