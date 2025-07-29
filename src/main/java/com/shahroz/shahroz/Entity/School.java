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
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String area;

    // one school will have several classrooms
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<ClassRoom> classes = new ArrayList<>();

    // one school will have several teachers
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();
}


