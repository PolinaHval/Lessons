//package com.springmvc.interceptor;


import com.springmvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;


//@RequiredArgsConstructor
//public class AuthInterceptor implements HandlerInterceptor {
//  private final AuthContext authContext;
//
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    if (authContext.getLoggedInUserId() != null) {
//      return true;
//    }
//    response.sendRedirect("accessDenied");
//    return false;
//  }
//}
