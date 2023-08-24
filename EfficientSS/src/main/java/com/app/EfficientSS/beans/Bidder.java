package com.app.EfficientSS.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="b_id")
	private int b_id;
	@Column(name="b_price",nullable=false)
	private double B_price;
	@Column(name="b_name")
	private String B_name;
	@Column(name="b_ph_no")
	private String B_ph_no;
	@Column(name="b_selection_status")
	private String B_selection_status;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="t_id",referencedColumnName="t_id")
	private Transporter transporter;
	
	
//	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name="Auction_Item_Bidder", 
//                joinColumns={@JoinColumn(name="b_id")}, 
//                inverseJoinColumns={@JoinColumn(name="a_id")})
//    private List<Auction_Item> auction_item;

	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bidder")
	private List<Item_Details> item_detail;


    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "bidders")
    private List<Customer> customers;

   

	public Bidder() {
		super();
	}


	public Bidder(int b_id, double b_price, String b_name, String b_ph_no, String b_selection_status,
			Transporter transporter, List<Item_Details> item_detail, List<Customer> customers) {
		super();
		this.b_id = b_id;
		B_price = b_price;
		B_name = b_name;
		B_ph_no = b_ph_no;
		B_selection_status = b_selection_status;
		this.transporter = transporter;
		this.item_detail = item_detail;
		this.customers = customers;
	}


	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		b_id = b_id;
	}

	public double getB_price() {
		return B_price;
	}

	public void setB_price(double price) {
		B_price = price;
	}

	public String getB_name() {
		return B_name;
	}

	public void setB_name(String b_name) {
		B_name = b_name;
	}

	public String getB_ph_no() {
		return B_ph_no;
	}

	public void setB_ph_no(String b_ph_no) {
		B_ph_no = b_ph_no;
	}

	public String getB_selection_status() {
		return B_selection_status;
	}

	public void setB_selection_status(String b_selection_status) {
		B_selection_status = b_selection_status;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	

	public List<Item_Details> getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(List<Item_Details> item_detail) {
		this.item_detail = item_detail;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	@Override
	public String toString() {
		return "Bidder [b_id=" + b_id + ", B_price=" + B_price + ", B_name=" + B_name + ", B_ph_no=" + B_ph_no
				+ ", B_selection_status=" + B_selection_status + ", transporter=" + transporter + ", item_detail="
				+ item_detail + ", customers=" + customers + "]";
	}

	
    
}
