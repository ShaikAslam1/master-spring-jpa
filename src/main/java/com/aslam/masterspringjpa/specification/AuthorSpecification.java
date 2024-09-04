package com.aslam.masterspringjpa.specification;

import com.aslam.masterspringjpa.domain.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
           if (age < 0)
               return null;
           return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> fistnameLike(String firstname) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (firstname == null)
                return null;
            return builder.like(root.get("firstname"), "%" + firstname + "%");
        };
    }
}
