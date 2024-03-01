package com.example.demo.entity;


import com.example.demo.common.CommonOffice;
import jakarta.persistence.*;

@Entity
@Table(name = "Engineer")
public class Engineer extends CommonOffice {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;

    @Column(name = "training_industry")
    private String trainingIndustry;
}
