package com.app.EfficientSS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EfficientSS.beans.Bidder;
import com.app.EfficientSS.service.BidderService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class BidderController {

	@Autowired
	private BidderService bservice;
	
	
	
	@PostMapping("customer/bidder/{item_Id}")
	public ResponseEntity<Bidder> setBidder(@RequestParam long t_id,@RequestParam int cust_id,@RequestParam double price,@PathVariable int item_Id){
		return bservice.setBidderNoAuction(t_id,item_Id,cust_id,price);
		
	}
	
	@GetMapping("customer/directhistory")
	public  ResponseEntity<List<Bidder>> DirectBidderH(){
		
		return bservice.HistoryDirectBidder();
	}
	
//	transporter/selectedBidders
	@GetMapping("transporter/selectedBidders/{t_id}")
	public ResponseEntity<List<Bidder>> getBidders(@PathVariable("t_id") long id){
		System.out.println("ijoij");

		List<Bidder> blist= bservice.ListofSelcetedandUnselectedBids(id);
		if(blist!=null)
			return ResponseEntity.ok(blist);
		else 
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

	}
}
