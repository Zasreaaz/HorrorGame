package game.engine.java.api;

import game.engine.java.api.base.GameObject;
import game.engine.java.api.base.Room;
import game.engine.java.api.response.GameEntityResponse;
import game.engine.java.api.response.GameStateResponse;

public class ResponseBuilder {

    public static void fillResponse(Room room, GameStateResponse gameState) {
        GameEntityResponse roomObject = new GameEntityResponse();
        roomObject.setFullDescription(room.getFullDescription());
        roomObject.setShortDescription(room.getShortDescription());
        roomObject.setId(room.getId());
        gameState.setCurrentRoom(roomObject);
        for (GameObject object : room.getObjects()) {
            GameEntityResponse gameEntityResponse = new GameEntityResponse();
            gameEntityResponse.setId(object.getId());
            gameEntityResponse.setFullDescription(object.getFullDescription());
            gameEntityResponse.setShortDescription(object.getShortDescription());
            gameState.getObjectsInRoom().add(gameEntityResponse);
        }
    }
}
