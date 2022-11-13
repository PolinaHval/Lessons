package servlet;

import lombok.extern.slf4j.Slf4j;
import model.User;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    userService = (UserService) config.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final String login = request.getParameter("login");
    final String password = request.getParameter("password");
    Optional<User> user = userService.getUser(login);

    if (user.isPresent() && user.get().getPassword().equals(password)) {
      request.getSession().setAttribute("loggedIn", true);
      log.info("User {} logged in", login);
      response.sendRedirect("users");
    } else {
      response.sendRedirect("registration");
    }
  }
}

