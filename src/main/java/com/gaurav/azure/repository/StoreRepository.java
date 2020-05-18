package com.gaurav.azure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.azure.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
	
}
