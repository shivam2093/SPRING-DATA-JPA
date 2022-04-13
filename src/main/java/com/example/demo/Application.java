package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
    @Bean
    CommandLineRunner cmd(StudentRepository stR){
        return args -> {
//            Student shivam = new Student(
//                 "shi","patel",
//                 "shiv1.patel2093@gmail.com",
//                 21
//            );
//            Student maria = new Student(
//                    "maria","patel",
//                    "maria.patel2093@gmail.com",
//                    20
//            );
//this is called abstractioon that we are not creating queries
         //but spring data JPA create for us
             // stR.saveAll(List.of(shivam,maria));
//       int m = (int)stR.count();
//       System.out.print("Line 34"+m);
//
//       System.out.print("Searching id 2L");
//       stR.findById(2L).ifPresentOrElse(st ->{
//           System.out.print(st);
//       },() -> {
//           System.out.print("Not found");
//       });
//System.out.print("Select all");
//      List<Student> l =  stR.findAll();
//      l.forEach(System.out::println);
//            System.out.print("Deleting id 1L");
//            stR.deleteById(1L);
//            System.out.print("Line 44"+m);

            //Custom Queries
//            stR.findStudentsByEmail("mria.patel2093@gmail.com")
//                    .ifPresentOrElse(System.out::println,() -> {
//                        System.out.print("Not found");
//                    });

//            stR.findStudentsByFirstNameEqualsAndAgeEqualsJPQL(
//                    "maria",
//                    20).forEach(System.out::println);
//            stR.findStudentsByFirstNameEqualsAndAgeEqualsNative(
//                    "maria",
//                    20).forEach(System.out::println);
          //  System.out.println(stR.deleteStudentById(1L));

//          ------ Using JAVA FAKER ------  TO CREATE RANDOM DATABASE
    Faker faker = new Faker();

    for(int i = 0; i <= 10; i++){
        String firstName = faker.name().firstName();
       String lastName = faker.name().lastName();
       String email = String.format("%s.%s@shivcode.edu",firstName,lastName);

        Student st = new Student(
                firstName,lastName,email,
                faker.number().numberBetween(10,80)
                );
        stR.save(st);
    }

        };


    }

}
