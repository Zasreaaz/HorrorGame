package game.engine.java.api.items;

import game.engine.java.api.PlayerSession;
import game.engine.java.api.base.GameObject;

public class Bed extends GameObject {


    public Bed(String id) {
        super(id);
    }

    public String smell(PlayerSession playerSession) {
        return "De bed ruikt naar shit";
    }

    public String open(PlayerSession playerSession) {
        return "Je ligt lekker rustig nu in bed";
    }


    public String getShortDescription() {
        return "A Big Bed";
    }

    public String getFullDescription() {
        return "Its a king sized bed with a pile of gold on it";
    }

}
