package com.example.film.Repository;

import com.example.film.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Collection<FilmWithoutId> findByFilmId(Long id);


}
