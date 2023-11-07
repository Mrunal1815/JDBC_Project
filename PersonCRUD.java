package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCRUD {
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb?user=root&password=root");
		return connection;
	}
	public void savePerson(int id, String name,int age, long phno, String address) throws Exception {
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,age);
		ps.setLong(4,phno);
		ps.setString(5,address);
		
		int result=ps.executeUpdate();
		if(result!=0) {
			System.out.println("Data Inserted");
		}
		else {
			System.out.println("Data is not inserted");
		}
		connection.close();
	}
	
	public void readPerson(int id) throws Exception {
		Connection connection= getConnection();
		PreparedStatement ps= connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Id: "+rs.getInt("id"));
			System.out.println("Name: "+rs.getString("name"));
			System.out.println("Age: "+rs.getInt("age"));
			System.out.println("Phone Number: "+rs.getLong("phno"));
			System.out.println("Address: "+rs.getString("address"));
		}
	}
	
	public void updatePerson(int id,String name,int age,long phno,String address) throws Exception {
		Connection cn= getConnection();
		PreparedStatement ps = cn.prepareStatement("UPDATE PERSON SET NAME=?, AGE=?, PHNO=?, ADDRESS=? WHERE ID=?");
		ps.setString(1,name);
		ps.setInt(2,age);
		ps.setLong(3,phno);
		ps.setString(4,address);
		ps.setInt(5, id);
		
		int ct=ps.executeUpdate();
		if(ct!=0) {
			System.out.println("Data updated successfully");
		}
		else {
			System.out.println("Data is not updated");
		}
	}
	
	public void deletePerson(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		ps.setInt(1, id);
		
		int count=ps.executeUpdate();
		if(count>0) {
			System.out.println("Data is Deleted successfully");
		}
		else {
			System.out.println("Data is not deleted please try again!\nThank You");
		}
	}
}
