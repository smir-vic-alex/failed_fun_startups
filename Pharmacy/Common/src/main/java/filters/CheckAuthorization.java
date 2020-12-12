/**
 * Создано: Денис 
 * Дата: 05.01.15
 * Описание: 
 */
package filters;

import helpers.GlobalConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckAuthorization implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Boolean isUserLogin = (Boolean) session.getAttribute(GlobalConstants.IS_LOGIN_USER);
        if (isUserLogin != null && isUserLogin){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect(request.getContextPath());
        }
        int a = 1;
    }

    @Override
    public void destroy() {

    }
}
