package com.learning.Backend.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.learning.Backend.Entitys.EmployeeDetail;

// Implement the EmployeeDetailDAO interface
@Repository
public class EmployeeDetailDAOImpl implements EmployeeDetailDAO
{
	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDetailDAOImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
		
	// Retrieve method
	@Transactional
	public List<EmployeeDetail> findAll() {
		
		  Session session= entityManager.unwrap(Session.class);
		  
		  Query<EmployeeDetail> theQuery=
				  session.createQuery("from EmployeeDetail", EmployeeDetail.class);
		  
		 List<EmployeeDetail> employees = theQuery.getResultList();
		 System.out.println("3");
		return employees;
	}
	
	// Data save method
	@Transactional
	public EmployeeDetail save(EmployeeDetail theEmployee) {
		
		Session session= entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theEmployee);
				
		return theEmployee;			
	}

	// Search element by id method
	public EmployeeDetail getById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		EmployeeDetail employee = session.get(EmployeeDetail.class, id);
		
		return employee;
	}
	
	// Delete element by id method
	@Transactional
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery("delete from EmployeeDetail where id=:id");
		
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}
	
	// Update object method
	@Transactional
	public void updateId(int id, EmployeeDetail theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		
		EmployeeDetail employee = session.get(EmployeeDetail.class, id);
			
		session.update(employee);
				
	}
}

