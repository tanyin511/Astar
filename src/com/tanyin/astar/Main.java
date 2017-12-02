package com.tanyin.astar;

import java.util.ArrayList;

/**
 * Created by tanyin on 2017/2/3.
 */
public class Main {

    final static int SRC_COLUMN = 2;
    final static int SRC_ROW = 3;
    final static int DEST_COLUMN = 5;
    final static int DEST_ROW = 4;

    public static void main(String[] args) {
        System.out.println("hello test is run~~");

        Astar mAstar = new Astar(new MapInfo());

        ArrayList<Step> mSteps = mAstar.findTheWay(SRC_COLUMN, SRC_ROW, DEST_COLUMN, DEST_ROW);
        System.out.println("return~~");
        showTheWay(mSteps);
    }

    private static void showTheWay(ArrayList<Step> mSteps) {
        int[][] map = new int[MapInfo.ROW_SIZE][MapInfo.COLUMN_SIZE];

        for (int i = 0; i < MapInfo.ROW_SIZE; i++) {
            for (int j = 0; j < MapInfo.COLUMN_SIZE; j++) {
                map[i][j] = MapInfo.map[i][j];
            }
        }

        for (Step s : mSteps) {
            map[s.getRow()][s.getColumn()] = 0;
        }
        map[SRC_ROW][SRC_COLUMN] = 8;
        map[DEST_ROW][DEST_COLUMN] = 9;


        for (int i = 0; i < MapInfo.ROW_SIZE; i++) {
            String s = "";
            for (int j = 0; j < MapInfo.COLUMN_SIZE; j++) {
                s += map[i][j] + " ";
            }
            System.out.println(s);
        }
    }
}
