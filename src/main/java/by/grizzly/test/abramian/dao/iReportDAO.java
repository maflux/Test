/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.dao;

import by.grizzly.test.abramian.model.Report;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author User
 */
public interface iReportDAO {

    List<Report> findByTime(Timestamp start, Timestamp end) throws SQLException;

    List<String> getAllPerformer() throws SQLException;

    List<Report> getAllReportByPerformer(String performer) throws SQLException;

}
