package model;


import io.searchbox.annotations.JestId;

import java.sql.Timestamp;


/**
 * Metrics model class
 *
 * @author alberto fidalgo
 * Created On 3/12/2019
 */
public class Metrics {


    @JestId
    private String id;
    private String fileName;
    private String billingDate;
    private double rowCount;
    private double startingRowCount;
    private double expectedRowCount;
    private Timestamp timestamp;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public double getRowCount() {
        return rowCount;
    }

    public void setRowCount(double rowCount) {
        this.rowCount = rowCount;
    }

    public double getStartingRowCount() {
        return startingRowCount;
    }

    public void setStartingRowCount(double startingRowCount) {
        this.startingRowCount = startingRowCount;
    }

    public double getExpectedRowCount() {
        return expectedRowCount;
    }

    public void setExpectedRowCount(double expectedRowCount) {
        this.expectedRowCount = expectedRowCount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }



}
