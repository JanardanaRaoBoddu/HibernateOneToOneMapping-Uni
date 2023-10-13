package com.jana.HibernateOneToOneMapping.dao;

import com.jana.HibernateOneToOneMapping.entity.Instructor;
import com.jana.HibernateOneToOneMapping.entity.InstructorDetail;

public interface AppDAO {
   void save(Instructor theInstructor);

   Instructor findInstructorId(int id);

    void deleteById(int id);

}
