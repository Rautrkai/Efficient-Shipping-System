package com.app.EfficientSS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.EfficientSS.beans.Customer;
import com.app.EfficientSS.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerdao;
	

	@Override
	public ResponseEntity<List<Customer>> getAllCustomer() {
		
		List<Customer> customer=customerdao.findAll();
		if(customer.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}


	@Override
	public ResponseEntity<String> CustomerRegistration(Customer customer) {
		customer.setCust_blacklist("clear");
		customerdao.save(customer);
		return null;
	}


	
		
		public void updateCustomer(Customer c) {
			Optional<Customer> op=customerdao.findById(c.getCust_id());
			if(op.isPresent()) {
				Customer editcust=op.get();
				editcust.setCust_fName(c.getCust_fName());
				editcust.setCust_mName(c.getCust_mName());
				editcust.setCust_lName(c.getCust_lName());
				editcust.setCust_email_id(c.getCust_email_id());
				editcust.setCust_password(c.getCust_password());
				editcust.setCust_phone_no(c.getCust_phone_no());
				editcust.setCust_blacklist(c.getCust_blacklist());
				editcust.setCust_address(c.getCust_address());
				
				customerdao.save(editcust);
			}
			
			
	}


		@Override
		public Customer getCustomerById(int cid) {
			Optional<Customer> op=customerdao.findById(cid);
			if(op.isPresent()) {
				return op.get();
			}
			else{
				return null;
				//throw new ResourceAccessException("not found");
			}
		}


		@Override
		public void deleteCustomerById(int cid) {
			customerdao.deleteById(cid);
		}


		@Override
		public Customer validateCustomer(Customer cust) {
			String s=cust.getCust_email_id();
			Customer customer=customerdao.findByEmail(s);
			System.out.println(customer.getCust_blacklist());
			if(cust.getCust_email_id().equals(customer.getCust_email_id()) && cust.getCust_password().equals(customer.getCust_password() )&& customer.getCust_blacklist().equalsIgnoreCase("clear"))
			return customer;
			else 
				return null;
		}


		
	
	
}
