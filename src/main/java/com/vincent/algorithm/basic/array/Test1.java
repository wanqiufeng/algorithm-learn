package com.vincent.algorithm.basic.array;

import java.util.ArrayList;

/**
 * Created by chenjun on 19-6-1.
 */
public class Test1 {
    public static void main(String args[]) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        test1(arrayList);
        for(Object o:arrayList) {
            System.out.println(o);
        }
    }


    private static void test1(ArrayList arrayList) {
        arrayList = new ArrayList();
        arrayList.add(3);
    }
}
