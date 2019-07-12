package com.example.actor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_actor_id_seq")
//    @SequenceGenerator(name="actor_actor_id_seq", sequenceName="actor_actor_id_seq")
    public Long actorId;
    public String firstName;
    public String lastName;


    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}