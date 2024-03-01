package com.example.demo.entity;

import com.example.demo.common.CommonOffice;
import jakarta.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff extends CommonOffice {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;

    @Column(name = "work")
    private String work;
}
