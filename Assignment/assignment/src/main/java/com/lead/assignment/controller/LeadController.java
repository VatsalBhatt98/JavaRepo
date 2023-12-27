package com.lead.assignment.controller;

import java.util.List;

import javax.validation.Valid;

//LeadController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead.assignment.exception.ApiResponse;
import com.lead.assignment.exception.ErrorResponse;
import com.lead.assignment.exception.SuccessResponse;
import com.lead.assignment.model.Lead;
import com.lead.assignment.service.LeadService;

@RestController
@RequestMapping("/api/leads")
@Validated
public class LeadController {

 @Autowired
 private LeadService leadService;

 @PostMapping
 public ResponseEntity<?> createLead(@Valid @RequestBody Lead lead) {
     leadService.createLead(lead);
     return ResponseEntity.ok(new ApiResponse("success", "Created Leads Successfully"));
 }

 @GetMapping("/byMobileNumber/{mobileNumber}")
 public ResponseEntity<?> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
     List<Lead> leads = leadService.getLeadsByMobileNumber(mobileNumber);

     if (leads.isEmpty()) {
         ErrorResponse errorResponse = new ErrorResponse("E10011", "No Lead found with the Mobile Number " + mobileNumber);
         return ResponseEntity.status(404).body(errorResponse);
     } else {
         return ResponseEntity.ok(new SuccessResponse("success", leads));
     }
 }
}
