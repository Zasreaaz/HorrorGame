package game.engine.java.api.controller;

import game.engine.java.api.GameTemplate;
import game.engine.java.api.PlayerSession;
import game.engine.java.api.PlayerSessionService;
import game.engine.java.api.ResponseBuilder;
import game.engine.java.api.base.Room;
import game.engine.java.api.response.GameStateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that hold all endpoints of the game
 */
@RestController
public class GameController {
    private final PlayerSessionService playerSessionService = PlayerSessionService.getInstance();
    private final GameTemplate gameTemplate = GameTemplate.getInstance();

    @GetMapping(path = "/test", produces = "application/json")
    public String getTestRoot() {
        return "oke";
    }

    @GetMapping(path = "/start", produces = "application/json")
    public GameStateResponse startGame(@RequestHeader(value = "player-session-id", required = false) String sessionId) {
        PlayerSession playerSession = playerSessionService.resetPlayerSession(sessionId);
        Room room = gameTemplate.getRoomById(playerSession.getCurrentRoom());
        GameStateResponse gameStateResponse = new GameStateResponse();
        ResponseBuilder.fillResponse(room, gameStateResponse);
        return gameStateResponse;
    }

    @GetMapping(path = "/state", produces = "application/json")
    public GameStateResponse getGameState(@RequestHeader(value = "player-session-id", required = false) String sessionId) {
        PlayerSession playerSession = playerSessionService.getPlayerSession(sessionId);
        Room room = gameTemplate.getRoomById(playerSession.getCurrentRoom());
        GameStateResponse gameStateResponse = new GameStateResponse();
        ResponseBuilder.fillResponse(room, gameStateResponse);
        return gameStateResponse;
    }

    @GetMapping(path = "/action/{objectId}/{actionId}", produces = "application/json")
    public GameStateResponse performAction(@PathVariable String objectId, @PathVariable String actionId, @RequestHeader(value = "player-session-id", required = false) String sessionId) {
        GameStateResponse gameState = new GameStateResponse();
        System.out.println("Error: method not yet implemented");
        // TODO add code that executes the required action
        return gameState;
    }
}
