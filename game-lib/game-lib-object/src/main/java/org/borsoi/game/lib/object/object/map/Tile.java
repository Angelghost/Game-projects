package org.borsoi.game.lib.object.object.map;

public class Tile
{

    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    private int x;

    private int y;

    private Object value;

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
    public Object getValue()
    {
        return value;
    }

    /**
     * Set value
     * @param pValue value
     */
    public void setValue(Object pValue)
    {
        value = pValue;
    }

}
