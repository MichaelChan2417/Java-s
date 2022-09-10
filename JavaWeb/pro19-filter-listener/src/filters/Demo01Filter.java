package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/demo01.do")
@WebFilter("*.do")
public class Demo01Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HelloA");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        // 当收到回来时，执行下面的代码
        System.out.println("HelloA2");

    }

    @Override
    public void destroy() {

    }
}
