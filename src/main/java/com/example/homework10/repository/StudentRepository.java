package com.example.homework10.repository;

import com.example.homework10.entity.BookEntity;
import com.example.homework10.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentEntity saveStudent(StudentEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public List<StudentEntity> getStudentList() {
        Session session = sessionFactory.openSession();
        Query<StudentEntity> query = session.createNativeQuery(" select * from student ", StudentEntity.class);
        List<StudentEntity> list = query.getResultList();
        session.close();
        return list;

    }

    public List<StudentEntity> getId(Integer id) {
        Session session = sessionFactory.openSession();
        Query<StudentEntity> query = session.createNativeQuery(" select * from student where id =:id", StudentEntity.class);
        query.setParameter("id", id);
        List<StudentEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public void updateStudent(Integer id, StudentEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update StudentEntity set name=:name,surname=:surname,phone=:phone," +
                "createdDate=:createdDate,role=:role,visible=:visible where id =:id");
        query.setParameter("name", entity.getName());
        query.setParameter("surname", entity.getSurname());
        query.setParameter("phone", entity.getPhone());
        query.setParameter("createdDate", entity.getCreatedDate());
        query.setParameter("role", entity.getRole());
        query.setParameter("visible", entity.isVisible());
        query.setParameter("id", id);
        int i = query.executeUpdate();
        System.out.println(i);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from StudentEntity where id=:id");
        query.setParameter("id",id);
        int i = query.executeUpdate();
        System.out.println(i);
        transaction.commit();
        session.close();
    }
}
