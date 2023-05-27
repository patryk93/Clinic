package pl.coderslab.filters;

import pl.coderslab.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/logged/*"})
public class AutorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute("loggedUser");

        if (user == null) {
            res.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);

    }
    @Override
    public void destroy() {

    }
}