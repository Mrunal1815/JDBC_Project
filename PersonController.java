package jdbc_person;

import java.util.Scanner;

public class PersonController {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		PersonCRUD crud=new PersonCRUD();
		
		System.out.println("Enter the choice \n1.Insert Data\n2.Read Data\n3.Update Data\n4.Delete Data");
		int choice=sc.nextInt();
		
		switch(choice) {
		//INSERT DATA
		case 1:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			
			System.out.println("Enter the name");
			String name=sc.next();
			
			System.out.println("Enter the age");
			int age=sc.nextInt();
			
			System.out.println("Enter the phno");
			long phno=sc.nextLong();
			
			System.out.println("Enter the address");
			String address=sc.next();
			
			crud.savePerson(id, name, age, phno, address);
		}
		break;
		//READ DATA
		case 2:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			crud.readPerson(id);
		}
		break;
		//Update the data
		case 3:{
			System.out.println("Enter the Id: ");
			int id=sc.nextInt();
			
			System.out.println("Enter the name to update");
			String name=sc.next();
			
			System.out.println("Enter the age to update");
			int age=sc.nextInt();
			
			System.out.println("Enter the phno to update");
			long phno=sc.nextLong();
			
			System.out.println("Enter the address to update");
			String address=sc.next();
			
			crud.updatePerson(id,name,age,phno,address);
		}
		break;
		
		//DELETE THE DATA
		case 4:{
			System.out.println("Enter the id to delete the data: ");
			int id=sc.nextInt();
			
			crud.deletePerson(id);
		}
		}
		
	}

}
