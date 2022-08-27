package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// request的保存作用域(一次请求有效，重定向是第二次请求了)
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 向req保存作用域 保存数据
        req.setAttribute("uname", "Bala");
        // 2. 客户端重定向
        // resp.sendRedirect("demo02");
        // 2p.内部转发
        req.getRequestDispatcher("demo02").forward(req, resp);
    }
}
