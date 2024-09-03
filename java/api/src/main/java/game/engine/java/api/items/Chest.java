package game.engine.java.api.items;

import game.engine.java.api.PlayerSession;
import game.engine.java.api.base.GameObject;

public class Chest extends GameObject {

    public Chest(String id) {
        super(id);
    }

    public String open(PlayerSession playerSession) {
        if (playerSession.getInventory().contains("magicalkeys")) {
            return "It is empty";
        } else {
            playerSession.addItemToInventory("magicalkeys");
            return "You found a magical key";
        }
    }

    public String getShortDescription() {
        return "A Big Chest";
    }

    public String getFullDescription() {
        return "A Big chest with some magical spells on them";
    }

}
