package org.borsoi.game.lib.object.object.map;

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

    /**
     * Return type
     * @return type
     */
    public float getType()
    {
        return type;
    }

}
