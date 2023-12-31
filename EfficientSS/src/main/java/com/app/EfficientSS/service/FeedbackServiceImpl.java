package com.app.EfficientSS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.EfficientSS.beans.Customer;
import com.app.EfficientSS.beans.Feedback;
import com.app.EfficientSS.beans.Transporter;
import com.app.EfficientSS.dao.CustomerDao;
import com.app.EfficientSS.dao.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService  {

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private CustomerService  customerservice;
	
	@Autowired
	private TransporterService transporterService;
	
	@Override
	public void registerCustFeedback(Feedback feedback, int cust_id) {
		
			Customer cust=customerservice.getCustomerById(cust_id);
			feedback.setCustomer(cust);
			
			feedback.setCust_Name(cust.getCust_fName()+" "+cust.getCust_mName()+" "+cust.getCust_lName());
			Feedback feedcomp=feedbackDao.save(feedback);
	}
	

	@Override
	public List<Feedback> getAll() {
		
		return feedbackDao.findAll();
	}


	@Override
	public void registerTransfeedback(Feedback feedback, int t_id) {
		Transporter tran =transporterService.getTransporterById(t_id);
		feedback.setTransporter_name(tran.getT_full_name());
		feedbackDao.save(feedback);
		
	}

}
