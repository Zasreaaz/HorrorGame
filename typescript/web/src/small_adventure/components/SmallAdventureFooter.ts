import { LitElement, TemplateResult, css, html } from "lit";
import { customElement } from "lit/decorators.js";

@customElement("small-adventure-footer")
export class SmallAdventureFooter extends LitElement {
    public static styles = css`
    `;

    protected render(): TemplateResult {
        return html`
        <div class="footer">
         Footer
        </div>
    `;
    }
 
}
