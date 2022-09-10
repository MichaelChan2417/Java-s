package myssm.myspringmvc;

import myssm.ioc.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static myssm.util.StringUtil.isEmpty;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet{

    private BeanFactory beanFactory;

    public DispatcherServlet(){
    }

    public void init() throws ServletException {
        super.init();
        // 之前在此处主动创建IOC容器 => 现在优化为application作用域来获取IOC容器
        // beanFactory = new ClassPathXmlApplicationContext();
        Object beanFactoryObj = getServletContext().getAttribute("beanFactory");
        if (beanFactoryObj != null) {
            beanFactory = (BeanFactory) beanFactoryObj;
        } else {
            throw new RuntimeException("IOC container error");
        }
    }


    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // code
        // req.setCharacterEncoding("UTF-8");

        String servletPath = req.getServletPath();
        int lastDotIndex = servletPath.lastIndexOf(".do");
        String servletName = servletPath.substring(1, lastDotIndex);

        Object controllerBeanObj = beanFactory.getBean(servletName);

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

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
