package com.springclass.student.controller;

import com.springclass.student.dao.StudentRespository;
import com.springclass.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apis/v1/students")
public class StudentController {
    @Autowired
    private StudentRespository stdrepo;

    // get requests
    @GetMapping()
    public List<Student> getallStudent(){
        return  stdrepo.findAll();
    }

    @GetMapping("/{id}")
       public Optional<Student> getStudentID(@PathVariable(name="id") int stdid){
        Optional<Student> byID = stdrepo.findById(stdid);
        return byID;
    }



    //post requests
    @PostMapping()
    public Student saveStudent(@RequestBody  Student student){
        return  stdrepo.save(student);
    }

    // delete requests
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name="id") int id){
        String status = "";
        if(stdrepo.existsById(id)){
            stdrepo.deleteById(id);
            status = "Successful";
        }
        else
            status = "unsuccesful";

        return  status;

    }

}
