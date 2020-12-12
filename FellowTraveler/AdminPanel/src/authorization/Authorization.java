package authorization;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Денис on 18.05.14.
 */
public class Authorization implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Метод проверяет авторизован ли пользователь.
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie cookies[] = request.getCookies();
        if (cookies != null){
            int i = 0;
            while (i < cookies.length && !cookies[i].getName().equals("l") ){
                i++;
            }
            if (i < cookies.length){
                String hash = cookies[i].getValue();
                String user = (String) request.getSession().getAttribute(hash);
                if (user != null){
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    response.sendRedirect(request.getContextPath());
                }
            }else {
                response.sendRedirect(request.getContextPath());
            }
        }else {
            response.sendRedirect(request.getContextPath());
        }

    }

    @Override
    public void destroy() {

    }
}
