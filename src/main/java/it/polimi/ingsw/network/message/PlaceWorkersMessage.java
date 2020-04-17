package it.polimi.ingsw.network.message;

public class PlaceWorkersMessage extends Message {

    private Integer[] tile1;
    private Integer[] tile2;

    public PlaceWorkersMessage(String sender, MessageType type, MessageSubType subType,Integer[] tile1,Integer[] tile2) {
        super(sender, MessageType.PLACEWORKERS, subType);
        this.tile1 = tile1;
        this.tile2 = tile2;
    }

    public Integer[] getTile1() {
        return tile1;
    }

    public Integer[] getTile2() {
        return tile2;
    }
}