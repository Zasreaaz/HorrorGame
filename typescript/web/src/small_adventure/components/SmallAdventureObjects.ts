import { LitElement, TemplateResult, css, html, nothing } from "lit";
import { customElement, property } from "lit/decorators.js";

@customElement("small-adventure-objects")
export class SmallAdventureObjects extends LitElement {
    public static styles = css`
    
        button {
            background-color: #7f6ed7;
            border: 1px solid #332c57;
            padding: 5px 10px;
            margin: 0 0 10px 10px;
            text-transform: uppercase;
            cursor: pointer;
            display: inline-block;
            user-select: none;
        }
    `;

    @property()
    public objectsInRoom: any[] = [];

    protected render(): TemplateResult {
        return html`
            ${this.objectsInRoom && this.objectsInRoom.constructor === Array
                ? this.objectsInRoom?.map(
                      (object) =>
                          html`<div>
                               ${object.shortDescription} :
                              <button actionurl="action/${object.id}/open" @click="${this.buttonHandler}">
                                  Open
                              </button>
                              <button actionurl="action/${object.id}/smell" @click="${this.buttonHandler}">
                                  Smell
                              </button>
                              <button actionurl="action/${object.id}/move" @click="${this.buttonHandler}">
                                  Eat
                              </button>
                              <button actionurl="action/${object.id}/talk" @click="${this.buttonHandler}">
                                  Talk to
                              </button>
                          </div> `
                  )
                : nothing}
        `;
    }

    private buttonHandler(event: Event): void {
        const customEvent: CustomEvent = new CustomEvent("action-clicked", { detail: event.target });
        this.dispatchEvent(customEvent);
    }
}
