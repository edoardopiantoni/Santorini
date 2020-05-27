package it.polimi.ingsw.model.cards;

import it.polimi.ingsw.model.map.Building;
import it.polimi.ingsw.model.map.Directions;
import it.polimi.ingsw.model.map.GameMap;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.player.Worker;
import it.polimi.ingsw.model.Response;
import it.polimi.ingsw.utils.ConstantsContainer;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {

    private final String name;
    private final String description;
    private final boolean isPlayableIn3;
    private final CardType type;
    private final CardSubType subType;

    public Card(String name, String description, boolean isPlayableIn3, CardType type, CardSubType subType)
    {
        this.name = name;
        this.description = description;
        this.isPlayableIn3 = isPlayableIn3;
        this.type = type;
        this.subType = subType;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public boolean isPlayableIn3() {
        return isPlayableIn3;
    }

    public CardType getType() {
        return type;
    }

    public CardSubType getSubType() {
        return subType;
    }

    public Response getFirstAction(){
        return Response.TOMOVE;

    }

    public List<Directions> findWorkerMove(GameMap gameMap, Worker worker) {
        if(gameMap == null || worker == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        return gameMap.reachableSquares(worker);
    }

    public Response executeWorkerMove(GameMap gameMap, Directions directions, Player player) {
        if(gameMap == null || player == null || directions == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        gameMap.moveWorkerTo(player, directions);
        return  Response.MOVED;
    }

    public List<Directions> findPossibleBuild(GameMap gameMap, Worker worker) {
        if(gameMap == null || worker == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        return gameMap.buildableSquare(worker);
    }

    public Response executeBuild(GameMap gameMap, Building building, Directions directions, Worker worker) {
        if(gameMap == null || worker == null || building == null || directions == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        if(gameMap.buildInSquare(worker, directions, building))
            return Response.BUILD;
        else
            return Response.NOTBUILD;
    }

    public Response checkVictory(GameMap gameMap, Player player) {
        if(gameMap == null || player == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        if(player.getCurrentWorker().getBoardPosition().getBuildingLevel() == ConstantsContainer.WINNINGLEVEL
                && player.getCurrentWorker().getPreviousBoardPosition().getBuildingLevel() == ConstantsContainer.WINNINGLEVEL -1)
            return Response.WIN;
        return Response.NOTWIN;
    }

    public List<Directions> eliminateInvalidMove(GameMap gameMap, Worker worker, List<Directions> directionsArrayList) {
        if(gameMap == null || worker == null || directionsArrayList == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        return directionsArrayList;
    }

    public boolean canMove(Player player, Worker worker) {
        if(player == null || worker == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        return true;
    }

    public boolean isValidVictory(GameMap gameMap, Worker worker) {
        if(gameMap == null || worker == null)
            throw new NullPointerException(ConstantsContainer.NULLPARAMETERS);

        return true;
    }

    public void resetCard(){
       //used only in some specific cards
    }

    @Override
    public String toString() {
        String result = "Card Name -> " + name + "\nCard Description -> " + description;
        if(isPlayableIn3)
            result += "\nPlayable with 3 Player -> Yes\n";
        else
            result += "\nPlayable with 3 Player -> No\n";
        return result;
    }
}
