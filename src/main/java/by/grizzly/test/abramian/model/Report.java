/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grizzly.test.abramian.model;

import java.sql.Timestamp;
import org.apache.log4j.Logger;

/**
 *
 * @author Abramian Roland Arturovich
 */
//Entity
public class Report {

    public static final Logger LOGGER = Logger.getLogger(Report.class.getName());

    private long id;
    private Timestamp start;
    private Timestamp end;
    private String performer;
    private String activity;

    public Report() {
	LOGGER.info("Creating new class Report.");
    }

    public Report(long id, Timestamp start, Timestamp end, String performer, String activity) {
	LOGGER.info("Creating new class Report.");
	this.id = id;
	this.start = start;
	this.end = end;
	this.performer = performer;
	this.activity = activity;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Timestamp getStart() {
	return start;
    }

    public void setStart(Timestamp start) {
	this.start = start;
    }

    public Timestamp getEnd() {
	return end;
    }

    public void setEnd(Timestamp end) {
	this.end = end;
    }

    public String getPerformer() {
	return performer;
    }

    public void setPerformer(String performer) {
	this.performer = performer;
    }

    public String getActivity() {
	return activity;
    }

    public void setActivity(String activity) {
	this.activity = activity;
    }

    @Override
    public String toString() {
	return "Report{" + "id=" + id + ", start=" + start + ", end=" + end
		+ ", performer=" + performer + ", activity=" + activity + "}\n";
    }

}
