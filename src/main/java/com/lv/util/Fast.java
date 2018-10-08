package com.lv.util;

import java.util.Arrays;

/**
 * Created by simperLv
 * on 2018/09/06 17:29
 *
 * @Description //快速排序
 */
public class Fast {
    public static void main(String[] args) {
        int[] a = {1, 2, 6, 1, 14, 5, 3, 3, 6, 4, 24, 23, 5, 43, 45, 31, 4, 2};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

}
