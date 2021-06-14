package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonClient pokemonClient;

    @GetMapping("/{name}")
    public ResponseEntity<List<String>> getByName(@PathVariable String name) {

        try {
            Pokemon pokemon = pokemonClient.getByName(name);

            List<String> abilitiesName = pokemon.getAbilities()
                    .stream()
                    .map(abilities -> abilities.getAbility().getName())
                    .sorted()
                    .collect(Collectors.toList());

            return ResponseEntity.ok(abilitiesName);
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }

}
