package com.tanyin.astar;

/**
 * Created by tanyin on 2017/11/25.
 */
public class Step {


    public static final int ROOT = -1;
    private int parentColumn;
    private int parentRow;
    private int column;
    private int row;
    private int H;//预估到目标的步数
    private int G;//已经移动的步数
    private int F;//期望总步数


    public void setParentColumn(int parentColumn) {
        this.parentColumn = parentColumn;
    }

    public void setParentRow(int parentRow) {
        this.parentRow = parentRow;
    }

    public Step(int parentColumn, int parentRow, int column, int row, int h, int g) {
        this.parentColumn = parentColumn;
        this.parentRow = parentRow;

        this.column = column;
        this.row = row;
        H = h;
        G = g;
    }

    public int getParentColumn() {
        return parentColumn;
    }

    public int getParentRow() {
        return parentRow;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
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
