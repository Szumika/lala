package com.example.film.Controller;


import com.example.film.dto.ActorDTO;
import com.example.film.Model.Film;
import com.example.film.Repository.FilmRepository;
import com.example.film.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class FilmController {

    @Autowired
    private FilmRepository fr;

    @Value(value = "${actor.host}")
    String actorHost;


    @RequestMapping("/")
    public String hello() {
        return "ej no kurde";
    }

    @RequestMapping("/films/{id}")
    public Film films(@PathVariable Long id) {
        Film film = fr.findById(id).orElseThrow(() -> new NotFoundException("no nie ma takiego"));
        return film;
    }

    @RequestMapping("films/actors/{id}")
    public ResponseEntity<String> actors(@PathVariable Long id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String Url = actorHost + "/actors/";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Url + id, String.class);
        return responseEntity;
    }


    @RequestMapping(value = "films/actors/post/{firstName}/{lastName}")
        public void add(@PathVariable String firstName , @PathVariable String lastName){

            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = actorHost + "/actors/add";

            HttpEntity<ActorDTO> request = new HttpEntity<>(new ActorDTO(firstName, lastName));
//            ActorDTO actorDTO = restTemplate.postForObject(resourceUrl, request, ActorDTO.class);


             ResponseEntity<ActorDTO> response = restTemplate.exchange(resourceUrl, HttpMethod.POST,request, ActorDTO.class );
        }

    @RequestMapping(value = "films/actors/update/{id}/{firstName}/{lastName}")
    public void update(@PathVariable String firstName , @PathVariable String lastName, @PathVariable Long id){

        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = actorHost + "/actors/update/"+id;
        HttpEntity<ActorDTO> request = new HttpEntity<>(new ActorDTO(firstName, lastName));

        ResponseEntity<ActorDTO> response = restTemplate.exchange(resourceUrl, HttpMethod.PUT,request, ActorDTO.class );
    }







//        @RequestMapping(value = "films/actors/delete/{id}")
//        public String deleteActorById(@PathVariable Long id){
//            RestTemplate restTemplate = new RestTemplate();
//            String resourceUrl = "http://localhost:8081/actors/delete/"+id;
//
//            restTemplate.delete(resourceUrl);
//
//            return "usuwanie";
//        }

}
