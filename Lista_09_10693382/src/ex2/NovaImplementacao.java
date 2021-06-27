package ex2;

//Programa construído por:

//Lucas Carvalho Ramos (10693382)
//Emilly da Silva Arcanjo (11808105)

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class NovaImplementacao implements StudentDao {
	
   //list is working as a database
   static List<Student> students;
   private static String arquivoCSV = "arquivo.csv";
   
   public NovaImplementacao(){
	   
	   BufferedReader br = null;
	   
		try {
			
			PrintWriter writer = new PrintWriter(arquivoCSV , "UTF-8");
			writer.println("Lucas,10693382");
			writer.println("Emilly,11808105");
			writer.close();
			
			//a leitura é realizada a partir de um arquivo csv exemplo 
			br = new BufferedReader(new FileReader("exemplo"+arquivoCSV));
			
			String line = null;
			
			students = new ArrayList<Student>();
			
			do {
				
				line = br.readLine();
				
				if(line != null) {
				
					int tamanho = line.length(); //pega tamanho da linha
					
					int auxiliar = line.indexOf(','); //pega a posição da virgula
					
					String nome = line.substring(0, auxiliar); //pega nome do aluno
							
					String numero = line.substring(auxiliar+1,tamanho); //pega numero do aluno
										
					Student student1 = new Student(nome,Integer.parseInt(numero));
					
					students.add(student1);
			     
				}
			     
			} while(line != null);
		}
		
		catch (FileNotFoundException | UnsupportedEncodingException e) {
			
	        e.printStackTrace();
	        
		}
	        
	    catch (IOException e) {
	    	
			e.printStackTrace();
			
		}
		
		finally {
			
	        if (br != null) {
	        	
	            try {
	            	
	                br.close();
	                
	            } catch (IOException e) {
	            	
	                e.printStackTrace();
	            }
	        }
	        
		}	
   }
   

   @Override
   public void deleteStudent(Student student) {
	   int position = getPosition(student);
	   
	   if(position > -1) {
		   students.remove(position);
	   		System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
	   		
	   		try {
				PrintWriter writer = new PrintWriter(arquivoCSV, "UTF-8");
				for (Student u: students) {
					writer.println(u.getName() + "," + u.getRollNo());
				}
				writer.close();
				
			}
			catch(FileNotFoundException | UnsupportedEncodingException e) {
				System.out.println(e);
			}
	   
	   }
	   else 
		   System.out.println("This student is not in the database");
		   
   }

   //retrive list of students from the database
   @Override
   public List<Student> getAllStudents() {
      return students;
   }

   @Override
   public Student getStudent(int rollNo) {
      return students.get(rollNo);
   }

   @Override
   public void updateStudent(Student student) {
	  int position = getPosition(student);
	  
	  if(position > -1) {
		  students.get(position).setName(student.getName());
		  System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
		  
		  try {
				PrintWriter writer = new PrintWriter(arquivoCSV, "UTF-8");
				for (Student u: students) {
					writer.println(u.getName() + "," + u.getRollNo());
				}
				writer.close();
				
			}
			catch(FileNotFoundException | UnsupportedEncodingException e) {
				System.out.println(e);
			}
	  
	  }
	  else 
		  System.out.println("This student is not in the database");
		   
   }

   public int getPosition(Student student) {
	   
	   int count = 0;
	   
	   for (Student u: students) {
		   
		   if (u.getRollNo() == student.getRollNo()) {
			   
			   return count;
		   }
		   
		   count ++;
	   }
	   
	   return -1; //indica que o elemento não está na lista
	
   }
   
}
