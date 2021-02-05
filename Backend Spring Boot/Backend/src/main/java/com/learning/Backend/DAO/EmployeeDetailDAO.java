package com.learning.Backend.DAO;
import java.util.List;
import com.learning.Backend.Entitys.EmployeeDetail;

// EmployeeDetailDAO interface with the methods that implemented into EmployeeDetailDAOImp class
public interface EmployeeDetailDAO
{
	// Retrieve all data from database and return as a list
	public List<EmployeeDetail> findAll() ;
	
	// Store EmployeeDeail object in the database 
	public EmployeeDetail save(EmployeeDetail theEmployeeDetail);

	// Get single row of data as per search primary key(id)
	public EmployeeDetail getById(int id);

	// Delete single row of data as per entered primary key
	public void deleteById(int id);
	
	// Update object's more than one field
	public void updateId(int id, EmployeeDetail theEmployeeDetail);
}
