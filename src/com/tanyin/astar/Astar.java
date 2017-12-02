package com.tanyin.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tanyin on 2017/11/25.
 */
public class Astar {

    private final MapInfo map;


    ArrayList<Step> openList = new ArrayList<>();
    ArrayList<Step> closeList = new ArrayList<>();
    private int destColumn;
    private int destRow;
    private Step finalStep;

    public Astar(MapInfo map) {
        this.map = map;
    }

    public ArrayList<Step> findTheWay(int srcColumn, int srcRow, int destColumn, int destRow) {

        this.destColumn = destColumn;
        this.destRow = destRow;

        openList.add(new Step(Step.ROOT, Step.ROOT, srcColumn, srcRow, getH(srcColumn, srcRow, destColumn, srcRow), 0));
        while (openList.size() > 0) {
            sortOpenList();
            Step s = openList.get(0);


            if (handlePosition(s, s.getColumn() - 1, s.getRow())) return getSteps();
            if (handlePosition(s, s.getColumn() + 1, s.getRow())) return getSteps();
            if (handlePosition(s, s.getColumn(), s.getRow() - 1)) return getSteps();
            if (handlePosition(s, s.getColumn(), s.getRow() + 1)) return getSteps();

            openList.remove(s);
            closeList.add(s);
        }
        return null;
    }

    private ArrayList<Step> getSteps() {
        ArrayList<Step> mSteps = new ArrayList<>();

        mSteps.add(finalStep);
        while (true) {
            if (mSteps.get(0).getParentColumn() == Step.ROOT) break;
            for (Step s : closeList) {
                if ((s.getColumn() == mSteps.get(0).getParentColumn()) && (s.getRow() == mSteps.get(0).getParentRow())) {
                    mSteps.add(0, s);
                }
            }
            for (Step s : openList) {
                if ((s.getColumn() == mSteps.get(0).getParentColumn()) && (s.getRow() == mSteps.get(0).getParentRow())) {
                    mSteps.add(0, s);
                }
            }
        }
        Collections.sort(mSteps, new Comparator<Step>() {
            @Override
            public int compare(Step o1, Step o2) {
                return o1.getG() - o2.getG();
            }
        });
        return mSteps;
    }

    private boolean handlePosition(Step s, int column, int row) {
        if ((column == destColumn) && (row == destRow)) {
            finalStep = new Step(s.getColumn(), s.getRow(), column, row, getH(column, row, destColumn, destRow), s.getG() + 1);
            return true;
        }

        if (!map.isPositionValid(column, row)) return false;

        if (isPositionInList(column, row, closeList)) return false;
        if (isPositionInList(column, row, openList)) {
            updatePositionInOpenList(column, row, s);
            return false;
        }

        openList.add(new Step(s.getColumn(), s.getRow(), column, row, getH(column, row, destColumn, destRow), s.getG() + 1));
        return false;
    }

    private void updatePositionInOpenList(int column, int row, Step currentStep) {
        for (Step s : openList) {
            if ((s.getColumn() == column) && (s.getRow() == row)) {
                if (s.getG() > currentStep.getG() + 1) {
                    s.setG(currentStep.getG() + 1);
                    s.setParentColumn(currentStep.getParentColumn());
                    s.setParentRow(currentStep.getParentRow());
                    return;
                }
            }
        }
    }

    private boolean isPositionInList(int column, int row, ArrayList<Step> closeList) {
        for (Step s : closeList) {
            if ((s.getColumn() == column) && (s.getRow() == row)) return true;
        }
        return false;
    }

    private void sortOpenList() {
        Collections.sort(openList, new Comparator<Step>() {
            @Override
            public int compare(Step o1, Step o2) {
                return o1.getF() - o2.getF();
            }
        });
    }

    private int getH(int srcColumn, int srcRow, int destColumn, int destRow) {
        return Math.abs(srcColumn - destColumn) + Math.abs(srcRow - destRow);
    }

}
