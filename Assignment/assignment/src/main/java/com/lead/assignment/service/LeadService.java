package com.lead.assignment.service;

import java.util.List;

//LeadService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lead.assignment.exception.LeadExistsException;
import com.lead.assignment.model.Lead;
import com.lead.assignment.repository.LeadRepository;

@Service
public class LeadService {

 @Autowired
 private LeadRepository leadRepository;

 @Transactional
 public Lead createLead(Lead lead) {
     if (leadRepository.existsByLeadId(lead.getLeadId())) {
         throw new LeadExistsException("Lead Already Exists in the database with the lead id");
     }
     return leadRepository.save(lead);
 }

 public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
     return leadRepository.findByMobileNumber(mobileNumber);
 }
}
