package springmvc.interceptor;


import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import springmvc.session.AuthContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

  private final AuthContext authContext;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (authContext.isAuthorized()) {
      return true;
    }
    response.sendRedirect("access-denied");
    return false;
  }
}
