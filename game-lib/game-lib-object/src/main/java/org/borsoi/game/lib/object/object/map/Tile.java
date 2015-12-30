package org.borsoi.game.lib.object.object.map;

import java.util.List;

import org.borsoi.game.lib.object.object.Humanoide;
import org.borsoi.game.lib.object.object.map.tile.Case;

public class Tile
{

    public Tile(int x, int y, float type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    private int x;

    private int y;

    private float type;

    private Case value;

    private List<Humanoide> humanoideList;

    /**
     * Return x
     * @return x
     */
    public int getX()
    {
        return x;
    }

    /**
     * Return y
     * @return y
     */
    public int getY()
    {
        return y;
    }

    /**
     * Return value
     * @return value
     */
    public Case getValue()
    {
        return value;
    }

    /**
     * Set value
     * @param pValue value
     */
    public void setValue(Case pValue)
    {
        value = pValue;
    }

    /**
     * Return type
     * @return type
     */
    public float getType()
    {
        return type;
    }

    /**
     * Return humanoideList
     * @return humanoideList
     */
    public List<Humanoide> getHumanoideList()
    {
        return humanoideList;
    }

    /**
     * Set humanoideList
     * @param pHumanoideList humanoideList
     */
    public void setHumanoideList(List<Humanoide> pHumanoideList)
    {
        humanoideList = pHumanoideList;
    }

}
