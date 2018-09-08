package com.lv.util;

import java.util.Arrays;

/**
 * Created by simperLv
 * on 2018/09/06 22:48
 *
 * @Description //TODO
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] a = {1,2,6,1,14,5,3,3,6,4,24,23,5,43,45,31,4,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a){
        int tmp = 0;
        for (int i = 0; i < a.length;i++){
            for (int j = i + 1; j < a.length;j++){
                if (a[i] > a[j]){
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
