package learning.proyect.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import learning.proyect.mongodb.entity.Customer;

public interface CustomertService {
	
	public Optional<Customer> findById(String id);
	public Customer findByCustomerNumber(Integer customerNumber);
	public List<Customer>findByFirstName(String firstName);
	public List<Customer>findByLastName(String lastName);
	public ResponseEntity<Void>saveCustomer(Customer customer);
	public ResponseEntity<Void>deleteCustomerByCustomerNumber(Integer id);
	

}
