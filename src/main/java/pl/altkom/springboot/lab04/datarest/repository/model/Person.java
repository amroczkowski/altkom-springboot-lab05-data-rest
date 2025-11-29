package pl.altkom.springboot.lab04.datarest.repository.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "person")
    private List<Address> addresses = new ArrayList<>();
}
