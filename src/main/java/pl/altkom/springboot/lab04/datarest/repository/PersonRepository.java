package pl.altkom.springboot.lab04.datarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.altkom.springboot.lab04.datarest.repository.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameAndLastName(final String firstName, final String lastName);

    @Query("select p from Person p where p.lastName = :lastName and p.firstName = :firstName")
    List<Person> findByName(@Param("firstName") final String firstName, @Param("lastName") final String lastName);

    @Query(value = "select * from person where last_name = :lastName and first_name = :firstName", nativeQuery = true)
    List<Person> findByNameNative(@Param("firstName") final String firstName, @Param("lastName") final String lastName);

}
