package com.example.homework10.repository;


import com.example.homework10.entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public BookEntity addBook(BookEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public List<BookEntity> getBookAllList() {
        Session session = sessionFactory.openSession();
        Query<BookEntity> query = session.createNativeQuery(" select * from book ", BookEntity.class);
        List<BookEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public void updateBook(Integer id,BookEntity book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "update BookEntity set title=:title , author=:author," +
                "publishYear=:publishYear where id =:id";
        Query query = session.createQuery(sql);
        query.setParameter("title", book.getTitle());
        query.setParameter("author",book.getAuthor());
        query.setParameter("publishYear",book.getPublishYear());
        query.setParameter("id", id);
        int i = query.executeUpdate();
        System.out.println("update -> " + i);
        transaction.commit();
        session.close();

    }

    public int deleteBook(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "delete from BookEntity  where id =:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        int i = query.executeUpdate();
        System.out.println("update -> " + i);
        transaction.commit();
        session.close();
        return 0;
    }

    public List<BookEntity> getBookById(Integer id) {
        Session session = sessionFactory.openSession();
        Query<BookEntity> query = session.createNativeQuery(" select * from book where id =:id", BookEntity.class);
        query.setParameter("id", id);
        List<BookEntity> list = query.getResultList();
        session.close();
        return list;
    }
}
