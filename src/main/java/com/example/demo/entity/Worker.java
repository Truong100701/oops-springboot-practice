package com.example.demo.entity;

import com.example.demo.common.CommonOffice;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "Worker")
public class Worker extends CommonOffice {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;

    private String level;
}
