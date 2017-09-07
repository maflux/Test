/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.dao;

import static by.grizzly.test.abramian.util.ImplConfig.*;
import by.grizzly.test.abramian.model.Report;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class ReportDAOImpl implements iReportDAO {

    public static final Logger LOGGER = Logger.getLogger(ReportDAOImpl.class.getName());

    static Connection connection;

    static {
	try {

	    LOGGER.info("Loading mysql driver.");
	    //Connect the driver
	    Class.forName(DRIVER);

	    //Get a coonection
	    connection = DriverManager.getConnection(
		    URL,
		    LOGIN,
		    PASSWORD);

	} catch (ClassNotFoundException | SQLException ex) {
	    LOGGER.error(ex);
	}
    }

    @Override
    public List<Report> findByTime(Timestamp start, Timestamp end) throws SQLException {
	LOGGER.info("Query to DB.");

	List<Report> tempReports = new ArrayList<>();
	try {

	    //Prepare Query
	    CallableStatement callableStatement = connection.prepareCall(SQL);

	    //Set custom values to a query
	    callableStatement.setTimestamp(1, start);
	    callableStatement.setTimestamp(2, end);

	    //Get the query result after execute Query
	    ResultSet resultSet = callableStatement.executeQuery();

	    //Save the result in the list
	    while (resultSet.next()) {
		tempReports.add(new Report(
			resultSet.getInt("ID"),
			resultSet.getTimestamp("StartDate"),
			resultSet.getTimestamp("EndDate"),
			resultSet.getString("Performer"),
			resultSet.getString("Activity")));
	    }

	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}
	return tempReports;
    }

    @Override
    public List<String> getAllPerformer() throws SQLException {
	LOGGER.info("Query to DB.");
	List<String> tempPerformers = new ArrayList<>();
	try {

	    //Prepare Query
	    CallableStatement callableStatement = connection.prepareCall(GET_ALL_PERFORMER);

	    //Get the query result after execute Query
	    ResultSet resultSet = callableStatement.executeQuery();

	    //Save the result in the list
	    while (resultSet.next()) {
		tempPerformers.add(resultSet.getString("Performer"));
	    }

	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}
	return tempPerformers;
    }

    @Override
    public List<Report> getAllReportByPerformer(String performer) throws SQLException {

	LOGGER.error("Query to DB.");

	List<Report> tempPerformers = new ArrayList<>();
	try {

	    //Prepare Query
	    CallableStatement callableStatement = connection.prepareCall(GET_ALL_REPORT_BY_PERFORMER);

	    //Set custom values to a query
	    callableStatement.setString(1, performer);

	    //Get the query result after execute Query
	    ResultSet resultSet = callableStatement.executeQuery();

	    //Save the result in the list
	    while (resultSet.next()) {
		tempPerformers.add(new Report(
			resultSet.getInt("ID"),
			resultSet.getTimestamp("StartDate"),
			resultSet.getTimestamp("EndDate"),
			resultSet.getString("Performer"),
			resultSet.getString("Activity")));
	    }

	} catch (SQLException ex) {
	    LOGGER.error(ex);
	}
	return tempPerformers;
    }

}
