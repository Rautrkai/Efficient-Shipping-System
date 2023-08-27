import React, { Component } from 'react'
import DirectBookingService from '../components/userService/DirectBookingService'
import { Button, Table } from 'reactstrap'
import NavBar from './NavBar'
import "../styles/Home.css";


const item_Id = localStorage.getItem('item_Id');
export default class DirectBooking extends Component {

  
  constructor(props) {
    super(props)

    this.state = {
        transporters: [],
            estimated:[]
    }
  
    
}


getTransporterById(t_id){
    
    DirectBookingService.getTransporterById(t_id,item_Id).then(res => {
        this.setState({ estimated: res.data });
    
        // Convert the object to a JSON string and store it in localStorage
        this.setState({ estimated: res.data});
        localStorage.setItem('price',res.data.price)
        localStorage.setItem('distance',res.data.distance)
        localStorage.setItem('price_per_km',res.data.price_per_km)
        localStorage.setItem('item_weight',res.data.item_weight)
        localStorage.setItem('t_id',t_id)

    
        console.log(this.state.estimated);
            
        window.location.href = "/estimatedPriceList";
    });
    
}



componentDidMount(){
    DirectBookingService.getTransporters().then((res) => {
        this.setState({ transporters: res.data});
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
                  <th> Transporter Full Name  </th>
                  <th>Transporter Address </th>
                  <th>Estimated Price</th>

                
                </tr>
              </thead>
              <tbody>
              {
                                    this.state.transporters.map(
                                        transporter => 
                                        <tr key = {transporter.t_id}>
                                            <td>{transporter.t_id}</td>
                                             <td> { transporter.t_full_name} </td>   
                                             <td> {transporter.t_address}</td>
                                             <td>                                      <button style={{marginLeft: "20px"}} 
                                                  onClick={ () => this.getTransporterById(transporter.t_id,item_Id)} 
                                                  className="btn btn-info">View estimated Price </button>
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

