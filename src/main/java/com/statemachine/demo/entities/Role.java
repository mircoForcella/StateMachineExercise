package com.statemachine.demo.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Embeddable
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Role(){}

    public Role(String name) {this.name=name;}

    public String getName(){return name; }

    public void setName(String name) {this.name= name; }


}