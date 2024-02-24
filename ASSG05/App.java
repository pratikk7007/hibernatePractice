package com.pratik;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratik.entities.Student;

public class App {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();

		configuration.configure(); // load & prepare

		SessionFactory sessionfactory = configuration.buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction txn = session.beginTransaction();

		System.out.println("Enter how many Entries: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			
			Student sob = new Student();
			System.out.println("Enter roll no: ");
			int rno = Integer.parseInt(br.readLine());
			sob.setRno(rno);
			
			System.out.println("Enter name : ");
			String name = br.readLine();
			sob.setName(name);
			
			System.out.println("Enter per: ");
			double per = Double.parseDouble(br.readLine());
			sob.setPer(per);
			
			session.save(sob);
			
		}
		txn.commit();

		session.close();
		sessionfactory.close();

		System.out.println("Records are saved !!!");
	}
}
