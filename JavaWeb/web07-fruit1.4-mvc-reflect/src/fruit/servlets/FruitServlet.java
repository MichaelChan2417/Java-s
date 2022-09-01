package fruit.servlets;

import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static myssm.util.StringUtil.isEmpty;

@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operate = req.getParameter("operate");

        if (isEmpty(operate)) {
            operate = "index";
        }

        // get all the method in cur class
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method m : methods) {
            String methodName = m.getName();
            if (operate.equals(methodName)) {
                // find the corresponding same name
                try {
                    m.invoke(this, req, resp);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        throw new RuntimeException("Illegal 'operate' value");

    }

    // update func
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.sendRedirect("fruit.do");
    }

    // edit func
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (!isEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            Fruit speFruit = fruitDAO.getFruitById(fid);
            req.setAttribute("speFruit", speFruit);
            super.processTemplate("edit", req, resp);
        }
    }

    // delete func
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (!isEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            fruitDAO.deleteFruit(fid);

            resp.sendRedirect("fruit.do");
        }

    }

    // add function
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        String fcountStr = req.getParameter("fcount");
        String remark = req.getParameter("remark");

        int price = Integer.parseInt(priceStr);
        int fcount = Integer.parseInt(fcountStr);

        Fruit fruit = new Fruit(0, fname, price, fcount, remark);

        fruitDAO.addFruit(fruit);

        resp.sendRedirect("fruit.do");
    }

    // index func
    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        // reset cur page number
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
