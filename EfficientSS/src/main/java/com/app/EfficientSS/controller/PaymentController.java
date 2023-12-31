package com.app.EfficientSS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.EfficientSS.beans.Payment;
import com.app.EfficientSS.service.PaymentService;



@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService pservice;

	
	@PostMapping("/customer/payment/{cust_id}/{item_Id}")
	public ResponseEntity custPayment(@RequestBody Payment payment,@PathVariable int cust_id,@PathVariable int item_Id){
		
		
		Payment pay=pservice.customerPayment(payment,cust_id,item_Id);
		if(pay!=null)
			return ResponseEntity.ok(pay);
		else 
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	


	@GetMapping("admin/payment")
	public ResponseEntity<List<Payment>> CheckPayment(){
		List<Payment> payments=pservice.CheckPayment();
		if(payments!=null)
			return ResponseEntity.ok(payments);
		else 
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

	}
	
	@GetMapping("/transporter/payment/{t_id}")
	public ResponseEntity<List<Payment>> transCheckPayment1(@PathVariable("t_id") long t_id){ 
		List<Payment> payments=pservice.transporterCheckPayment(t_id);
	
		if(payments!=null)
			return ResponseEntity.ok(payments);
		else 
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

	}
	
}



