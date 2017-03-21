package com.seal_de.chapter4;

import org.junit.Test;

public class TestSqStack {
    @Test
    public void testPush(){
        SqStack<String> stack = new SqStack<>();
        stack.push(null);
        stack.push("bb");
        stack.push(null);
        System.out.println(stack);
    }

    @Test
    public void testPop(){
        int a,b;
        SqStack<Integer> stack = new SqStack<>();
        stack.push(10);
        stack.push(2);
        System.out.println(stack);
        a = stack.pop();
        b = stack.pop();
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("stack= " + stack);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopException(){
        SqStack<Integer> stack = new SqStack<>();
        System.out.println(stack.pop());
    }

}
