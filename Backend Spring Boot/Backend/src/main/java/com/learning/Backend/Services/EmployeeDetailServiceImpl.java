package com.learning.Backend.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.Backend.DAO.EmployeeDetailDAO;
import com.learning.Backend.Entitys.EmployeeDetail;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService
{
	// create the EmployeeDetailDAI interface field 
	private EmployeeDetailDAO theEmployeeDetailDAO;
	
	// Use class constructor method for dependency injection
	@Autowired
	public EmployeeDetailServiceImpl(EmployeeDetailDAO theEmployeeDetailDAO)
	{
		this.theEmployeeDetailDAO = theEmployeeDetailDAO;
	}
	
	// call DAO method from service layer for data retrieve
	@Override
	public List<EmployeeDetail> findAll() {		
		return theEmployeeDetailDAO.findAll();
	}
	
	// Call DAO layer with the object data for store in database
	@Override
	public EmployeeDetail save(EmployeeDetail theEmployee) {
		
		return theEmployeeDetailDAO.save(theEmployee);
		
	}
	
	// Call DAO layer for getting single row of data
	@Override
	public EmployeeDetail getById(int id) {
		
		return theEmployeeDetailDAO.getById(id);
	}
	
	// Pass the id number for DAO layer for deletion 
	@Override
	public void deleteById(int id) {
		theEmployeeDetailDAO.deleteById(id);
	}
	
	// Pass the id with object to DAO layer for update the data in the database	
	@Override
	public void updateId(int id, EmployeeDetail theEmployee)
	{
		theEmployeeDetailDAO.updateId(id, theEmployee);		
	}

}