package org.borsoi.game.lib.object.object.map;

import java.util.HashMap;
import java.util.Map;

import org.borsoi.game.lib.object.object.map.tile.Case;
import org.borsoi.game.lib.object.object.map.tile.CityCase;

public class GameMap
{

    private Map<Integer, Map<Integer, Tile>> map;

    public GameMap()
    {
        map = new HashMap<Integer, Map<Integer, Tile>>();
    }

    public Tile getTitle(int x, int y)
    {

        if (map.containsKey(x))
        {
            if (map.get(x).containsKey(y))
            {
                return map.get(x).get(y);
            }
        }
        return null;
    }

    /**
     * @param pI
     * @param pI2
     * @param pCityCase
     */
    public void putTitle(int x, int y, CityCase pValue)
    {
        putTitle(x, y, map.get(x).get(y).getType(), pValue);
    }

    public void putTitle(int x, int y, float type, Case pValue)
    {
        Tile tile = new Tile(x, y, type);
        tile.setValue(pValue);

        if (map.containsKey(x))
        {
            map.get(x).put(y, tile);
        }
        else
        {
            map.put(x, new HashMap<Integer, Tile>());
            map.get(x).put(y, tile);
        }

    }

    /**
     * Return map
     * @return map
     */
    public Map<Integer, Map<Integer, Tile>> getMap()
    {
        return map;
    }

    /**
     * Set map
     * @param pMap map
     */
    public void setMap(Map<Integer, Map<Integer, Tile>> pMap)
    {
        map = pMap;
    }

}