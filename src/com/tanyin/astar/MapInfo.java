package com.tanyin.astar;

/**
 * Created by tanyin on 2017/11/25.
 */
public class MapInfo {
    public static int MAP_Y = 1;
    public static int MAP_N = 2;

    public final static int ROW = 10;//行
    public final static int COLUMN = 10;//列


    public final static int[][] map = new int[][]{
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_N, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_N, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y,

                    MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
    };

    public boolean isPositionValid(int x, int y) {
        if ((x < 0) || (x >= COLUMN)) return false;
        if ((y < 0) || (y >= ROW)) return false;
        if (map[y][x] == MAP_N) return false;
        return true;
    }
}
