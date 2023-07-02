package demo;

import domain.account;
import domain.employee;
import domain.professional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class addEmployee {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(employee.class);
        cfg=cfg.addAnnotatedClass(account.class);
        cfg=cfg.addAnnotatedClass(professional.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);

        employee emp = new employee();
        System.out.println("Enter Employee Name");
        String name = sc.next();
        System.out.println("Enter Employee Email");
        String email = sc.next();
        emp.setName(name);
        emp.setEmail(email);

        professional p = new professional();
        System.out.println("Enter Employee Designation");
        String desg = sc.next();
        System.out.println("Enter Employee Experience");
        double exp = sc.nextDouble();
        p.setDesg(desg);
        p.setExp(exp);

        account a = new account();
        System.out.println("Enter Employee Account Number");
        int acc = sc.nextInt();
        System.out.println("Enter Employee Salary");
        double salary = sc.nextDouble();
        a.setAccNo(acc);
        a.setSalary(salary);

        emp.setAccount(a);
        emp.setProfessional(p);
        tx= ses.beginTransaction();
        ses.save(emp);
        tx.commit();
        System.out.println("Employee Inserted Successfully");
    }
}
