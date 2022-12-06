package servlet;

import lombok.extern.slf4j.Slf4j;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    userService = (UserService) config.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    try {
      userService.createUser(login, password);
    } catch (Exception ex) {
      resp.sendRedirect("registration?error=" + ex.getMessage());
      return;
    }
    getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);
  }
}
