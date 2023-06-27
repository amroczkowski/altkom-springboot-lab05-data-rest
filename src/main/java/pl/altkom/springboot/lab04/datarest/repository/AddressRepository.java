package pl.altkom.springboot.lab04.datarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.springboot.lab04.datarest.repository.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByPersonIdIn(final List<Long> personId);
}
