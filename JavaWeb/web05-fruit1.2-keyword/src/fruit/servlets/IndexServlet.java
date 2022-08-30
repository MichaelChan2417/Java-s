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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageNo = 1;
        String keyword = null;
        HttpSession session = req.getSession();

        String oper = req.getParameter("oper");
        // if oper is null: Not a search func
        // if oper is !null: a search func

        if (!isEmpty(oper) && "search".equals(oper)){
            // a search func has been called
            // pageNo should be reset to 1 and get the keyword
            pageNo = 1;
            keyword = req.getParameter("keyword");
            if (isEmpty(keyword)) {
                keyword = "";
            }

            session.setAttribute("keyword", keyword);
        }
        else{
            // not a search func: NEXTpage/PREVpage/...
            String pageNoStr = req.getParameter("pageNo");
            if (!isEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }

            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            }
            else{
                keyword = "";
            }
        }

        // **************************** rest ****************************
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);
        // Store to the session
        session.setAttribute("fruitList", fruitList);

        // get total pageNo
        long fruitCount = fruitDAO.getFruitCount(keyword);
        long totalPage = (fruitCount+5-1)/5;
        session.setAttribute("totalPage", totalPage);

        // thymeleaf 会将这个逻辑视图名称对应到物理视图名称上去
        // 逻辑名称：index
        // 物理视图：prefix(/) + 逻辑名称 + suffix(.html)
        super.processTemplate("index", req, resp);
    }
}
