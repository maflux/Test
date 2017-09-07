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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ServicePerformer implements Command {

    public static final Logger LOGGER = Logger.getLogger(ServicePerformer.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

	LOGGER.info("Executing in ServicePerform.");

	iReportDAO reportDAO = new ReportDAOImpl();

	List<Report> listReports = new ArrayList<>();

	try {
	    listReports = reportDAO.getAllReportByPerformer(request.getParameter("performer"));
	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}

	request.setAttribute("listReports", listReports);

	return INDEX;
    }

}
