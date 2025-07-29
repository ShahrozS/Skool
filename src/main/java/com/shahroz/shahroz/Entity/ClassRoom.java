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
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name such as 1D, 5A
    private String name;


    // many classes can just belong to one school
    @ManyToOne
    private School school;

    // one classroom can have several students
    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

}

