package org.borsoi.game.lib.business.utils;

import org.borsoi.game.lib.object.object.map.GameMap;
import org.borsoi.game.lib.object.object.map.tile.CityCase;
import org.borsoi.game.lib.object.object.map.tile.EmptyTile;

public class MapUtility
{

    /**
     * @return
     */
    public static GameMap generateMap()
    {
        float[][] perlinNoisGenerate =
            PerlinNoiseUtility.GeneratePerlinNoise(PerlinNoiseUtility.GenerateWhiteNoise(50, 50), 5);

        GameMap gameMap = new GameMap();

        for (int i = 0; i < 50; i++)
        {
            for (int j = 0; j < 50; j++)
            {
                gameMap.putTitle(i, j, perlinNoisGenerate[i][j], new EmptyTile());
            }
        }

        CityCase cityCase = new CityCase();
        cityCase.setPrincipal(true);
        gameMap.putTitle(25, 25, cityCase);

        return gameMap;
    }

}
