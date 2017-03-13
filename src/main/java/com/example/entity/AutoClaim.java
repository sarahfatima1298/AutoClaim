package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autoclaim")
public class AutoClaim implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name = "claimstatus")
	private String claimstatus;

	@Column(name = "payments")
	private String payments;

	@Column(name = "incidentdate")
	private String incidentdate;

	@Column(name = "reporteddate")
	private String reporteddate;

	@Column(name = "incidenttype")
	private String incidenttype;

	@Column(name = "year")
	private String year;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "vin")
	private String vin;

	@Column(name = "driver")
	private String driver;

	@Column(name = "contactnumber")
	private String contactnumber;

	@Column(name = "email")
	private String email;

	@Column(name = "policynumber")
	private String policynumber;

	@Column(name = "policytype")
	private String policytype;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClaimstatus() {
		return claimstatus;
	}

	public void setClaimstatus(String claimstatus) {
		this.claimstatus = claimstatus;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public String getIncidentdate() {
		return incidentdate;
	}

	public void setIncidentdate(String incidentdate) {
		this.incidentdate = incidentdate;
	}

	public String getReporteddate() {
		return reporteddate;
	}

	public void setReporteddate(String reporteddate) {
		this.reporteddate = reporteddate;
	}

	public String getIncidenttype() {
		return incidenttype;
	}

	public void setIncidenttype(String incidenttype) {
		this.incidenttype = incidenttype;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public String getPolicytype() {
		return policytype;
	}

	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}

	@Override
	public String toString() {
		return "AutoClaim [id=" + id + ", claimstatus=" + claimstatus
				+ ", payments=" + payments + ", incidentdate=" + incidentdate
				+ ", reporteddate=" + reporteddate + ", incidenttype="
				+ incidenttype + ", year=" + year + ", make=" + make
				+ ", model=" + model + ", vin=" + vin + ", driver=" + driver
				+ ", contactnumber=" + contactnumber + ", email=" + email
				+ ", policynumber=" + policynumber + ", policytype="
				+ policytype + "]";
	}

	public AutoClaim() {}

	public AutoClaim(long id, String claimstatus, String payments,
			String incidentdate, String reporteddate, String incidenttype,
			String year, String make, String model, String vin, String driver,
			String contactnumber, String email, String policynumber,
			String policytype) {
		super();
		this.id = id;
		this.claimstatus = claimstatus;
		this.payments = payments;
		this.incidentdate = incidentdate;
		this.reporteddate = reporteddate;
		this.incidenttype = incidenttype;
		this.year = year;
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.driver = driver;
		this.contactnumber = contactnumber;
		this.email = email;
		this.policynumber = policynumber;
		this.policytype = policytype;
	}


}
