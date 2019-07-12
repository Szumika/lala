package com.example.film.Model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Film {
    @Id
    @GeneratedValue
    public Long filmId;
    public String title;
    public String description;


}
