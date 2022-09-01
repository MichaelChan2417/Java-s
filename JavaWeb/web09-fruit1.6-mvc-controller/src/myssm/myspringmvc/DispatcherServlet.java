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
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import static myssm.util.StringUtil.isEmpty;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet{

    private Map<String, Object> beanMap = new HashMap<>();

    public DispatcherServlet(){
    }

    public void init() throws ServletException {
        super.init();
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
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            for(Method method : methods){
                if (operate.equals(method.getName())) {
                    // 1. get the request parameter together
                    // cur method's parameters
                    Parameter[] parameters = method.getParameters();
                    // store the parameter's values
                    Object[] parameterValues = new Object[parameters.length];
                    for(int i=0; i< parameters.length; i++){
                        Parameter parameter = parameters[i];
                        // based on different parameter's name
                        String paraName = parameter.getName();

                        if ("req".equals(paraName)) {
                            parameterValues[i] = req;
                        } else if ("resp".equals(paraName)) {
                            parameterValues[i] = resp;
                        } else if ("session".equals(paraName)) {
                            parameterValues[i] = req.getSession();
                        } else{
                            String parameterValue = req.getParameter(paraName);
                            String typeName = parameter.getType().getName();

                            parameterValues[i] = parameterValue;  // 存储的数据是"2",而不是2

                            if (parameterValue != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    parameterValues[i] = Integer.parseInt(parameterValue);
                                } else if ("java.lang.Double".equals(typeName)) {
                                    parameterValues[i] = Double.parseDouble(parameterValue);
                                }
                            }
                        }
                    }

                    method.setAccessible(true);
                    // 2. act the function
                    Object methodReturnObj = method.invoke(controllerBeanObj, parameterValues);
                    String methodReturnStr = (String) methodReturnObj;

                    // 3. new redirect
                    if (methodReturnStr.startsWith("redirect:")) {
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    }
                    else{
                        super.processTemplate(methodReturnStr, req, resp);
                    }
                }
            }

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
