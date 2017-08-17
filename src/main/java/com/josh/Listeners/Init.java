package com.josh.Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.josh.employee.EmployeeController;

/**
 * Application Lifecycle Listener implementation class Init
 *
 */
public class Init implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Init() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    		//<For Test Purposes>
    		EmployeeController controller = (EmployeeController) sce.getServletContext().getAttribute("controller");
    		controller.deleteAll();
    		//</For Test Purposes>
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");
    		
    		sce.getServletContext().setAttribute("controller", controller);
    }
	
}
