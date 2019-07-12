package com.example.actor.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
public class Film implements Serializable {
    private Long filmId;
    private String title;
    private String description;
}
