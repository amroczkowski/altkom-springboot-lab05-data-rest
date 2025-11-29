package pl.altkom.springboot.lab04.datarest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.altkom.springboot.lab04.datarest.controller.model.SavePersonRequest;
import pl.altkom.springboot.lab04.datarest.repository.AddressRepository;
import pl.altkom.springboot.lab04.datarest.repository.PersonRepository;
import pl.altkom.springboot.lab04.datarest.repository.model.Address;
import pl.altkom.springboot.lab04.datarest.repository.model.Person;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public Person getPerson(final long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

//    public List<Person> getPeople() {
//        final List<Person> people = personRepository.findAll();
//        final List<Long> peopleId = people.stream()
//                .map(Person::getId)
//                .collect(Collectors.toList());
//        final List<Address> addresses = addressRepository.findByPersonIdIn(peopleId);
//        people.forEach(person -> person.setAddresses(addresses.stream()
//                .filter(address -> address.getPerson().getId().equals(person.getId()))
//                .collect(Collectors.toList())));
//        return people;
//    }

    public Person savePerson(final SavePersonRequest request) {
        final Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());

        request.getAddresses().forEach(address -> {
            final Address a = new Address();
            a.setCity(address.getCity());
            a.setPerson(person);
            person.getAddresses().add(a);
        });

        return personRepository.save(person);
    }

    public Person getPerson(final String firstName, final String lastName) {
        //        return personRepository.findByFirstNameAndLastName(firstName, lastName).stream()
        //                .findFirst()
        //                .orElseThrow();

        //        return personRepository.findByName(firstName, lastName).stream()
        //                .findFirst()
        //                .orElseThrow();

        return personRepository.findByNameNative(firstName, lastName).stream()
                .findFirst()
                .orElseThrow();
    }
}
