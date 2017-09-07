/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.command;

import by.grizzly.test.abramian.dao.ReportDAOImpl;
import by.grizzly.test.abramian.dao.iReportDAO;
import by.grizzly.test.abramian.model.Report;
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
public class ServiceCurrentMonthToDate implements Command {

    public static final Logger LOGGER = Logger.getLogger(ServiceCurrentMonthToDate.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	LOGGER.info("Executing in ServiceCurrentMonthToDate.");

	iReportDAO reportDAO = new ReportDAOImpl();
	List<Report> listReports = new ArrayList<>();

	Calendar currentDate = new GregorianCalendar();

	//Setting time limits
	int startYaer = currentDate.get(Calendar.YEAR);
	int startMonth = currentDate.get(Calendar.MONTH);
	int startDay = 0;
	int endYear = startYaer;
	int endMonth = startMonth;
	int endDay = currentDate.get(Calendar.DAY_OF_MONTH);

	//Setting the date for the request
	Calendar startDate = new GregorianCalendar(
		startYaer,
		startMonth,
		startDay);

	Calendar endDate = new GregorianCalendar(
		endYear,
		endMonth,
		++endDay);

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
