package com.springclass.student.dao;

import com.springclass.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT o FROM Student o WHERE o.department =:dept ")
    List<Student> findByDepartment(@Param("dept") String dept);

    @Query(value = "SELECT o FROM Student o WHERE o.level =:lvl ")
    List<Student> findByLevel(@Param("lvl") long lvl);

    @Query(value = "SELECT o FROM Student o WHERE o.gender =:gen ")
    List<Student> findByGender(@Param("gen") String gen);

}
