package com.example.newproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime start;

    @Column(name = "end")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime end;

    @Column(name = "title")
    private String title;

    @Column(name = "email")
    private String email;

    @Column(name = "note")
    private String note;

}
