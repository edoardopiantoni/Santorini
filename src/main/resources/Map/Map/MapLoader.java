package it.polimi.ingsw.model.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


import java.awt.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MapLoader {

    private MapLoader(){

        throw new IllegalStateException("Impossible to instantiate MapLoader Class");

    }

    private class SquareContainer{

        Integer tile;
        int buildingLevel;
        Building building;
        boolean hasPlayer;
        Integer[] canAccess;
    }

    public static ArrayList<Square> loadMap(){
        Gson gsonMap = new Gson();
        SquareContainer[] containers;

        try{
            String mapPath = "/Map/Map.json";
            InputStreamReader gameMapInput = new InputStreamReader(MapLoader.class.getResourceAsStream(mapPath));
            JsonReader gameMapReader = new JsonReader(gameMapInput);
            containers = gsonMap.fromJson(gameMapReader,SquareContainer[].class);

        }catch (Throwable e){

            throw new IllegalStateException("impossible to charge Squares");

        }

        ArrayList<Square> squares = new ArrayList<>();

        for(SquareContainer container: containers){

            HashMap<Directions,Integer> canAccess = createHashMapFromArray(container.canAccess);
            squares.add(new Square(container.tile,container.buildingLevel,container.building,container.hasPlayer,canAccess));

        }

        return squares;
    }

    private static HashMap<Directions,Integer> createHashMapFromArray(Integer[] canAccess) {

        HashMap<Directions, Integer> constructorMap = new HashMap<>();
        int i = 0;
        for (Directions dir : Directions.values()) {

            constructorMap.put(dir,canAccess[i]);
            i++;

        }
        return constructorMap;
    }

}
