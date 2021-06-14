package com.example.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pokemon {
    private List<Abilities> abilities = new ArrayList<>();
}
