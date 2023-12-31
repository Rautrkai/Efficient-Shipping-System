package com.app.EfficientSS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EfficientSS.beans.Customer;
import com.app.EfficientSS.beans.Feedback;
import com.app.EfficientSS.service.FeedbackService;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/customer/feedback")
	public ResponseEntity<String> CustomerFeedback(@RequestBody  Feedback feedback,@RequestParam int cust_id)
	{
		System.out.println(feedback);
		feedbackService.registerCustFeedback(feedback,cust_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("transporter/feedback")
	public ResponseEntity<String> transporterFeedback(@RequestBody  Feedback feedback,@RequestParam int t_id)
	{
		System.out.println(feedback);
		feedbackService.registerTransfeedback(feedback,t_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("admin/feedback")
	public ResponseEntity<List<Feedback>> getAllFeedback()
	{
		
		List<Feedback> feedbacks=feedbackService.getAll();
		if (feedbacks!=null)
		return ResponseEntity.ok(feedbacks);
		else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
	}
}
