/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.command;

import by.grizzly.test.abramian.dao.ReportDAOImpl;
import by.grizzly.test.abramian.dao.iReportDAO;
import by.grizzly.test.abramian.model.Report;
import static by.grizzly.test.abramian.util.ImplConfig.ERROR_MSG;
import static by.grizzly.test.abramian.util.ImplConfig.INDEX;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServiceReports implements Command {

    public static final Logger LOGGER = Logger.getLogger(ServiceReports.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	LOGGER.info("Execute in ServiceReports.");

	//Setting the date for the request
	Calendar startDate = new GregorianCalendar(
		Integer.parseInt(request.getParameter("startYear")),
		Integer.parseInt(request.getParameter("startMonth")),
		Integer.parseInt(request.getParameter("startDay")));

	Calendar endDate = new GregorianCalendar(
		Integer.parseInt(request.getParameter("endYear")),
		Integer.parseInt(request.getParameter("endMonth")),
		Integer.parseInt(request.getParameter("endDay")));

	iReportDAO reportDAO = new ReportDAOImpl();

	List<Report> listReports = new ArrayList<>();

	try {
	    listReports = reportDAO.findByTime(
		    new Timestamp(startDate.getTimeInMillis()),
		    new Timestamp(endDate.getTimeInMillis()));
	    request.setAttribute("listReports", listReports);
	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}

	return INDEX;
    }

}
