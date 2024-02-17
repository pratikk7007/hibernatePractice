package com.pratik;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.pratik.entities.Student;

public class DESerialCsv {

	public static void main(String[] args)throws Exception {
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			 fis=new FileInputStream("Resources/Student.ser");
			 ois=new ObjectInputStream(fis);
			
			
			while(true) {
				
				Student s = (Student)ois.readObject();
	
				System.out.print(" rno: "+s.getRno());
				System.out.print(" name: "+s.getName());
				System.out.print(" per: "+s.getPer());
				System.out.println();
			}
		}
			
		
		catch(EOFException e) {
			//e.printStackTrace();
			System.out.println("Saved");
		}
		catch(Exception e) {
			System.out.println("Some error occur!!!");
		}
		
		finally {
			ois.close();
			fis.close();
			
		}

}}
