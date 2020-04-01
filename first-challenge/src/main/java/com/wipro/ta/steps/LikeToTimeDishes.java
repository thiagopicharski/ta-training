package com.wipro.ta.steps;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LikeToTimeDishes {
    public class Solution {
        private int[] preparedDishes;
        private int preparedDishesSize = 0;
        private int coefficient = 0;

        public int[] getPreparedDishes() {
            return preparedDishes;
        }

        public int getCoefficient() {
            return coefficient;
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "preparedDishes=" + Arrays.toString(preparedDishes) +
                    ", preparedDishesSize=" + preparedDishesSize +
                    ", coefficient=" + coefficient +
                    '}';
        }
    }

    private Solution solution;

    public Solution calculateSolution(int[] dishes) {
        solution = new Solution();
        solution.preparedDishes = new int[dishes.length];
        solution.coefficient = iterate(0, 0, dishes, 0);

        return solution;
    }

    public Solution getSolution() {
        return solution;
    }

    private int iterate(int i, int iShift, int a[], int sum) {
        int curSumN = sum;
        int curSumP = sum + a[i] * (i + 1 + iShift);

        if (i + 1 < a.length) {
            if (a[i] < 0) {
                curSumN = iterate(i + 1, iShift - 1, a, curSumN);
            }

            curSumP = iterate(i + 1, iShift, a, curSumP);
        }
        solution.preparedDishesSize += curSumP > curSumN ? 1 : -1;
        solution.preparedDishes[i] = Integer.MIN_VALUE;
        if(curSumP > curSumN) {
            solution.preparedDishes[i + iShift] = a[i];
        }

        return curSumP > curSumN ? curSumP : curSumN;
    }
}