package game.engine.java.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds data related to the games player session (current room, inventory etc)
 */
public class PlayerSession {
    private String currentRoom = "start_room";
    private List<String> _inventory = new ArrayList<String>();
    public String getCurrentRoom() {
        return currentRoom;
    }

    public List<String> getInventory() {
        return _inventory;
    }
    public void addItemToInventory(String item) {
        this._inventory.add(item);
    }
    public void set_inventory(List<String> _inventory) {
        this._inventory = _inventory;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }


}
