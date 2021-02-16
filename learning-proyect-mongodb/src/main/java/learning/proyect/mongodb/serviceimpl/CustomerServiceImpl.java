package learning.proyect.mongodb.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import learning.proyect.mongodb.entity.Customer;
import learning.proyect.mongodb.exception.DeleteCustomerException;
import learning.proyect.mongodb.exception.SaveCustomerException;
import learning.proyect.mongodb.exception.SearchCustomerException;
import learning.proyect.mongodb.repository.CustomerRepository;
import learning.proyect.mongodb.service.CustomertService;
@Service
public class CustomerServiceImpl implements CustomertService {
	//Comment done so i can do a quick push
	public CustomerRepository customerRepository;
	private static int BREAK_LOOP=1;
	private static int START_LOOP=0;
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Optional<Customer> findById(String id) {
		return this.customerRepository.findById(id);
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return this.customerRepository.findByFirstName(firstName);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return this.customerRepository.findByLastName(lastName);
	}

	@Override
	public ResponseEntity<Void> saveCustomer(Customer customer) throws SaveCustomerException {
		if(customer.getCustomerNumber()!= null)
			throw  new SaveCustomerException("Error trying to save entity");
		int i=this.START_LOOP;
		Random random= new Random();
		Integer customerNumber;
		while(i!=this.BREAK_LOOP) {
			customerNumber=random.nextInt(2000000);
			Optional<Customer> existingCustomer=this.customerRepository.findByCustomerNumber(customerNumber);
			if(existingCustomer.isEmpty()) {
				customer.setCustomerNumber(customerNumber);
				i=this.BREAK_LOOP;
			}
				
		}
		try{
			this.customerRepository.save(customer);
		}catch(Exception e) {
			throw  new SaveCustomerException("Error trying to save entity");
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCustomerByCustomerNumber(Integer customerNumber) {
		 this.customerRepository.deleteByCustomerNumber(customerNumber).orElseThrow(()-> new DeleteCustomerException("Could not delete customer"));
		 return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public Customer findByCustomerNumber(Integer customerNumber) {
		
		
		return this.customerRepository.findByCustomerNumber(customerNumber).orElseThrow(()-> new SearchCustomerException("Customer not Found"));
	}

}
