package game.engine.java.api.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds data, related to the game state, that is returned to the client
 */
public class GameStateResponse {
    private GameEntityResponse currentRoom;
    private List<GameEntityResponse> objectsInRoom = new ArrayList<>();
    private String lastActionResult;

    public void setCurrentRoom(GameEntityResponse currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<GameEntityResponse> getObjectsInRoom() {
        return objectsInRoom;
    }

    public void setObjectsInRoom(List<GameEntityResponse> objectsInRoom) {
        this.objectsInRoom = objectsInRoom;
    }

    public String getLastActionResult() {
        return lastActionResult;
    }

    public void setLastActionResult(String lastActionResult) {
        this.lastActionResult = lastActionResult;
    }
}
