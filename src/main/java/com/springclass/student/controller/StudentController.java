package com.springclass.student.controller;

import com.springclass.student.dao.AddressRespository;
import com.springclass.student.model.Student;
import com.springclass.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apis/v1/students")
public class StudentController {
    @Autowired
    private StudentService stdservice;



    // get requests
    @GetMapping()
    public List<Student> getallStudent(){
        return  stdservice.getAllStudentDetails();
    }

    @GetMapping("/{id}")
       public Optional<Student> getStudentID(@PathVariable(name="id") int stdid){

        Optional<Student> byID = stdservice.getAllStudentDetailsById(stdid);
        return byID;
    }

    @GetMapping("/filterbydept/{department}")
    public List<Student> getbyDepartment(@PathVariable(name="department") String dept){
        return stdservice.getByDepartment(dept);
    }

    @GetMapping("/filterbylevel/{level}")
    public List<Student> getbyLevel(@PathVariable(name="level") long lvl){
        return stdservice.getByLevel(lvl);
    }

    @GetMapping("/filterbygender/{gender}")
    public List<Student> getbyGender(@PathVariable(name="level") String gen){
        return stdservice.getByGender(gen);
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public Page<Student> studentPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return stdservice.getStudentPagination(pageNumber,pageSize);
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}/{sortedProperty}")
    public Page<Student> studentPageffj(@PathVariable Integer pageNumber,
                                        @PathVariable Integer pageSize,
                                        @PathVariable String sortedProperty){
        return stdservice.getStudentPagination(pageNumber, pageSize, sortedProperty);
    }




    //post requests
    @PostMapping()
    public Student saveStudent(@RequestBody  Student student){
        return  stdservice.saveStudent(student);
    }

    // delete requests
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name="id") int id){
        return  stdservice.deleteStudent(id);

    }

}
