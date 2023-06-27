package pl.altkom.springboot.lab04.datarest.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.altkom.springboot.lab04.datarest.controller.model.SavePersonRequest;
import pl.altkom.springboot.lab04.datarest.repository.model.Person;
import pl.altkom.springboot.lab04.datarest.service.PersonService;

@RequiredArgsConstructor
@RequestMapping("/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") final long personId) {
        return personService.getPerson(personId);
    }

    @GetMapping("/{firstName}/{lastName}")
    public Person getPerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
        return personService.getPerson(firstName, lastName);
    }

    @PostMapping
    public Person savePerson(@RequestBody final SavePersonRequest request) {
        return personService.savePerson(request);
    }
}
