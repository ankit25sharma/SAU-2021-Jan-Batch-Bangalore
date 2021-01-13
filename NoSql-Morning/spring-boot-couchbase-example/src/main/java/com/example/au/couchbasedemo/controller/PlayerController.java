package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.au.couchbasedemo.model.Player;
import com.example.au.couchbasedemo.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }
    
    @GetMapping("/player/{id}")
    public Optional<Player> getBlog(@PathVariable String id) {
        if (playerRepository.existsById(id)) {
            return playerRepository.findById(id);
        } else
            return Optional.empty();
    }
    @GetMapping("/player/getParticularDetails/{value}")
    public List<Player> searchPlayer(@PathVariable int value)
    {
        Iterable<Player> temp= playerRepository.findAll();
        List<Player> res = new ArrayList<>();
        for(Player i:temp)
        {
            if(i.getRuns()>value)
                res.add(i);
        }
        return res;
    }
}