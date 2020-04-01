package it.polimi.ingsw.utils;


import java.util.ArrayList;
import java.util.List;


public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();

    public void addObservers(Observer<T> observer){
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer){
        observers.remove(observer);
    }

    public void notify(T message){
        for(Observer<T> observer: observers){
            observer.update(message);
        }
    }

}