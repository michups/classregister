package com.michups.classregister.DAO;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import com.michups.classregister.entity.Teacher;
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
public class TeacherDAOImpl implements TeacherDAO {

    @Autowired
    private SessionFactory myTransactionManager;

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = myTransactionManager.getCurrentSession();

        session.saveOrUpdate(teacher);

    }

    @Override
    public List<Teacher> getTeachers() {
        Session session = myTransactionManager.getCurrentSession();
        Query<Teacher> query = session.createQuery("from Teacher order by lastName",
                Teacher.class);

        List<Teacher> teacher = query.getResultList();

        for (Teacher t : teacher) {
            Hibernate.initialize(t.grades);
            Hibernate.initialize(t.mainClass);
        }

        return teacher;
    }

    @Override
    public Teacher getTeacher(int id) {
        Session session = myTransactionManager.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);
        Hibernate.initialize(teacher.grades);
        Hibernate.initialize(teacher.mainClass);
        return teacher;
    }

    @Override
    public void delete(int id) {
        Session session = myTransactionManager.getCurrentSession();

        Query theQuery = session.createQuery("delete from Teacher where id=:teacherId");
        theQuery.setParameter("teacherId", id);
        theQuery.executeUpdate();

    }
}
