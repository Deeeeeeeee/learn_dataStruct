package com.seal_de.chapter3;

import org.junit.Test;

public class TestLinkList {
    @Test
    public void testAdd(){
        LinkList<String> list = new LinkList<>();
        list.add("aa");
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void testGetElem(){
        LinkList<String> list = new LinkList<>();
        list.add(null);
        System.out.println(list.getElem(0));
    }

    @Test
    public void testInsert(){
        LinkList<String> list = new LinkList<>();
        list.add(null).add("bb");
        list.insert(1, "aa");
        System.out.println(list);
    }

    @Test
    public void testDelete(){
        LinkList<String> list = new LinkList<>();
        list.add(null).add("aa");
        System.out.println(list.delete(0));
        System.out.println(list);
    }

    @Test
    public void testExceptionDelete(){
        LinkList<String> list = new LinkList<>();
        list.delete(0);
    }

}
