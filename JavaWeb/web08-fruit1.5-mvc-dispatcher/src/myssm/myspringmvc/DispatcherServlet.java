package myssm.myspringmvc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static myssm.util.StringUtil.isEmpty;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{

    private Map<String, Object> beanMap = new HashMap<>();


    public DispatcherServlet(){
    }


    public void init(){
        System.out.println("init config...");
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            // 1.DBF对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            // 2.DB对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // 3.Document对象
            Document document = documentBuilder.parse(is);
            // 4.获取所有bean节点
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for(int i=0; i<beanNodeList.getLength(); i++){
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    Class controllerBeanClass = Class.forName(className);
                    Object beanObj = controllerBeanClass.newInstance();

                    Method setServletContextMethod = controllerBeanClass.getDeclaredMethod("setServletContext", ServletContext.class);
                    setServletContextMethod.invoke(beanObj, this.getServletContext());

                    beanMap.put(beanId, beanObj);
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // code
        req.setCharacterEncoding("UTF-8");

        String servletPath = req.getServletPath();
        int lastDotIndex = servletPath.lastIndexOf(".do");
        String servletName = servletPath.substring(1, lastDotIndex);

        Object controllerBeanObj = beanMap.get(servletName);

        // ***********
        String operate = req.getParameter("operate");
        if (isEmpty(operate)) {
            operate = "index";
        }

        try {
            Method method = controllerBeanObj.getClass().getDeclaredMethod(operate, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(controllerBeanObj, req, resp);
            }
            else{
                throw new RuntimeException("Illegal 'operate' value");
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
