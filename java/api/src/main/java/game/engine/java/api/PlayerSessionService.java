package game.engine.java.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Class the returns and holds the session
 */
public class PlayerSessionService {
    private static PlayerSessionService instance;
    // TODO Replace the below playerSession with a map of playerSessions (one for each client / player) ----
    private Map<String, PlayerSession> map = new HashMap<String, PlayerSession>();
    private PlayerSession playerSession = new PlayerSession();

    /**
     * Static method that returns the one and only instance (Singleton)
     */
    public static PlayerSessionService getInstance() {
        if (PlayerSessionService.instance == null) {
            PlayerSessionService.instance = new PlayerSessionService();
        }
        return instance;
    }

    /**
     * Method that returns the PlayerSession based on a request header
     *
     * @param sessionId: Request that holds data from the http client request
     * @returns PlayerSession, that holds data related to the games player session (current room, inventory etc)
     */

    // TODO return session based on id, instead of always the same session ----
    public PlayerSession getPlayerSession(String sessionId) {
        if (map.containsKey(sessionId)) {
            return map.get(sessionId);
        }
        return playerSession;
    }

    /**
     * Method that resets the game to the initial state
     *
     * @param sessionId: Request that holds data from the http client request
     * @returns PlayerSession, the player session that has been reset.
     */
    // TODO return session based on id, instead of always the same session ----
    public PlayerSession resetPlayerSession(String sessionId) {
        if (sessionId == null) {
            sessionId = "default";
        }
        this.playerSession = new PlayerSession();
        this.map.put(sessionId, this.playerSession);
        return playerSession;
    }

}
