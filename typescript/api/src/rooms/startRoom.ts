import {BoxWithBomb} from "../items/boxWithBomb";
import {BoxWithGoldenKey} from "../items/boxWithGoldenKey";
import {DoorToFinalRoom} from "../items/doorToFinalRoom";
import {Table} from "../items/table";
import {Room} from "../base/room";

export class StartRoom extends Room {

    public constructor() {
        super("start_room");
        this.objects.push(new Table("table"));
        this.objects.push(new BoxWithBomb("box_with_bomb"));
        this.objects.push(new BoxWithGoldenKey("box_with_golden_key"));
        this.objects.push(new DoorToFinalRoom("door_to_final_room"));
    }

    public getShortDescription(): string {
        return "Starting room";
    }

    public getFullDescription(): string {
        return "A very strange room. There is a table, two boxes and a closed door";
    }

}