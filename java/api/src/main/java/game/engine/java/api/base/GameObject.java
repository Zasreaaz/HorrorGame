package game.engine.java.api.base;


import game.engine.java.api.PlayerSession;

/**
 * Abstract class that represents any form of object in the game
 * Abstract classes Room and GameObject implement this class
 */
public abstract class GameObject extends AbstractGameEntity {

    public GameObject(String id) {
        super(id);
    }

    public String smell(PlayerSession playerSession) {
        return "How weird";
    }

    public String move(PlayerSession playerSession) {
        return "You idiot!";
    }

    public String open(PlayerSession playerSession) {
        return "You can't";
    }

    public String talkTo(PlayerSession playerSession) {
        return "no response";
    }

}
