package com.aslam.masterspringjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    /* (strategy = GenerationType.SEQUENCE, generator = "author_sequence") */
    /* @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1) */
    private Integer id;
    @Column(length = 20)
    private String firstname;
    @Column(length = 30)
    private String lastname;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime lastModified;
}
