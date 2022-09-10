package fruit.controllers;

import fruit.service.FruitService;
import fruit.pojo.Fruit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static myssm.util.StringUtil.isEmpty;


public class FruitController{

    private FruitService fruitService = null;

    // update func
    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        // update
        fruitService.updateFruit(new Fruit(fid, fname, price, fcount, remark));

        return "redirect:fruit.do";
    }

    // edit func
    private String edit(Integer fid, HttpServletRequest req){
        if (fid!=null) {
            Fruit speFruit = fruitService.getFruitByFid(fid);
            req.setAttribute("speFruit", speFruit);
            return "edit";
        }
        return "error";
    }

    // delete func
    private String delete(Integer fid){
        if (fid != null) {
            fruitService.delFruit(fid);
            return "redirect:fruit.do";
        }

        return "error";
    }

    // add function
    private String add(String fname, Integer price, Integer fcount, String remark){
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitService.addFruit(fruit);

        return "redirect:fruit.do";
    }

    // index func
    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest req){

        HttpSession session = req.getSession();

        if (pageNo == null) {
            pageNo = 1;
        }
        if (!isEmpty(oper) && "search".equals(oper)){
            pageNo = 1;
            if (isEmpty(keyword)) {
                keyword = "";
            }

            session.setAttribute("keyword", keyword);
        }
        else{
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            }
            else{
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);

        List<Fruit> fruitList = fruitService.getFruitList(keyword, pageNo);
        session.setAttribute("fruitList", fruitList);

        // get total pageNo
        int pageCount = fruitService.getPageCount(keyword);
        session.setAttribute("totalPage", pageCount);

        return "index";
    }
}
