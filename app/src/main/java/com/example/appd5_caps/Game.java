package com.example.appd5_caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db;
    public Game()
    {
        this.db = new CountryDB();
    }

    public String qa()
    {
        String result = "";
        List<String> capitals = db.getCapitals();
        int totalNum = capitals.size() - 1 ;
        Map<String, Country> data = db.getData();
        int n = (int) (totalNum * Math.random());
        String cap = capitals.get(n);
        Country c = data.get(cap);
        String cName = c.getName();
        if(Math.random() < 0.5) result = "What is the capital of " + cName + "\n" + cap;
        else result = cap + " is the capital of?\n" + cName;

        return result;
    }
}