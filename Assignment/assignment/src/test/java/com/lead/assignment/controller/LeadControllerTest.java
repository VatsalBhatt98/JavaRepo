package com.lead.assignment.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lead.assignment.model.Lead;
import com.lead.assignment.service.LeadService;

@RunWith(SpringRunner.class)
@WebMvcTest(LeadController.class)
public class LeadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeadService leadService;

    @Test
    public void testGetLeadsByMobileNumber() throws Exception {
        List<Lead> leads = Arrays.asList(
                new Lead(5678, "Vineet", "", "KV", "8877887788", "Male", new Date(), "v@gmail.com"),
                new Lead(5679, "Vishal", "", "Sonar", "8877887788", "Male", new Date(), "vi@gmail.com")
        );

        when(leadService.getLeadsByMobileNumber("8877887788")).thenReturn(leads);

        mockMvc.perform(get("/api/leads/byMobileNumber/8877887788"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].leadId").value(5678))
                .andExpect(jsonPath("$.data[1].leadId").value(5679));

        verify(leadService, times(1)).getLeadsByMobileNumber(eq("8877887788"));
    }

    @Test
    public void testGetLeadsByMobileNumber_NoLeadsFound() throws Exception {
        when(leadService.getLeadsByMobileNumber("1234567890")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/leads/byMobileNumber/1234567890"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("E10011"))
                .andExpect(jsonPath("$.message").value("No Lead found with the Mobile Number 1234567890"));

        verify(leadService, times(1)).getLeadsByMobileNumber(eq("1234567890"));
    }
}