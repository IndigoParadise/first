package learning.proyect.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.proyect.mongodb.entity.Customer;
import learning.proyect.mongodb.serviceimpl.CustomerServiceImpl;
@RequestMapping(value="/customer")
@RestController(value="customer")
public class CustomerController {
	
	private CustomerServiceImpl customerService;

	@Autowired
	public CustomerController(CustomerServiceImpl customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping(value="/{customerNumber}")
	public Customer getCustomerById(@PathVariable(name="customerNumber") Integer customerNumber) {
		return this.customerService.findByCustomerNumber(customerNumber);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer){
		return this.customerService.saveCustomer(customer);
	}
	@DeleteMapping(value="/delete/{customerNumber}")
	public ResponseEntity<Void>deleteCustomerByCustomerNumber(@PathVariable("customerNumber") Integer customerNumber){
		return this.customerService.deleteCustomerByCustomerNumber(customerNumber);
	}
	@GetMapping(value="/firstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName")String firstName){
		return this.customerService.findByFirstName(firstName);
	}
	@GetMapping(value="/lastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName")String lastName){
		return this.customerService.findByLastName(lastName);
	}
	
	
	
	

}
