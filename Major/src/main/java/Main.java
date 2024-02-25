import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.highradius.pojo.Customers;
import com.highradius.pojo.Employees;
import com.highradius.pojo.Orders;
import com.highradius.pojo.Shippers;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration= new Configuration ();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=null;
		Session session=null;
		factory= configuration.buildSessionFactory();
		session=factory.openSession();
		Transaction transaction =session.beginTransaction();
		
		
		Employees emp = new Employees();
		emp.setBirthDate("15-10-2002");
		emp.setFirstName("Ashutosh");
		emp.setLastName("Singh");
		emp.setNotes("Hi chutiye");
		emp.setIsDelete(0);
		session.save(emp);
		
		
		Customers cust=new Customers();
		cust.setCustomerName("Himnashu");
		cust.setContactName("kumar");
		cust.setAddress("khbfahb");
		cust.setCity("bokaro");
		cust.setCountry("india");
		cust.setIsdelete(0);
		cust.setPostalCode(3462);
		session.save(cust);
		
		Shippers ship=new Shippers();
		ship.setPhone(83419);
		ship.setShipper_id(2);
		ship.setShipper_name("ashu_ship");
		session.save(ship);
		
		Orders order=new Orders();
		order.setCustomer(cust);
		order.setEmployee(emp);
		order.setShipper(ship);
		session.save(order);
		
		transaction.commit();
		
//		Configuration configuration= new Configuration ();
//		configuration.configure("hibernate.cfg.xml");
//		SessionFactory factory=null;                         //various dialect like username password are present 
//		Session session=null;                                //connect to database with no other connection to database until and unless it is released
//		
//		factory= configuration.buildSessionFactory();
//		session=factory.openSession();
//		Transaction transaction=session.beginTransaction();               //at one hit all rules must be performed if not then rollback all
//		session.save(emp);
//		
//		transaction.commit();
//		session.close();
//		factory.close();
	}

}
