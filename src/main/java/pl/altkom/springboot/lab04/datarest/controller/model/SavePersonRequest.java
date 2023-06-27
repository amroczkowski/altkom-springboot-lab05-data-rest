package pl.altkom.springboot.lab04.datarest.controller.model;

import java.util.List;

import lombok.Data;

@Data
public class SavePersonRequest {
    private String firstName;
    private String lastName;
    private List<Address> addresses;

    @Data
    public static class Address {
        private String city;
    }
}
