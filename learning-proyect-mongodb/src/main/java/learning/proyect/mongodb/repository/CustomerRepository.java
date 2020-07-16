package learning.proyect.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import learning.proyect.mongodb.entity.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	public List<Customer> findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	public Optional<Customer> findById(String id);
	public Optional<Customer> findByCustomerNumber(Integer customerNumber);
	public Optional<Customer> deleteByCustomerNumber(Integer customerNumber);
	
}
