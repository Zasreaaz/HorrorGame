import { LitElement, TemplateResult, css, html } from "lit";
import { customElement, property } from "lit/decorators.js";

@customElement("small-adventure-canvas")
export class SmallAdventureCanvas extends LitElement {
    public static styles = css`
        .game {
            height: 100%;
            display: flex;
            flex-direction: column;
        }

        .title {
            text-align: center;
            margin-top: 10px;
        }
         div{
            border: black;
            padding: 10px;
            margin: 10px;
         }
        
         .border-div{
            border: solid white;
            padding: 10px;
            margin: 10px;
            background-color: #52478b;
         }

         section{
            border: solid black;
            padding: 10px;
            margin: 10px;
         }
    `;

    @property()
    private lastActionResult?: string;

    @property()
    private scenarioFullDescription: string ="";

    @property()
    private scenarioShortDescription: string ="";

    @property()
    private contentText: string ="";

    @property({type:Array})
    private actionButtons:any[] =[];

    public connectedCallback(): void {
        super.connectedCallback();
        void this.refreshState("start");
    }

    private async refreshState(method:string): Promise<void> {
        const response: Response = await fetch(
            "http://localhost:3001/" + method,
            {
                method: "GET",
                headers: {
                    "player-session-id": this.getPlayerSessionId(),
                },
            }
        );
        
        if ( response.ok){
            const result:any = await  response.json();
            this.scenarioFullDescription = result.currentRoom.fullDescription;
            this.scenarioShortDescription = result.currentRoom.shortDescription;
            this.lastActionResult = result.lastActionResult;
            this.actionButtons = [] ;
            for (let i:number = 0; i < result.objectsInRoom.length; i++){
                this.actionButtons.push( result.objectsInRoom[i]);
              };
        }
    }


    private  startGame(): void {
        if (!confirm("Are you sure you want to start a new game?")) {
            return;
        }
        else {
            void this.refreshState("start");
        }
    }   

    protected render(): TemplateResult {
        return html`
            <section class="game">
                ${this.renderTitle()} ${this.renderContent()} ${this.renderFooter()}
            </section>
        `;
    }

    private renderTitle(): TemplateResult {
            return html` <div><button @click=${this.startGame}> (Re) Start game</button> </div
            `;
    }

    private renderLastResult(): TemplateResult {
        return html`
            ${this.lastActionResult && this.lastActionResult !== ""
                ? 
                          html`<div class="border-div" ><b> Result: ${this.lastActionResult}</b></div>`
                :  html`<div class="border-div" ><b> Result: ${this.lastActionResult}</b></div>`}
        `;
    }


    private renderContent(): TemplateResult {
        return html`
            <div class="border-div"> 
        <div >Current room: ${this.scenarioShortDescription}</div>
        <div >Room description: ${this.scenarioFullDescription}   </div>
            </div>
    ${this.renderLastResult()}
        <div class="border-div">
        <div >Objects in the room:  </div>
      
       <small-adventure-objects .objectsInRoom=${this.actionButtons} @action-clicked="${this.actionClicked}">    </small-adventure-objects>
    </div>`;
    }

    private async actionClicked(e:any):Promise<void> {
        const action:string = e.detail.getAttribute("actionurl");
        await  this.refreshState(action);
    }

    private renderFooter(): TemplateResult {
        return html`
            <small-adventure-footer/>
        `;
    }

     private getPlayerSessionId(): string {
        let playerSessionId: string | null = localStorage.getItem("playerSessionId");
        if (!playerSessionId) {
            playerSessionId = crypto.randomUUID();
            localStorage.setItem("playerSessionId", playerSessionId);
        }
        console.log(playerSessionId);
        return playerSessionId;
    }
 
}