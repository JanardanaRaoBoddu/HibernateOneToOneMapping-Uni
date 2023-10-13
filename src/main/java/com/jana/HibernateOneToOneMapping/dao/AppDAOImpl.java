package com.jana.HibernateOneToOneMapping.dao;

import com.jana.HibernateOneToOneMapping.entity.Instructor;
import com.jana.HibernateOneToOneMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorId(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public  void deleteById(int id) {
       Instructor tempInstructor=entityManager.find(Instructor.class,id);
       entityManager.remove(tempInstructor);
    }


}
