package com.gaurav.azure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.azure.exception.ResourceNotFoundException;
import com.gaurav.azure.model.Store;
import com.gaurav.azure.repository.StoreRepository;

@RestController

public class StoreResourceController {
	
	@Autowired
    private StoreRepository storeRepository;

    
    @RequestMapping(method=RequestMethod.GET, value="/stores")
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/stores/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable(value = "id") Integer storeId)
        throws ResourceNotFoundException {
        Store store = storeRepository.findById(storeId)
          .orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + storeId));
        return ResponseEntity.ok().body(store);
    }
    
    @PostMapping("/stores")
    public @Valid Store createStores(@Valid @RequestBody Store store) {
        return storeRepository.save(store);
    }

    @PutMapping("/store/{id}")
    public ResponseEntity<Store> updateStaff(@PathVariable(value = "id") Integer storeId,
         @Valid @RequestBody Store StoreDetails) throws ResourceNotFoundException {
        Store store = storeRepository.findById(storeId)
        .orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + storeId));
        
        store.setStore_name(StoreDetails.getStore_name());
        store.setStreet(StoreDetails.getStreet());
        store.setZip_code(StoreDetails.getZip_code());
        store.setState(StoreDetails.getState());
        store.setCity(StoreDetails.getCity());
        store.setEmail(StoreDetails.getEmail());
        final Store updatedStores = storeRepository.save(store);
        return ResponseEntity.ok(updatedStores);
    }

    @DeleteMapping("/store/{id}")
    public Map<String, Boolean> deleteStore(@PathVariable(value = "id") Integer storeId)
         throws ResourceNotFoundException {
        Store store = storeRepository.findById(storeId)
       .orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + storeId));

        storeRepository.delete(store);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}