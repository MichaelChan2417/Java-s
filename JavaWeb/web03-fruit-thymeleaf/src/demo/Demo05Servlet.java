package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// application的保存作用域
@WebServlet("/demo05")
public class Demo05Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 向application保存作用域 保存数据
        // servlet上下文
        ServletContext application = req.getServletContext();
        application.setAttribute("uname", "Bala");
        // 2. 客户端重定向
        resp.sendRedirect("demo06");
        // 2p.内部转发
        // req.getRequestDispatcher("demo06").forward(req, resp);
    }
}
