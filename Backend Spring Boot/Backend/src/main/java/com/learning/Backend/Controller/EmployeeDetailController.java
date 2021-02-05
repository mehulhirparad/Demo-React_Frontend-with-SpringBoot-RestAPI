package com.learning.Backend.Controller;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Backend.Entitys.EmployeeDetail;
import com.learning.Backend.Services.EmployeeDetailService;

@CrossOrigin(origins="http://localhost:3000") 
@RestController
@RequestMapping("/api")
@ComponentScan("com.learning.Backend")
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class EmployeeDetailController 
{	
	// Create filed of EmployeeDetailService class object 
	private EmployeeDetailService theEmployeeDetailService;		
	
	// User class constructor method of implementing dependency injection
	@Autowired
	public EmployeeDetailController(EmployeeDetailService theEmployeeDetailService)
	{
		this.theEmployeeDetailService = theEmployeeDetailService	;	
	}	
	
	// Request for all data from the database and return as a ResponseEntity with List
	@RequestMapping(value = "/employeedetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<List<EmployeeDetail>> findAll()
	{		
		List<EmployeeDetail> list = theEmployeeDetailService.findAll();				 
		return new ResponseEntity<List<EmployeeDetail>>(list,HttpStatus.OK);
	}		
	
	// Request single row from database base on id and return with ResponseEntity 
	@RequestMapping(value = "/employeedetail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<EmployeeDetail> getById(@PathVariable int id)
	{			
		return new ResponseEntity<EmployeeDetail>(theEmployeeDetailService.getById(id),HttpStatus.OK);		
	}
	
	
	// Post data in service layer for storing in database
	@RequestMapping(value = "/employeedetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)	
	@ResponseBody
	public ResponseEntity<EmployeeDetail> save(@RequestBody EmployeeDetail theEmployee)
		{				
			return new ResponseEntity<EmployeeDetail>(theEmployeeDetailService.save(theEmployee),HttpStatus.OK);
		}	
	
		
	// Delete the employeedetail form the database
	@RequestMapping(value = "/employeedetail/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)	
	@ResponseBody
	public void deleteById(@PathVariable int id)
	{
		theEmployeeDetailService.deleteById(id);
	}
	
	// Update the EmployeeDetail so collect the data as per id and than set new data in the filed
	@RequestMapping(value = "/employeedetail/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
	public EmployeeDetail updateId(@PathVariable int id,@RequestBody EmployeeDetail theEmployeeDetail)
	{
		EmployeeDetail theEmployee = theEmployeeDetailService.getById(id);
		theEmployee.setFirst_name(theEmployeeDetail.getFirst_name());
		theEmployee.setLast_name(theEmployeeDetail.getLast_name());
		theEmployee.setEmail(theEmployeeDetail.getEmail());
		theEmployeeDetailService.updateId(id, theEmployeeDetail);				
		return theEmployee;
	}	
}
