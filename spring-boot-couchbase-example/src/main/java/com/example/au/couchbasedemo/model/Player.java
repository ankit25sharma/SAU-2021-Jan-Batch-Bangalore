package com.example.au.couchbasedemo.model;

import javax.persistence.Id;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Player {
    
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private Double average;
    
    @Field
    private int runs;

    @Field
    private int wickets;


    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Double return the average
     */
    public Double getAverage() {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(Double average) {
        this.average = average;
    }

    /**
     * @return int return the runs
     */
    public int getRuns() {
        return runs;
    }

    /**
     * @param runs the runs to set
     */
    public void setRuns(int runs) {
        this.runs = runs;
    }

    /**
     * @return int return the wickets
     */
    public int getWickets() {
        return wickets;
    }

    /**
     * @param wickets the wickets to set
     */
    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public Player(String id, String name, Double average, int runs, int wickets) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.runs = runs;
        this.wickets = wickets;
    }

    public Player() {
    }

}