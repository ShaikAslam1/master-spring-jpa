package com.aslam.masterspringjpa.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "SELECT a FROM Author a WHERE a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "UPDATE Author a SET a.age = :age"
        )
})
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

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Course> courses;

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
