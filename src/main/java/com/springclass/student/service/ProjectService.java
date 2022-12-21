package com.springclass.student.service;

import com.springclass.student.dao.ProjectRespository;
import com.springclass.student.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class ProjectService {
    @Autowired
    private ProjectRespository projectRepo;

  public List<Project> getAllProject(){
      return  projectRepo.findAll();
  }



}
