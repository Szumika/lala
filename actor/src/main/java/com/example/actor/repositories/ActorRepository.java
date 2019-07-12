package com.example.actor.repositories;

import com.example.actor.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    <T>Collection<T> findByLastName(Class<T> type, String lastname);
    Collection<ActorsNameOnly> findByActorId(Long id);


}
