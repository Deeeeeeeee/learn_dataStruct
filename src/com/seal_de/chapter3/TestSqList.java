package com.seal_de.chapter3;

import org.junit.Test;

public class TestSqList {

    @Test
    public void test(){
        SqList<Integer> list = new SqList<>();
        list.add(4);
        list.add(30);
        list.insert(1, 6);
        System.out.println(list);

        int temp = list.delete(2);
        System.out.println(list + ", delete element: " + temp);

        System.out.println("获得下标为1的元素： " + list.getElem(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionInsert(){
        SqList<Integer> list = new SqList<>();
        list.add(4);
        list.add(30);
        list.insert(3, 20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionDelete(){
        SqList<Integer> list = new SqList<>();
        list.add(4);
        list.add(30);
        list.delete(-1);
    }

}
