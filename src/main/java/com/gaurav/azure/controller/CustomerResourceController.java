package com.gaurav.azure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.azure.exception.ResourceNotFoundException;
import com.gaurav.azure.model.Customer;
import com.gaurav.azure.repository.CustomerRepository;

@RestController
public class CustomerResourceController {
	
	@Autowired
    private CustomerRepository customerRepository;
	
    @RequestMapping(method=RequestMethod.GET, value="/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.GET, value="/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }
    
    @PostMapping("/customers")
    public @Valid Customer createCustomers(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer customerId,
         @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        
        customer.setFirst_name(customerDetails.getFirst_name());
        customer.setLast_name(customerDetails.getLast_name());
        customer.setStreet(customerDetails.getStreet());
        customer.setZip_code(customerDetails.getZip_code());
        customer.setState(customerDetails.getState());
        customer.setCity(customerDetails.getCity());
        customer.setEmail(customerDetails.getEmail());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
	
    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer customerId)
         throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
       .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}