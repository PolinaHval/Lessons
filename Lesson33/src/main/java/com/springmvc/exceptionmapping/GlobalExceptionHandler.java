package com.springmvc.exceptionmapping;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(final Exception ex) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("message", "Internal server error");
    modelAndView.setViewName("error");
    return modelAndView;
  }

  @ExceptionHandler(SQLException.class)
  public ModelAndView handleSqlException(HttpServletRequest request, Exception ex) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", "Database error");
    model.setViewName("errorDatabase");
    return model;
  }
}
