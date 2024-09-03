import {PlayerSession} from "../playerSession";
import {GameObject} from "../base/gameObject";

export class BoxWithGoldenKey extends GameObject {

    public open(_playerSession: PlayerSession): string {
        if (_playerSession.inventory.includes("golden key")) {
            return "it is empty";
        } else {
            _playerSession.inventory.push("golden key");
            return "You found a golden key";

        }
    }

    public getShortDescription(): string {
        return "A small ugly box";
    }

    public getFullDescription(): string {
        return "A small and ugly box";
    }

}