import React, { Component } from 'react';
import RestApi from '../API/RestApi';

// Component class shows user input form which collect the data and store in the database. 
class PostRecord extends Component {

  constructor(props){
      super(props)

      this.state = {
          first_name:'',
          last_name:'',
          email:''
      }
          this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
          this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
          this.changeEmailHandler = this.changeEmailHandler.bind(this);

      }
  
      change = (e) => {
          this.setState({[e.target.name]:e.target.value})
      }

      submitHandler = e => {
          e.preventDefault()
          console.log(this.state)      
          .then(response => {
              console.log(response.data)                
          })
          .catch(details =>{
              console.log(details)                
          }) 
      }

      // Name change handler
      changeFirstNameHandler = (event) => {
          this.setState({first_name: event.target.value})
          console.log(this.state.first_name)
      }

      // Last name change handler
      changeLastNameHandler = (event) => {
          this.setState({last_name: event.target.value})
      }

      // Email change handler
      changeEmailHandler = (event) => {
          this.setState({email: event.target.value})
      } 

      // Save the data method call
      saveEmployee = (e) => {
          e.preventDefault();
          let empoyee = {
                          first_name: this.state.first_name,
                        last_name: this.state.last_name,
                        email: this.state.email
                      }
                                      
                        // call Rest Api for data save 
                        RestApi.saveData(empoyee)
                        .then(response => {
                          console.log(response)  
                          this.props.history.push('/');              
                      })
                      .catch(details =>{
                          console.log(details)                
                      })               
      }

      // cancel button 
      cancelEmployee = (e) => {
        this.props.history.push('/');
      }

   render() {      

       return(
         
          <div>
              <br></br>
                 <div className = "container col-md-6">
                      <div className = "row" >
                          <div className = "card col-md-12 offset-md-16 offset-md-0">
                              <h3 className="text-center">Update Employee</h3>
                              <div className = "card-body">
                                  <form>
                                      <div className = "form-group">
                                          <label> First Name: </label>
                                          <input placeholder="First Name" name="firstName" className="form-control" 
                                              value={this.state.first_name} onChange={this.changeFirstNameHandler}/>
                                      </div>
                                      <div className = "form-group">
                                          <label> Last Name: </label>
                                          <input placeholder="Last Name" name="lastName" className="form-control" 
                                              value={this.state.last_name} onChange={this.changeLastNameHandler}/>
                                      </div>
                                      <div className = "form-group">
                                          <label> Email Id: </label>
                                          <input placeholder="Email Address" name="emailId" className="form-control" 
                                              value={this.state.email} onChange={this.changeEmailHandler}/>
                                      </div>

                                      <button className="btn btn-success" onClick={this.saveEmployee}>Save</button>
                                      <button className="btn btn-danger" onClick={this.cancelEmployee} style={{marginLeft: "10px"}}>Cancel</button>
                                  </form>
                              </div>
                          </div>
                      </div>

                 </div>
          </div>
       )
   }
}

export default PostRecord;