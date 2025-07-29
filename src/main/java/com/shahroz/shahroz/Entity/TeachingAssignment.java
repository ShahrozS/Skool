package com.shahroz.shahroz.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TeachingAssignment {

    // a table to hold the record of which teacher is teaching what subject in which class
    // didnt add time because he can have several slots which is uncertain


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private ClassRoom classRoom;
}

