package com.example.newproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime start;

    @Column(name = "end")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime end;



}
