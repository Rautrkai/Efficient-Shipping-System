import React, { Component } from 'react'
import { Button, Table } from 'reactstrap'
import NavBar from './NavBar'
import DirectBookingService from '../components/userService/DirectBookingService'

export default class AuctionDetails extends Component{

  
  constructor(props) {
    super(props)

    this.state = {
        items: []
    }
  
}


getAuctionItemsById(a_item_id,cust_id)
{
    console.log(a_item_id);
    console.log(cust_id);
    localStorage.setItem('a_item_id',a_item_id);
    localStorage.setItem('cust_id',cust_id);
    alert(cust_id)
    window.location.href = "/bidNow";
   
}




componentDidMount(){
   
    DirectBookingService.getAuctionItems().then((res) => {
        this.setState({ items: res.data});
        console.log(this.state.items);

    });

    

}
render() {

  return (
    <div>
      <NavBar/>
      <div style={{paddingTop:"120px", paddingLeft:"20px" , paddingRight:"20px" }}>
      <Table bordered striped>
  <thead>
    <tr>
      <th>No</th>
      <th>Customer First Name</th>
      <th>Customer Last Name</th>
      <th> Item Name </th>
      <th> Item Weight</th>
      <th> Pickup City </th>
      <th>Delivery City</th>
      <th>Highest Price</th>

      <th> Actions </th>
    </tr>
  </thead>
  <tbody>
  {
                                    this.state.items.map(
                                        auction => 
                                        <tr key = {auction.a_item_id}>
                                           <td>{auction.a_item_id}</td>
                                        <td>{auction.customer.cust_fName}</td>
                                        <td>{auction.customer.cust_lName}</td>
                                        <td>{auction.item_detail.item_name}</td>
                                        <td>{auction.item_detail.item_weight}</td>
                                        <td>{auction.item_detail.pickup_city}</td>
                                        <td>{auction.item_detail.delivery_city}</td>
                                        <td>{auction.highest_bid_price}</td>
                                             <td>
                                             
                                                 {/* <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.i_id)} className="btn btn-info">View </button> */}
                                                 <button style={{marginLeft: "20px"}}  
                                                  onClick={ () => this.getAuctionItemsById(auction.a_item_id,auction.customer.cust_id)} 
                                                 className="btn btn-warning">  Bid Now</button>

                                              
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </Table>

                 </div>

            </div>
        )
    }
}
