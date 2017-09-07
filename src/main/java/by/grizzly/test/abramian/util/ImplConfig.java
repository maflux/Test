/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.util;

import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
//L
public class ImplConfig {

    public static final Logger LOGGER = Logger.getLogger(ImplConfig.class.getName());

    public static final ResourceBundle bundle;

    static {
	LOGGER.info("Loading configuration variables.");
	bundle = ResourceBundle.getBundle("cfg",
		new Locale("cfg"));
    }

    //Loading configuration vars
    public static final String ERROR_MSG = bundle.getString("ERROR_MSG");
    public static final String INDEX = bundle.getString("INDEX");
    public static final String DRIVER = bundle.getString("driver");
    public static final String LOGIN = bundle.getString("login");
    public static final String PASSWORD = bundle.getString("password");
    public static final String URL = bundle.getString("url");
    public static final String SQL = bundle.getString("SQL");
    public static final String GET_ALL_PERFORMER = bundle.getString("GET_ALL_PERFORMER");
    public static final String GET_ALL_REPORT_BY_PERFORMER = bundle.getString("GET_ALL_REPORT_BY_PERFORMER");

}
