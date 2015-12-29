package org.borsoi.game.lib.business.utils;

import org.borsoi.game.lib.object.object.map.GameMap;

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
                gameMap.putTitle(i, j, perlinNoisGenerate[i][j], null);
            }
        }
        return gameMap;
    }

}
