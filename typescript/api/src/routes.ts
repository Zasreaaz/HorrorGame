import {Router} from "express";
import {GameTemplate} from "./gameTemplate";
import {GameStateResponse} from "./response/gameStateResponse";
import {PlayerSession} from "./playerSession";
import {PlayerSessionService} from "./playerSessionService";
import {ResponseBuilder} from "./responseBuilder";
import {Room} from "./base/room";
import {GameObject} from "./base/gameObject";

export const router: Router = Router();
export const gameTemplate: GameTemplate = GameTemplate.getInstance();
export const playerSessionService: PlayerSessionService = PlayerSessionService.getInstance();


/**
 * Holds all endpoint
 *
 */
router.get("/test", (_, res) => {
    res.status(200).json({status: "oke"});
});


router.get("/start", (req, res) => {
    const playerSession: PlayerSession = playerSessionService.resetPlayerSession(req);
    const responseObject: GameStateResponse = new GameStateResponse();
    const currentRoom: Room | undefined = gameTemplate.getRoom(playerSession.currentRoom);
    if (currentRoom) {
        ResponseBuilder.fillResponse(currentRoom, responseObject);
    }
    res.status(200).json(responseObject);
});

router.get("/state", (req, res) => {
    const playerSession: PlayerSession = playerSessionService.getPlayerSession(req);
    const responseObject: GameStateResponse = new GameStateResponse();
    const currentRoom: Room | undefined = gameTemplate.getRoom(playerSession.currentRoom);
    if (currentRoom) {
        ResponseBuilder.fillResponse(currentRoom, responseObject);
    }
    res.status(200).json(responseObject);
});

router.get("/action/:objectId/:actionId", (req, res) => {
    const playerSession: PlayerSession = playerSessionService.getPlayerSession(req);
    let actionResultString: string = "";
    const currentRoom: Room = gameTemplate.getRoom(playerSession.currentRoom);

    const object: GameObject| undefined = currentRoom.findObjectById(req.params.objectId);

    if (object) {
        if (req.params.actionId === "open") {
            actionResultString = object.open(playerSession);
        } else if (req.params.actionId === "smell") {
            actionResultString = object.smell(playerSession);
        } else if (req.params.actionId === "move") {
            actionResultString = object.move(playerSession);
        } else {
            actionResultString = object.talkTo(playerSession);
        }
    }

    const newRoom: Room = gameTemplate.getRoom(playerSession.currentRoom);
    const responseObject: GameStateResponse = new GameStateResponse();

    if (newRoom) {
        ResponseBuilder.fillResponse(newRoom, responseObject);
    }
    responseObject.lastActionResult = actionResultString;
    res.status(200).json(responseObject);

});
