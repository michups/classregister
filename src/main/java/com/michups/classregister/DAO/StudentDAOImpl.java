package com.michups.classregister.DAO;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(student);

    }

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("from Student order by lastName",
                Student.class);

        List<Student> student = query.getResultList();
        for (Student s : student) {
            Hibernate.initialize(s.gradeId);
        }

        return student;
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);

        Hibernate.initialize(student.gradeId);

        return student;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query theQuery = session.createQuery("delete from Student where id=:studentId");
        theQuery.setParameter("studentId", id);
        theQuery.executeUpdate();

    }
}
