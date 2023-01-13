package com.springclass.student.service;

import com.springclass.student.dao.StudentRespository;
import com.springclass.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentService {

    @Autowired
    private StudentRespository stdrepo;

    public Student saveStudent(Student student){
        return stdrepo.save(student);
    }

    public List<Student> getAllStudentDetails(){
        return stdrepo.findAll();
    }

    public Optional<Student> getAllStudentDetailsById(int studentId){
        Optional<Student> byId = stdrepo.findById(studentId);
        return byId.isPresent() ? Optional.of(byId.get()) : null;
    }

    public String deleteStudent(int id){
        if(stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
            return "Student with id" + id + " deleted successfully";
        }
        return "There is no student with id "+id;
    }

    public String updateStudent(int id, Student studentId){
        if(stdrepo.existsById(id)){
            Student std =  stdrepo.findById(id).get();
            std.setFirstName(studentId.getFirstName());
            std.setLastName(studentId.getLastName());
            std.setDepartment(studentId.getDepartment());
            std.setGender(studentId.getGender());
            std.setLevel(studentId.getLevel());

            stdrepo.save(std);
            return "Record updated successfully";
        }
        return "No student with such an id";
    }


    public List<Student> getByDepartment(String dept) {
        return stdrepo.findByDepartment(dept);
    }


    public List<Student> getByGender(String gender){
        return stdrepo.findByGender(gender);
    }


    public List<Student> getByLevel(long level){
        return stdrepo.findByLevel(level);
    }

    public Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return stdrepo.findAll(pageable);
    }

    public Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize, String sortedProperty) {
        Pageable pageable = null;
        if(null != sortedProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortedProperty);
        }else{
            pageable =  PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"firstName");
        }

        return stdrepo.findAll(pageable);

    }
}
