package servlets.AddServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务器内部转发/重定向
 */
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo05...");
        // 内部转发
        // req.getRequestDispatcher("demo06").forward(req, resp);

        // 重定向
        resp.sendRedirect("demo06");
    }
}
