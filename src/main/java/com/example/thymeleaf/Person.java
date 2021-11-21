package com.example.thymeleaf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.SecureRandom;

@Entity
public class Person {

    private char token = 'x';
    @Id@GeneratedValue Long id;

    private String name;

    Person(){}
    Person(String name, char token){
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
    }
}
