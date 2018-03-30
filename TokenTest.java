// Lab 01
// CSCI-C490 (Java Patterns)
// Ash Scarbrough

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.text.DecimalFormat;

public class TokenTest {

	public static void main(String[] args) {

	BufferedReader br = null;

	try {

		String line;

		br = new BufferedReader(new FileReader("c:/Users/Ash Scarbrough/eclipse-workspace/Lab1/src/student.txt")); // you need to change this path
		
		double avgGPA = 0.00;
		int numberOfStudents = 0;
		
		while ((line = br.readLine()) != null) //we have data to read
		{
		   StringTokenizer stringTokenizer = new StringTokenizer(line, "|");

		   while (stringTokenizer.hasMoreElements()) {

		    Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
		    Double gpa = Double.parseDouble(stringTokenizer.nextElement().toString());
		    String firstname = stringTokenizer.nextElement().toString();
		    String lastname = stringTokenizer.nextElement().toString();

			StringBuilder sb = new StringBuilder();
			sb.append("\nId: " + id);
			sb.append("\nstudent name: " + firstname + " " + lastname);
			sb.append("\nGpa: " + gpa);
			sb.append("\n*******************\n");

			System.out.println(sb.toString());
			
			
			avgGPA = avgGPA + gpa;
			numberOfStudents++;
		   }
		   
		   DecimalFormat f = new DecimalFormat("#.00");
		   System.out.println ("Average Class GPA: " + f.format(avgGPA/numberOfStudents));
		}

		System.out.println("Done");

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	}
}
