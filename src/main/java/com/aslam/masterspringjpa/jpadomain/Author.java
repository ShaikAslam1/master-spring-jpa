package com.aslam.masterspringjpa.jpadomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String firstname;
    @Column(length = 30)
    private String lastname;
    private int age;
    private String email;
}
