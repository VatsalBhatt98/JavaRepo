package com.lead.assignment.model;

import java.util.Date;

//Lead.java
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
public class Lead {

	@Id
	@NotNull(message = "LeadId is mandatory")
	@Positive(message = "LeadId should be a positive integer")
	private Integer leadId;

	@NotBlank(message = "First name is mandatory")
	@Pattern(regexp = "[a-zA-Z]+", message = "First name should contain only alphabets")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]+", message = "Middle name should contain only alphabets")
	private String middleName;

	@NotBlank(message = "Last name is mandatory")
	@Pattern(regexp = "[a-zA-Z]+", message = "Last name should contain only alphabets")
	private String lastName;

	@NotBlank(message = "Mobile number is mandatory")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
	private String mobileNumber;

	@NotBlank(message = "Gender is mandatory")
	@Pattern(regexp = "^(Male|Female|Others)$", message = "Invalid gender")
	private String gender;

	@NotNull(message = "Date of Birth is mandatory")
	private Date dob;

	@Email(message = "Invalid email")
	private String email;

	public Lead() {
		super();
	}

	public Lead(Integer leadId, String firstName, String middleName, String lastName, String mobileNumber,
			String gender,Date dob, String email) {
		this.leadId = leadId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}

	// Getters and setters
}
