package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/users")
public class SecurityFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    final HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession(false);
    boolean loggedIn = session != null && session.getAttribute("loggedInUserId") != null;
    if (loggedIn) {
      chain.doFilter(request, response);
    } else {
      request.getServletContext().getRequestDispatcher("/accessDenied.jsp").forward(request, response);
    }
  }
}

