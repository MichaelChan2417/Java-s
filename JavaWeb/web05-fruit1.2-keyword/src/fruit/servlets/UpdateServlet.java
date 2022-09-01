package fruit.servlets;

import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");

        int fid = Integer.parseInt(fidStr);
        int price = Integer.parseInt(priceStr);
        int fcount = Integer.parseInt(fcountStr);

        // update
        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));

        // return to index page
        // super.processTemplate("index", req, resp);
        // 此处需要重定向，目的是重新给IndexServlet中的session重新赋值
        resp.sendRedirect("index");
    }
}
