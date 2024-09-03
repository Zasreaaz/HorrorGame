import {Request} from "express-serve-static-core";
import {PlayerSession} from "./playerSession";


/**
 * Class the returns and holds the session
 *
 */
export class PlayerSessionService {

    private sessions: Map<string, PlayerSession> = new Map<string, PlayerSession>();

    private static instance: PlayerSessionService;
    private playerSessionId = "player-session-id";


    /**
     * Method that returns the PlayerSession based on a request header
     *
     * @param req: Request that holds data from the http client request
     *
     @returns PlayerSession, that holds data related to the games player session (current room, inventory etc)
     */
    public getPlayerSession(req: Request): PlayerSession {

        let sessionId: string = req.headers[this.playerSessionId] as string;
        if (sessionId === undefined) {
            //For simplicity reasons a default session is used
            console.log("Error not session-id found on request, using default player session id");
            sessionId = "default";
        }
        let playerSession: PlayerSession | undefined = this.sessions.get(sessionId);
        if (playerSession === undefined) {
            playerSession = new PlayerSession();
            this.sessions.set(sessionId, playerSession);
            console.log("Creating new session");
        }
        return playerSession;
    }

    /**
     * Method that resets the game to the initial state
     *
     * @param req: Request that holds data from the http client request
     *
     * @returns PlayerSession, the player session that has been reset.
     */
    public resetPlayerSession(req: Request): PlayerSession {
        let sessionId: string = req.headers[this.playerSessionId] as string;
        if (sessionId === undefined) {
            //For simplicity reasons a default session is used
            console.log("Error no session-id found on request, using default player session");
            sessionId = "default";
        }
        const playerSession: PlayerSession = new PlayerSession();
        this.sessions.set(sessionId, playerSession);
        return playerSession;
    }


    /**
     * Static method that returns the one and only instance (Singleton)
     *
     */
    public static getInstance(): PlayerSessionService {
        if (this.instance === undefined) {
            this.instance = new PlayerSessionService();
        }
        return this.instance;
    }


}