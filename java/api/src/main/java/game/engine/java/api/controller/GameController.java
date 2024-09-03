package game.engine.java.api.controller;

import game.engine.java.api.GameTemplate;
import game.engine.java.api.PlayerSession;
import game.engine.java.api.PlayerSessionService;
import game.engine.java.api.ResponseBuilder;
import game.engine.java.api.base.GameObject;
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
        PlayerSession playerSession = playerSessionService.getPlayerSession(sessionId);
        Room room = gameTemplate.getRoomById(playerSession.getCurrentRoom());
        GameStateResponse gameStateObjectResponse = new GameStateResponse();

                GameObject gameObject = room.findObjectById(objectId);
                    String actionsResultString;
                    switch (actionId) {
                        case "open":
                            actionsResultString = gameObject.open(playerSession);
                            break;
                        case "smell":
                            actionsResultString = gameObject.smell(playerSession);
                            break;
                        case "move":
                            actionsResultString = gameObject.move(playerSession);
                            break;
                            default:
                                actionsResultString = gameObject.talkTo(playerSession);
                    }

                    Room CurrentRoom = gameTemplate.getRoomById(playerSession.getCurrentRoom());
                    if (CurrentRoom != null) {
                        ResponseBuilder.fillResponse(CurrentRoom, gameStateObjectResponse);
                    }
                    gameStateObjectResponse.setLastActionResult(actionsResultString);

                    return gameStateObjectResponse;
    }
}
