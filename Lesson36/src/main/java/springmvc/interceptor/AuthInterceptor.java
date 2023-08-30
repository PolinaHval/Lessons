package springmvc.interceptor;


import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import springmvc.session.AuthContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

  private final AuthContext authContext;

  @Override
  public boolean preHandle(@org.springframework.lang.NonNull HttpServletRequest request, @org.springframework.lang.NonNull HttpServletResponse response,
                           @NonNull Object handler) throws Exception {
    if (authContext.getLoggedInUserId() != null || authContext.getOrganizationId() != null) {
      return true;
    }
    response.sendRedirect("accessDenied");
    return false;
  }
}
