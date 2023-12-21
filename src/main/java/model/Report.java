package model;

public class Report {
	private String reportType;
	private String reportTitle;
	private String reportUserName;
	private String reportContenet;
	
	public Report() {}
	
	public Report(String reportType, String reportTitle, String reportUserName, String reportContenet) {
		super();
		this.reportType = reportType;
		this.reportTitle = reportTitle;
		this.reportUserName = reportUserName;
		this.reportContenet = reportContenet;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public String getReportContenet() {
		return reportContenet;
	}

	public void setReportContenet(String reportContenet) {
		this.reportContenet = reportContenet;
	}
	
}
