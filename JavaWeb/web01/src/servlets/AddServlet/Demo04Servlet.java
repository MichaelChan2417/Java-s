package servlets.AddServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 向HttpServlet获取保存数据
 */
public class Demo04Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object unameObj = req.getSession().getAttribute("uname");

        String uname = (String) unameObj;
        System.out.println(uname);
    }
}
