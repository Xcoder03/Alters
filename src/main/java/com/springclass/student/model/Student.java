package com.springclass.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Transactional
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
     private  int id;
    @Column
    @NotNull
    private String firstName;
    @Column
    @NotNull
    private String lastName;
    @Column
    @NotNull
    private String gender;
    @Column
    @NotNull
    private String department;
    @Column
    @NotNull
    private long level;
    @Column
    @JsonIgnore

    private LocalDate registeredDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_student_id",referencedColumnName = "student_id")
    private List<Address>  address;


    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
            name = "assigned_project",
            joinColumns =  @JoinColumn(name = "student_id") ,
            inverseJoinColumns =  @JoinColumn(name = "project_id")
    )
    private Set<Project> project = new HashSet<>();
}
