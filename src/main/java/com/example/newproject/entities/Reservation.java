package com.example.newproject.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="start")
    private LocalDateTime start ;

    @Column(name="end")
    private LocalDateTime end ;

    @Column(name="title")
    private String title ;

    @Column(name="email")
    private String email ;

}
