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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // one subject can have several enorllments
    // note that enrollment is a join table which enrolls a student to a subject
    @OneToMany(mappedBy = "subject")
    private List<Enrollment> enrollments = new ArrayList<>();

}
