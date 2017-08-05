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
public class GradeDAOImpl implements GradeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveGrade(Grade grade) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(grade);

    }

    @Override
    public List<Grade> getGrades() {
        Session session = sessionFactory.getCurrentSession();
        Query<Grade> query = session.createQuery("from Grade ",
                                                    Grade.class);

        List<Grade> grade = query.getResultList();
        for (Grade g : grade){
            Hibernate.initialize(g.teachers);
        }

        return grade;
    }

    @Override
    public Grade getGrade(int id) {
        Session session = sessionFactory.getCurrentSession();
        Grade grade = session.get(Grade.class, id);
            Hibernate.initialize(grade.teachers);
        return grade;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query theQuery = session.createQuery("delete from Grade where id=:gradeId");
        theQuery.setParameter("gradeId", id);
        theQuery.executeUpdate();

    }
}
