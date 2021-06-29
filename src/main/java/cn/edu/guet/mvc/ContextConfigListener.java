package cn.edu.guet.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Servlet3.0版本后支持注解方式实现监听器
 * 当程序打开时监听器也会自动运行
 * ServletContextListener:servlet上下文监听器
 * 自动读取controller.package中的控制器类，并存入application作用域。
 */
@WebListener()
public class ContextConfigListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ContextConfigListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        try {
            Map<String, ControllerMapping> controllerMapping = new Configuration().config();
            sce.getServletContext().setAttribute("cn.guet.web.controller", controllerMapping);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }
}