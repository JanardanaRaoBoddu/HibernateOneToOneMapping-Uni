package com.jana.HibernateOneToOneMapping;

import com.jana.HibernateOneToOneMapping.dao.AppDAO;
import com.jana.HibernateOneToOneMapping.entity.Instructor;
import com.jana.HibernateOneToOneMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateOneToOneMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);

		};
	}



	private void deleteInstructor(AppDAO appDAO) {
		int id=2;
		System.out.println("Deleting instructor id: "+id);
		appDAO.deleteById(id);
		System.out.println("Done!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id=3;
		System.out.println("Finding instructor id:"+ id);

		Instructor tempInstructor=appDAO.findInstructorId(id);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*//create instructor
		Instructor tempInstructor=new Instructor("Jana","Boddu","janardanaraoboddu@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","coding!!!");

		//associate the objects*/
		//create instructor
		Instructor tempInstructor=new Instructor("shiva","pathi","sivakumaripathi@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","dancing!!!");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		//Note: this will also save details object
		//
		//
		System.out.println("Saving instructor: " +tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done!");


	}


}
