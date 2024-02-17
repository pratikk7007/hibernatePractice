package com.pratik;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.pratik.entities.Student;

public class SerialCsv {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("Resources/Student.txt");
		BufferedReader br = new BufferedReader(fr);
		
		FileOutputStream fos=new FileOutputStream("Resources/Student.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		try {
			int rno;
			String name;
			double per;

			while (true) {
				
				String s = br.readLine();
				if(s==null) {
					break;
				}

				String arr[] = s.split(",");
				 rno=Integer.parseInt(arr[0]);
				 name=arr[1];
				 per=Double.parseDouble(arr[2]);
				 
				 Student ob = new Student();
				 ob.setRno(rno);
				 ob.setName(name);
				 ob.setPer(per);
				 
				 oos.writeObject(ob);
				 System.out.println("Serialize!!!");
				 

			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			fr.close();
			fos.close();
			oos.close();
		}

	}

	}
