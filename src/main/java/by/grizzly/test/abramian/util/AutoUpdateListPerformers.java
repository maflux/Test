/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.util;

import by.grizzly.test.abramian.dao.ReportDAOImpl;
import by.grizzly.test.abramian.dao.iReportDAO;
import static by.grizzly.test.abramian.util.ImplConfig.ERROR_MSG;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
//
public class AutoUpdateListPerformers {

    public static final Logger LOGGER = Logger.getLogger(AutoUpdateListPerformers.class.getName());

    public static void updateListPerformers(HttpServletRequest request, HttpServletResponse response) {
	LOGGER.info("Auto-update list porformers started.");

	//After any request from the user, the field Perfomer on page is updated
	iReportDAO reportDAO = new ReportDAOImpl();
	ServletContext sc = request.getServletContext();
	try {
	    sc.setAttribute("listPerformers", reportDAO.getAllPerformer());
	} catch (SQLException ex) {
	    LOGGER.error(ex);
	    sc.setAttribute("error", ERROR_MSG);
	}
	LOGGER.info("Auto-update list porformers finished.");
    }

}
