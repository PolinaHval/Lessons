package springmvc.exceptionmapping;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(final Exception ex) {
    final ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", "Internal server error");
    modelAndView.setViewName("error");
    return modelAndView;
  }
}
