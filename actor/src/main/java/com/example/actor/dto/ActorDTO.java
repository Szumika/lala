package com.example.actor.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ActorDTO {
    private String firstName;
    private String lastName;

    public ActorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
