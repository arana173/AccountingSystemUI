/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Vijay Rana
 */
public class ReportType {

    String reportTypeId;
    String reportTypeName;
    Boolean active;

    public ReportType(String reportTypeId, String reportTypeName, Boolean active) {
        this.reportTypeId = reportTypeId;
        this.reportTypeName = reportTypeName;
        this.active = active;
    }

    public String getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(String reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ReportType() {
    }
}
