package com.example.actor.Controller;


import com.example.actor.dto.ActorDTO;
import com.example.actor.model.Actor;
import com.example.actor.model.Film;
import com.example.actor.repositories.ActorRepository;
import com.example.actor.repositories.ActorsNameOnly;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository Ar;

    @RequestMapping("/actors/{id}")
    public Collection<ActorsNameOnly> films(@PathVariable Long id) {
        return Ar.findByActorId(id);
    }
    @RequestMapping("/actors/films/{id}")
            public ResponseEntity<String> actors(@PathVariable Long id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String Url = "http://localhost:8080/films/";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Url + id, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(responseEntity.getBody());
//        JsonNode title = root.path("title");
        return responseEntity;
    }

    @RequestMapping("/actors/films/{id}/try")
    public Film try1(@PathVariable Long id){
        RestTemplate restTemplate = new RestTemplate();
        String Url = "http://localhost:8080/films/";
        Film film = restTemplate
                .getForObject(Url + id, Film.class);
    return film;
    }

    @RequestMapping(value = "/actors/add", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody ActorDTO actor){
        Actor actor1 = new Actor(actor.getFirstName(),actor.getLastName());
        Ar.save(actor1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/actors/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateActor(@RequestBody ActorDTO actor, @PathVariable Long id){
        Actor a1 = Ar.findById(id).get();
        a1.setFirstName(actor.getFirstName());
        a1.setLastName(actor.getLastName());
        Ar.save(a1);
        return ResponseEntity.noContent().build();   }


    @RequestMapping(value = "/actors/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteActor(@PathVariable Long id){
        Actor actor = Ar.findById(id).get();
        Ar.delete(actor);
        return ResponseEntity.noContent().build();   }




}
