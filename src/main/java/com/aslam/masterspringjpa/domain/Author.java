package com.aslam.masterspringjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author extends BaseEntity {
//    @Id
//    @GeneratedValue
    /* (strategy = GenerationType.SEQUENCE, generator = "author_sequence") */
    /* @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1) */
//    private Integer id;
    @Column(length = 20)
    private String firstname;
    @Column(length = 30)
    private String lastname;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
