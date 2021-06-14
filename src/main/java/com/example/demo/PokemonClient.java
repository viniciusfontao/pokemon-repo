package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "pokemon", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokemonClient {

    @GetMapping(value = "/{name}", produces = "application/json")
    Pokemon getByName(@PathVariable("name") String name);

}
