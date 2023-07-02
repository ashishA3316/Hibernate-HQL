package demo;

import domain.account;
import domain.employee;
import domain.professional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DisplayEmpbyDesg {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(employee.class);
        cfg=cfg.addAnnotatedClass(account.class);
        cfg=cfg.addAnnotatedClass(professional.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Designation");
        String desg = sc.next();

        Query q = ses.createQuery("select e.id, e.name, e.email, p.desg, p.exp, a.accNo, a.salary from employee e inner join professional p on e.professional=p.id inner join account a on e.account=a.id where p.desg='"+desg+"' ");
        List data = q.list();
        Iterator itr = data.iterator();
        while (itr.hasNext())
        {
            Object [] arr = (Object[]) itr.next();
            System.out.println("================================================");
            System.out.println("ID :-"+arr[0]+"\n"+"NAME :-"+arr[1]+"\n"+"EMAIL :-"+arr[2]+"\n"+"DESIGNATION :-"+arr[3]+"\n"+"EXPERIENCE :-"+arr[4]+"\n"+"ACC NO :-"+arr[5]+"\n"+"SALARY :-"+arr[6]);
            System.out.println("================================================");
        }
    }
}
