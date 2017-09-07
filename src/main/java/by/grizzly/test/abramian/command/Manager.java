/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.command;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Abramian Roland Arturovich
 */
public class Manager {

    private static Map<String, Command> map;

    static {
	map = new HashMap<>();

	map.put("reports", new ServiceReports());
	map.put("lastCalendarYear", new ServiceLastCalendarYear());
	map.put("lastMonth", new ServiceLastMonth());
	map.put("lastQtr", new ServiceLastQtr());
	map.put("performer", new ServicePerformer());
	map.put("currentYearToDate", new ServiceCurrentYearToDate());
	map.put("currentQtrToDate", new ServiceCurrentQtrToDate());
	map.put("currentMonthToDate", new ServiceCurrentMonthToDate());
    }

    public static Command getCommand(String typeCommand) {
	return map.get(typeCommand);
    }

}
