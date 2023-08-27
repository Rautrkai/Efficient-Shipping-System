import React, { Component } from 'react'
import NavBar from './NavBar'
import "../styles/Home.css";
import { Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';

export default class PickupDeliveryForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pickup_date: "",
            delivery_date: "",
            item_Id: JSON.parse(localStorage.getItem('item_Id')),
            
        }
      }
      handleChange1 = (a) => {
        this.setState({ pickup_date: a.target.value });
      
    
    }
    handleChange2 = (a) => {
        this.setState({ delivery_date: a.target.value });
      
    
    }

    
    submitForm = (e) => {
      
      console.log(this.state.item_Id,this.state.pickup_date,this.state.delivery_date);
        const url = "http://localhost:8282/transporter/pickupdeliverydate?item_Id=" + this.state.item_Id + "&pickupDate=" + this.state.pickup_date + "&deliveryDate=" + this.state.delivery_date;
        fetch(url,{method:"PUT"}
        ).then(response => response.json())
                .then(data => 
                    { 
                });
                alert("Pickup and Delivery date updated successfully");
                window.location.href="/pickupDelivery";
    
    }
    
       
    

  render() {

    return (
        <div>
        
        <NavBar/>
        <Form style={{paddingTop:"120px"}}>
        <h3>Enter Your Pickup Date</h3><br/>
  
    <Row form>
      <Col md={6}>
        <FormGroup>
        <Label for="pickup_date">
          Pickup Date
            </Label>
            <Input
            id="pickup_date"
            name="pickup_date"
            placeholder="Enter Pickup Date"
            type="date"
            value={this.state.pickup_date}
            onChange={this.handleChange1}
          />
        </FormGroup>
        <FormGroup>
        <Label for="delivery_date">
          Delivery Date
            </Label>
            <Input
            id="delivery_date"
            name="delivery_date"
            placeholder="Enter Delivery Date"
            type="date"
            value={this.state.delivery_date}
            onChange={this.handleChange2}
          />
        </FormGroup>
       
      </Col>
      </Row>
      <Button
     onClick={this.submitForm}
      > 
      Submit
    </Button>
  </Form>
       </div>
      
      )
    }
  }