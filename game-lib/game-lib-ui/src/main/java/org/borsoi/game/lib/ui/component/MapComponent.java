package org.borsoi.game.lib.ui.component;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.borsoi.game.lib.object.object.map.GameMap;

@FacesComponent("components.MapComponent")
public class MapComponent
    extends UIComponentBase
{

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFamily()
    {
        return null;
    }

    @Override
    public void encodeBegin(FacesContext context)
        throws IOException
    {

        GameMap value = (GameMap) getAttributes().get("value");

        if (value != null)
        {
            ResponseWriter writer = context.getResponseWriter();
            // writer.write(value.toUpperCase());
            writer.startElement("table", null);
            for (int i = 0; i < 50; i++)
            {
                writer.startElement("tr", null);
                for (int y = 0; y < 50; y++)
                {
                    if (value.getTitle(i, y) == null)
                    {
                        writer.startElement("td", null);
                        writer.writeAttribute("style", "background-color:#EEE;  width:20px;", "");
                        writer.endElement("td");
                    }

                }
                writer.endElement("tr");
            }
            writer.endElement("table");
        }
    }
}
