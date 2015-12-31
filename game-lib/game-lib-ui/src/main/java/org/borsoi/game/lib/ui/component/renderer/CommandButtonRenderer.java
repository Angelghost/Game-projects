package org.borsoi.game.lib.ui.component.renderer;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;

@FacesRenderer(rendererType = "org.borsoi.component.CommandButtonRenderer", componentFamily = "org.primefaces.component")
public class CommandButtonRenderer
    extends org.primefaces.component.commandbutton.CommandButtonRenderer
{

    @Override
    protected void encodeMarkup(FacesContext context, CommandButton button)
        throws IOException
    {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = button.getClientId(context);
        String type = button.getType();
        String value = (String) button.getValue();
        String icon = button.resolveIcon();

        StringBuilder onclick = new StringBuilder();
        if (button.getOnclick() != null)
        {
            onclick.append(button.getOnclick()).append(";");
        }

        writer.startElement("button", button);
        writer.writeAttribute("id", clientId, "id");
        writer.writeAttribute("name", clientId, "name");
        writer.writeAttribute("class", button.resolveStyleClass(), "styleClass");

        if (!type.equals("reset") && !type.equals("button"))
        {
            String request;

            if (button.isAjax())
            {
                request = buildAjaxRequest(context, button, null);
            }
            else
            {
                UIComponent form = ComponentUtils.findParentForm(context, button);
                if (form == null)
                {
                    throw new FacesException("CommandButton : \"" + clientId + "\" must be inside a form element");
                }

                request = buildNonAjaxRequest(context, button, form, null, false);
            }

            onclick.append(request);
        }

        String onclickBehaviors = getOnclickBehaviors(context, button);
        if (onclickBehaviors != null)
        {
            onclick.append(onclickBehaviors).append(";");
        }

        if (onclick.length() > 0)
        {
            writer.writeAttribute("onclick", onclick.toString(), "onclick");
        }

        renderPassThruAttributes(context, button, HTML.BUTTON_ATTRS, HTML.CLICK_EVENT);

        if (button.isDisabled())
        {
            writer.writeAttribute("disabled", "disabled", "disabled");
        }
        if (button.isReadonly())
        {
            writer.writeAttribute("readonly", "readonly", "readonly");
        }

        // icon
        if (icon != null)
        {
            String defaultIconClass =
                button.getIconPos().equals("left") ? HTML.BUTTON_LEFT_ICON_CLASS : HTML.BUTTON_RIGHT_ICON_CLASS;
            String iconClass = defaultIconClass + " " + icon;

            writer.startElement("span", null);
            writer.writeAttribute("class", iconClass, null);
            writer.endElement("span");
        }

        // // text
        if (value != null && !value.isEmpty())
        {
            // writer.startElement("span", null);
            // writer.writeAttribute("class", HTML.BUTTON_TEXT_CLASS, null);

            if (button.isEscape())
            {
                writer.writeText(value, "value");
            }
            else
            {
                writer.write(value);
            }

            // writer.endElement("span");
        }

        writer.endElement("button");
    }
}
