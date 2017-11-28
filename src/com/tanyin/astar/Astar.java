package com.tanyin.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tanyin on 2017/11/25.
 */
public class Astar {

    private final MapInfo map;


    ArrayList<Step> openList = new ArrayList<>();
    ArrayList<Step> closeList = new ArrayList<>();
    private int destX;
    private int destY;
    private Step finalStep;

    public Astar(MapInfo map) {
        this.map = map;
    }

    public ArrayList<Step> findTheWay(int srcX, int srcY, int destX, int destY) {

        this.destX = destX;
        this.destY = destY;

        openList.add(new Step(Step.ROOT, Step.ROOT, srcX, srcY, getH(srcX, srcY, destX, destY), 0));
        while (openList.size() > 0) {
            sortOpenList();
            Step s = openList.get(0);


            if (handlePosition(s, s.getX() - 1, s.getY())) return getSteps();
            if (handlePosition(s, s.getX() + 1, s.getY())) return getSteps();
            if (handlePosition(s, s.getX(), s.getY() - 1)) return getSteps();
            if (handlePosition(s, s.getX(), s.getY() + 1)) return getSteps();

            openList.remove(s);
            closeList.add(s);
        }
        return null;
    }

    private ArrayList<Step> getSteps() {
        ArrayList<Step> mSteps = new ArrayList<>();

        mSteps.add(finalStep);
        while (true) {
            if (mSteps.get(0).getParentX() == Step.ROOT) break;
            for (Step s : closeList) {
                if ((s.getX() == mSteps.get(0).getParentX()) && (s.getY() == mSteps.get(0).getParentY())) {
                    mSteps.add(0, s);
                }
            }
            for (Step s : openList) {
                if ((s.getX() == mSteps.get(0).getParentX()) && (s.getY() == mSteps.get(0).getParentY())) {
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

    private boolean handlePosition(Step s, int x, int y) {
        if ((x == destX) && (y == destY)) {
            finalStep = new Step(s.getX(), s.getY(), x, y, getH(x, y, destX, destY), s.getG() + 1);
            return true;
        }

        if (!map.isPositionValid(x, y)) return false;

        if (isPositionInList(x, y, closeList)) return false;
        if (isPositionInList(x, y, openList)) {
            updatePositionInOpenList(x, y, s);
            return false;
        }

        openList.add(new Step(s.getX(), s.getY(), x, y, getH(x, y, destX, destY), s.getG() + 1));
        return false;
    }

    private void updatePositionInOpenList(int x, int y, Step currentStep) {
        for (Step s : openList) {
            if ((s.getX() == x) && (s.getY() == y)) {
                if (s.getG() > currentStep.getG() + 1) {
                    s.setG(currentStep.getG() + 1);
                    s.setParentX(currentStep.getParentX());
                    s.setParentY(currentStep.getParentY());
                    return;
                }
            }
        }
    }

    private boolean isPositionInList(int x, int y, ArrayList<Step> closeList) {
        for (Step s : closeList) {
            if ((s.getX() == x) && (s.getY() == y)) return true;
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

    private int getH(int srcX, int srcY, int destX, int destY) {
        return Math.abs(srcX - destX) + Math.abs(srcY - destY);
    }

}
