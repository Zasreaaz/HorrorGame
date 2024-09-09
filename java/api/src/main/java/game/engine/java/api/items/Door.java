package game.engine.java.api.items;

import game.engine.java.api.PlayerSession;
import game.engine.java.api.base.GameObject;

public class Door extends GameObject {

    public Door(String id) {
        super(id);
    }

    @Override
    public String open(PlayerSession playerSession) {
        if (playerSession.getInventory().contains("magicalkeys")) {
            playerSession.setCurrentRoom("bed_room");
            return "You opened the door";
        } else {
            return "Find the magical key first";
        }
    }

    public String getShortDescription() {
        return "A Big Door";
    }

    public String getFullDescription() {
        return "A Mysterious looking door that gives of a dark mist from it surroundings";
    }
}
