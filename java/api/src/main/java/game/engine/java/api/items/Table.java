package game.engine.java.api.items;

import game.engine.java.api.base.GameObject;

public class Table extends GameObject {

    public Table(String id) {
        super(id);
    }

    public String getShortDescription() {
        return "A small table";
    }

    public String getFullDescription() {
        return "A small table";
    }

}
