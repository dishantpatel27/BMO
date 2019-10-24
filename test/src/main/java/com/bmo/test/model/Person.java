package com.bmo.test.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;

    public Person(){}

    public Person(String firstName, String lastName) {
        this.first_name = firstName;
        this.last_name = lastName;
    }


    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

}
