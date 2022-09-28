package com.peaksoft;

import com.peaksoft.entity.Student;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
//        create(new Student("Elaman", "Rakhmanov", 22));
//        create(new Student("Aza", "Rustamov", 17));
//        create(new Student("Aza", "Aibekov", 23));
//        create(new Student("Aza", "Akhmatov", 20));
//        create(new Student("Bekzhan", "Begaliev", 25));

//        update(2, "Aza", "Rustamov", 18);
//        update(3,"Aza", "Aibekov", 18);
//        update(4, "Aza", "Akhmatov", 18);

        delete("Aza");
    }
    public static Student create(Student studentter){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(studentter);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created!");
        return studentter;
    }

    public Student getById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public List<Student> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student> studentList = session.createQuery("from Student where name like 'Aza' and age >= 20").getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public static Student update(int id, String name, String last_name, int age){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setName(name);
        student.setLast_name(last_name);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");
        return student;
    }
    public static void delete(String name) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from Student where name =: Aza").setParameter("Aza", name);
        session.getTransaction().commit();
        session.close();
        System.out.println("The student with name of Aza has been deleted!");
    }
}
