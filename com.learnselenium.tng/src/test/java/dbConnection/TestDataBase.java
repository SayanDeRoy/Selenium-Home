package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class TestDataBase {
	
	@Test
	public void dataBase() throws Exception{
            				// This will load the driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded");

// This will connect with Database , getConnection taking three argument
//  first argument Test_Oracle is the dsn which you can change as per your system,
// second argument is username and third argument is password

			Connection con=DriverManager.getConnection("jdbc:odbc:OracleDB","SYSTEM","Infosys21$");
			System.out.println("Connection created");

// This will create statement  
			Statement smt=con.createStatement();
			System.out.println("Statement created");

// Now execute the query, here emp is the table which I have created in DB 

			ResultSet rs=  smt.executeQuery("select empno,ename,job from emp where job = 'PRESIDENT'");
			System.out.println("Query Executed");

// Iterate the resultset now

			while(rs.next()){

				String empNo = rs.getString("EMPNO");
				String empName = rs.getString("ENAME");
				String job = rs.getString("JOB");

				System.out.println("Employe Number is: "+empNo+" Employe Name is: "
						+empName+" Job is: "+job);
			}
	}
}
