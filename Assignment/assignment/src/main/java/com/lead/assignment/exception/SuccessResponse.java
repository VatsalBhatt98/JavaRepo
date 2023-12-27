package com.lead.assignment.exception;

import java.util.List;

import com.lead.assignment.model.Lead;

public class SuccessResponse {

    private String status;
    private List<Lead> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Lead> getData() {
		return data;
	}
	public SuccessResponse(String status, List<Lead> data) {
		super();
		this.status = status;
		this.data = data;
	}
	public void setData(List<Lead> data) {
		this.data = data;
	}

}