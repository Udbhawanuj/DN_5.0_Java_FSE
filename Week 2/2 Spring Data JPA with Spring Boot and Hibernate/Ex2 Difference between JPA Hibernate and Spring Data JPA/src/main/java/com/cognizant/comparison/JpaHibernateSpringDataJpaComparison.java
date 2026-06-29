package com.cognizant.comparison;
public class JpaHibernateSpringDataJpaComparison {
    public static void main(String[] args) {
        System.out.println("JPA, Hibernate, and Spring Data JPA Comparison");
        System.out.println();
        System.out.println("JPA:");
        System.out.println("- JPA is a specification used for ORM in Java.");
        System.out.println("- It defines annotations and interfaces but does not provide implementation by itself.");
        System.out.println();
        System.out.println("Hibernate:");
        System.out.println("- Hibernate is an implementation of the JPA specification.");
        System.out.println("- It handles the actual database operations and object-relational mapping.");
        System.out.println();
        System.out.println("Spring Data JPA:");
        System.out.println("- Spring Data JPA is built on top of JPA.");
        System.out.println("- It reduces boilerplate code by providing repository interfaces like JpaRepository.");
        System.out.println();
        System.out.println("Conclusion:");
        System.out.println("JPA defines the rules, Hibernate implements them, and Spring Data JPA makes data access easier.");
    }
}
