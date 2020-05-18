package com.gaurav.azure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.azure.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
