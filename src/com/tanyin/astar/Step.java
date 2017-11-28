package com.tanyin.astar;

/**
 * Created by tanyin on 2017/11/25.
 */
public class Step {


    public static final int ROOT = -1;
    private int parentX;
    private int parentY;
    private int x;
    private int y;
    private int H;//预估到目标的步数
    private int G;//已经移动的步数
    private int F;//期望总步数


    public void setParentX(int parentX) {
        this.parentX = parentX;
    }

    public void setParentY(int parentY) {
        this.parentY = parentY;
    }

    public Step(int parentX, int parentY, int x, int y, int h, int g) {
        this.parentX = parentX;
        this.parentY = parentY;

        this.x = x;
        this.y = y;
        H = h;
        G = g;
    }

    public int getParentX() {
        return parentX;
    }

    public int getParentY() {
        return parentY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return H;
    }

    public int getG() {
        return G;
    }

    public int getF() {
        return H + G;
    }

    public void setG(int g) {
        G = g;
    }
}
