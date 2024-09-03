import {LitElement, TemplateResult, css, html} from "lit";
import {customElement} from "lit/decorators.js";

@customElement("small-adventure-header")
export class SmallAdventureFooter extends LitElement {
    public static styles = css`   
    a:visited {
        color: white;  
    }
     a {
        color: white;  
    }
    `;

    protected render(): TemplateResult {
        return html`
            <header>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/small_adventure">Small adventure</a></li>

                </ul>
            </header>
        `;
    }

}
