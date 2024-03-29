package myssm.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static myssm.util.StringUtil.isEmpty;

@WebFilter(urlPatterns = {"*.do"}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {

    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingStr = filterConfig.getInitParameter("encoding");

        if (!isEmpty(encodingStr)) {
            encoding = encodingStr;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ((HttpServletRequest) servletRequest).setCharacterEncoding(encoding);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
