package com.lead.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead.assignment.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {
    boolean existsByLeadId(Integer leadId);
    List<Lead> findByMobileNumber(String mobileNumber);
}