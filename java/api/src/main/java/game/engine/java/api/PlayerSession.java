package game.engine.java.api;

/**
 * Class that holds data related to the games player session (current room, inventory etc)
 */
public class PlayerSession {
    private String currentRoom = "start_room";

    // TODO add inventory to the PlayerSession
    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }
}
