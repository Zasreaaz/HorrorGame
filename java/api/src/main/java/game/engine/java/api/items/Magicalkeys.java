package game.engine.java.api.items;

import game.engine.java.api.base.GameObject;

public class Magicalkeys extends GameObject {
    private String name;

    public Magicalkeys(String id) {
        super(id);
        this.name = "magicalkeys";
    }

    public String getName() { return name; }
}
