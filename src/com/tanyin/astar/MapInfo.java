package com.tanyin.astar;

/**
 * Created by tanyin on 2017/11/25.
 */
public class MapInfo {
    public static int MAP_Y = 1;
    public static int MAP_N = 2;

    public final static int ROW_SIZE = 10;//行
    public final static int COLUMN_SIZE = 10;//列


    public final static int[][] map = new int[][]{
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_N, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_N, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_N, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
            {MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y, MAP_Y},
    };

    public boolean isPositionValid(int column, int row) {
        if ((column < 0) || (column >= COLUMN_SIZE)) return false;
        if ((row < 0) || (row >= ROW_SIZE)) return false;
        if (map[row][column] == MAP_N) return false;
        return true;
    }
}
