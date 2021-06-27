package ex2;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

public class TesteNovaImplementacao {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeEach	
	public void setUpStreams() {
		
	 System.setOut(new PrintStream(outContent));
	 System.setErr(new PrintStream(errContent));
	 
	}
	@AfterEach
	public void cleanUpStreams() {
		
	 System.setOut(null);
	 System.setErr(null);
	 
	}
	
	//arquivo base: arquivoCSV
	//arquivoCSV:                    "Lucas",10693382
	 //                              "Emilly", 11808105

	@Test
	public void testaGetAll() { //testa impressão da lista de estudantes
		
		 //print all students
		 StudentDao studentDao = new NovaImplementacao();
	      for (Student student : studentDao.getAllStudents()) {
	         System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	      }
	      
	      assertEquals("Student: [RollNo : 10693382, Name : Lucas ]\n"
	      		+ "Student: [RollNo : 11808105, Name : Emilly ]\n",outContent.toString());
	 }
	     
	
	@Test
	public void testaDeleteStudent() { //testa a remoção do aluno Lucas
		
	      //remove student
		 StudentDao studentDao = new NovaImplementacao();
	      Student student =studentDao.getAllStudents().get(0); //estudante número 2 (Lucas)
	      studentDao.deleteStudent(student);
	      
	      for (Student aux : studentDao.getAllStudents()) {
		         System.out.println("Student: [RollNo : " + aux.getRollNo() + ", Name : " + aux.getName() + " ]");
		    }
	      
	      assertEquals("Student: Roll No 10693382, deleted from database\n" + "Student: [RollNo : 11808105, Name : Emilly ]\n",outContent.toString());
	}
	
	@Test
	public void testaUpdateStudent() { //testa a atualização do nome da estudante Emilly
		
		 //updated list
		StudentDao studentDao = new NovaImplementacao();
		
	      Student student =studentDao.getAllStudents().get(1); //estudante número 1 (Emilly)
	      student.setName("Emília");
	      studentDao.updateStudent(student);

	      
	      for (Student aux : studentDao.getAllStudents()) {
		         System.out.println("Student: [RollNo : " + aux.getRollNo() + ", Name : " + aux.getName() + " ]");
		    }
		
	      assertEquals("Student: Roll No 11808105, updated in the database\n"
	      		+ "Student: [RollNo : 10693382, Name : Lucas ]\n"
	      		+ "Student: [RollNo : 11808105, Name : Emília ]\n",outContent.toString());

	}
	
}
	
