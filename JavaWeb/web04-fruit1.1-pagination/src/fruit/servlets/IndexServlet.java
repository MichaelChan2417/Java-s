package fruit.servlets;

import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static myssm.util.StringUtil.isEmpty;

// 注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if (!isEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = req.getSession();
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);
        // Store to the session
        session.setAttribute("fruitList", fruitList);

        // get total pageNo
        long fruitCount = fruitDAO.getFruitCount();
        long totalPage = (fruitCount+5-1)/5;
        session.setAttribute("totalPage", totalPage);

        // thymeleaf 会将这个逻辑视图名称对应到物理视图名称上去
        // 逻辑名称：index
        // 物理视图：prefix(/) + 逻辑名称 + suffix(.html)
        super.processTemplate("index", req, resp);
    }
}
