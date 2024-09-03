package game.engine.java.api;

/**
 * Class the returns and holds the session
 */
public class PlayerSessionService {
    private static PlayerSessionService instance;
    // TODO Replace the below playerSession with a map of playerSessions (one for each client / player)
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

    // TODO return session based on id, instead of always the same session
    public PlayerSession getPlayerSession(String sessionId) {
        return playerSession;
    }

    /**
     * Method that resets the game to the initial state
     *
     * @param sessionId: Request that holds data from the http client request
     * @returns PlayerSession, the player session that has been reset.
     */
    // TODO return session based on id, instead of always the same session
    public PlayerSession resetPlayerSession(String sessionId) {
        this.playerSession = new PlayerSession();
        return playerSession;
    }

}
