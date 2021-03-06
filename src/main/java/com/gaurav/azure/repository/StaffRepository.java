package com.gaurav.azure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.azure.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
}
