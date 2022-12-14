package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FriendService;
import service.RequestFriendService;
import service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(final ServletContextEvent sce) {

    final ApplicationContext context = new ClassPathXmlApplicationContext("lesson32.xml");
    final UserService userService = context.getBean(UserService.class);
    final FriendService friendService = context.getBean(FriendService.class);
    final RequestFriendService requestFriendService = context.getBean(RequestFriendService.class);
    sce.getServletContext().setAttribute("userService", userService);
    sce.getServletContext().setAttribute("friendService", friendService);
    sce.getServletContext().setAttribute("requestFriendService", requestFriendService);

  }
}

