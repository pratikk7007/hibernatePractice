package com.pratik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.pratik.entities.Student;

public class StudDisp {

	public static void main(String[] args) throws Exception {
		Connection con = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://localhost/hibernet", "root", "root@123");

			ps = con.prepareStatement("select * from Student");
			rs = ps.executeQuery();

			System.out.println("RNO\tNAME\tPER");
			List<Student> pass = new ArrayList<>();
			List<Student> fail = new ArrayList<>();

			while (rs.next()) {
				int rno = rs.getInt("rno");
				String nm = rs.getString("name");
				double per = rs.getFloat("per");

				Student ob = new Student(rno, nm, per);

				if (per >=35) {
					pass.add(ob);
				} else {
					fail.add(ob);
				}
			}

			System.out.println("pass Stude:");

			for (Student s : pass) {

				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer());
			}

			System.out.println("Failed Stude:");

			for (Student s : fail) {

				System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			rs.close();
			ps.close();
		}
	}

}
