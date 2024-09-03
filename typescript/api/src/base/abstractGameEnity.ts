/**
 * Abstract class that represents any form of object in the game
 * Abstract classes Room and GameObject extend this class
 *
 */
export abstract class AbstractGameEnity {
    private _id: string;

    public getShortDescription(): string {
        return "A object";
    }

    public getFullDescription(): string {
        return "A very nice object";
    }

    public constructor(id: string) {
        this._id = id;
    }

    public get id(): string {
        return this._id;
    }

}