package com.tanyin.astar;

import java.util.ArrayList;

/**
 * Created by tanyin on 2017/2/3.
 */
public class Main {

    final static int SX = 2;
    final static int SY = 3;
    final static int DX = 5;
    final static int DY = 4;

    public static void main(String[] args) {
        System.out.println("hello test is run~~");

        Astar mAstar = new Astar(new MapInfo());

        ArrayList<Step> mSteps = mAstar.findTheWay(SX, SY, DX, DY);
        System.out.println("return~~");
        showTheWay(mSteps);
    }

    private static void showTheWay(ArrayList<Step> mSteps) {
        int[][] map = new int[MapInfo.ROW][MapInfo.COLUMN];

        for (int i = 0; i < MapInfo.ROW; i++) {
            for (int j = 0; j < MapInfo.COLUMN; j++) {
                map[i][j] = MapInfo.map[i][j];
            }
        }

        for (Step s : mSteps) {
            map[s.getY()][s.getX()] = 0;
        }
        map[SY][SX] = 8;
        map[DY][DX] = 9;


        for (int i = 0; i < MapInfo.ROW; i++) {
            String s = "";
            for (int j = 0; j < MapInfo.COLUMN; j++) {
                s += map[i][j] + " ";
            }
            System.out.println(s);
        }
    }
}
