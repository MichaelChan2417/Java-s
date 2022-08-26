package servlets.AddServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("fprice");
        Integer price = Integer.parseInt(priceStr);
        String storageStr = req.getParameter("fcount");
        Integer stoNum = Integer.parseInt(storageStr);
        String remark = req.getParameter("remark");

        System.out.println("Name: " + fname);
        System.out.println("Price: " + price);
        System.out.println("Storage: " + stoNum);
        System.out.println("Note: " + remark);
    }
}
