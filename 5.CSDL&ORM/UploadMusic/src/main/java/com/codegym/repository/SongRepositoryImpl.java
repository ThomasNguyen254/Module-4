package com.codegym.repository;

import com.codegym.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository{

    @Override
    public List<Song> showAll() {
        List<Song> songList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song",Song.class);
        songList = query.getResultList();
        session.close();
        return songList;
    }

    @Override
    public Song findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song where id=:id",Song.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Song findByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song where name=:name",Song.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }

    @Override
    public boolean save(Song song) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(song);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(id);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Song song) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(song);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
