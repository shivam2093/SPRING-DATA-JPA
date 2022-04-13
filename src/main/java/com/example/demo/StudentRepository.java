package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

 //custom queries
    //from this line spring JPA execute the query
    //and as we know the Email in our database as unique
    //so we take Optional<> instead List<>
// Optional<Student> findStudentsByEmail(String email);
 //inside query we written JPQL which is not specific for the database
 @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age = ?2" )
List<Student> findStudentsByFirstNameEqualsAndAgeEqualsJPQL(String firstName,Integer age);

 //this is native query but in Practice better use JPQL
 //because if we change the database in future then it may not work with
 //other database whee JPQL works only since it is not specific for the
 //database
 @Query(value= "SELECT * FROM student  WHERE firstName = ?1 AND age = ?2",
 nativeQuery = true)
 List<Student> findStudentsByFirstNameEqualsAndAgeEqualsNative(String firstName,Integer age);

 //Named Parameters
 @Query(value= "SELECT * FROM student  WHERE firstName = :firstName AND age = :age",
         nativeQuery = true)
 List<Student> findStudentsByFirstNameEqualsAndAgeEqualsNativeParam(
         @Param("firstName") String firstName, @Param("age") Integer age);

@Transactional
 @Modifying
 @Query("DELETE FROM Student u WHERE u.id = ?1")
 int deleteStudentById(Long id);


}
