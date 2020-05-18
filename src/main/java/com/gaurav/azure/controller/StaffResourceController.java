package com.gaurav.azure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.azure.exception.ResourceNotFoundException;
import com.gaurav.azure.model.Staff;
import com.gaurav.azure.repository.StaffRepository;

@RestController

public class StaffResourceController {
	
	@RequestMapping(method=RequestMethod.GET, value= "/")
	public String WelcomeMessage() {
		return "Welcome to API - APP in Azure. This is a Spring Boot & JPA Application."
				+ "This Connects to an Azure SQL Server Application for Data Storage.";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/helloworld")
	public String helloWorld() {
		return "Hello World - Updated!!!";
	}

    @Autowired
    private StaffRepository staffRepository;

    @RequestMapping(method=RequestMethod.GET, value="/staffs")
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable(value = "id") Integer staffId)
        throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(staffId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + staffId));
        return ResponseEntity.ok().body(staff);
    }
    
    @PostMapping("/staffs")
    public @Valid Staff createStaff(@Valid @RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable(value = "id") Integer staffId,
         @Valid @RequestBody Staff StaffDetails) throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(staffId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + staffId));

        staff.setEmail(StaffDetails.getEmail());
        staff.setLast_name(StaffDetails.getLast_name());
        staff.setFirst_name(StaffDetails.getFirst_name());
        final Staff updatedStaff = staffRepository.save(staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/staff/{id}")
    public Map<String, Boolean> deleteStaff(@PathVariable(value = "id") Integer staffId)
         throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(staffId)
       .orElseThrow(() -> new ResourceNotFoundException("Staff not found for this id :: " + staffId));

        staffRepository.delete(staff);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}