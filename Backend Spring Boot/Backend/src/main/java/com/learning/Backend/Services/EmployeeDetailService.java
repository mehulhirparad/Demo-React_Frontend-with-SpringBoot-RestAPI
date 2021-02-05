package com.learning.Backend.Services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.learning.Backend.Entitys.EmployeeDetail;

// Service interface which is implemented in EmployeeDetailServicesImpl

public interface EmployeeDetailService {

	// Pass call to EmployeeDetailDAOImpl call and return with list of data
	public List<EmployeeDetail> findAll();
	
	// Call method for EmployeeDetailDAOImpl so save data
	public EmployeeDetail save(EmployeeDetail theEmployee);

	// Collect the id and pass the DAO layer, search single row data and return the data 
	public EmployeeDetail getById(int id);

	// Collect the id and pass the DAO layer foe delete data
	public void deleteById(int id);
	
	// Update EmployeeDetail object so pass id as well as object in method
	public void updateId(int id, EmployeeDetail theEmployee);
}
