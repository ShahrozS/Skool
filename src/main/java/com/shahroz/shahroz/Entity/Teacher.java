package com.shahroz.shahroz.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    // many teachers belongs to one student
    // one teacher can not belong to many schools at the same time
    @ManyToOne
    private School school;


    // one teacher can have several subject assignemtns
    // note that TeacheingAssignment is a join table
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TeachingAssignment> teachingAssignments = new ArrayList<>();


}
