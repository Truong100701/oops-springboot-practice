package com.example.demo.common;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CommonOfficeDTO {
    //private int id;

    private String name;

    private int age;

    private boolean gender;

    private String address;
}
