import {AbstractGameEnity} from "./abstractGameEnity";
import {PlayerSession} from "../playerSession";

/**
* Abstract class that represents an object that can be in a room
* All other object should extend this class
*
*
*/
export abstract class GameObject extends AbstractGameEnity {

    public smell(_playerSession: PlayerSession): string {
        return "How weird";
    }

    public move(_playerSession: PlayerSession): string {
        return "You idiot!";
    }

    public open(_playerSession: PlayerSession): string {
        return "You can't";
    }

    public talkTo(_playerSession: PlayerSession): string {
        return "no response";
    }

}