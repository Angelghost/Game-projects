package org.borsoi.game.lib.ui.component;

import java.awt.Color;
import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.borsoi.game.lib.object.object.map.GameMap;
import org.borsoi.game.lib.object.object.map.Tile;
import org.borsoi.game.lib.object.object.map.tile.CityCase;

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
                        writer.writeAttribute("style", "background-color:#EEE;  width:20px; border:none;", "");
                        writer.endElement("td");
                    }
                    else
                    {
                        Tile tile = value.getTitle(i, y);

                        writer.startElement("td", null);
                        writer.writeAttribute("style", "background-color:" + getColor(tile.getType())
                            + ";  width:20px; border:none;padding-right: 4px;padding-left: 4px;height: 20px;", "");

                        if (tile.getValue() instanceof CityCase)
                        {
                            writer.write("X");
                        }
                        writer.endElement("td");
                    }

                }
                writer.endElement("tr");
            }
            writer.endElement("table");
        }
    }

    private String getColor(float t)
    {

        Color startColor;
        Color endColor;
        if (0 < t && t < 0.3)
        {
            startColor = new Color(164, 164, 164);
            endColor = new Color(204, 204, 204);
            return getColor(t, 0.3f, startColor, endColor);

        }
        else if (0.3 <= t && t < 0.5)
        {
            startColor = Color.GRAY;
            endColor = Color.GREEN;
            return getColor(t, 0.5f, startColor, endColor);

        }
        else if (0.5 <= t && t < 0.6)
        {
            startColor = Color.GREEN;
            endColor = Color.YELLOW;
            return getColor(t, 0.6f, startColor, endColor);

        }
        else
        {
            startColor = Color.YELLOW;
            endColor = Color.BLUE;
            return getColor(t, 1f, startColor, endColor);
        }
    }

    private String getColor(float t, float max, Color startColor, Color endColor)
    {
        float u = max - t;

        Color color =
            new Color((int) (startColor.getRed() * u + endColor.getRed() * t),
                (int) (startColor.getGreen() * u + endColor.getGreen() * t),
                (int) (startColor.getBlue() * u + endColor.getBlue() * t), 255);

        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }
}
