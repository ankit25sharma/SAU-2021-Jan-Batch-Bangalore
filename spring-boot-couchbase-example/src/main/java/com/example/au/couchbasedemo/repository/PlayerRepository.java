package com.example.au.couchbasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Player;

public interface PlayerRepository extends CrudRepository<Player,String>{
    
}