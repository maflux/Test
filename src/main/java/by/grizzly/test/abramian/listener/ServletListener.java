/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.listener;

import by.grizzly.test.abramian.dao.ReportDAOImpl;
import by.grizzly.test.abramian.dao.iReportDAO;
import static by.grizzly.test.abramian.util.ImplConfig.ERROR_MSG;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 * Web application lifecycle listener.
 *
 * @author User
 */
public class ServletListener implements ServletContextListener {

    public static final Logger LOGGER = Logger.getLogger(ServletListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	LOGGER.info("Init ServletListener and ServletContext.");

	//Loding all performer from DB.
	iReportDAO reportDAO = new ReportDAOImpl();
	ServletContext sc = sce.getServletContext();
	try {
	    sc.setAttribute("listPerformers", reportDAO.getAllPerformer());
	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}
	sc.setAttribute("error", ERROR_MSG);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	LOGGER.info("Destroy ServletListener and ServletContext.");
    }
}
