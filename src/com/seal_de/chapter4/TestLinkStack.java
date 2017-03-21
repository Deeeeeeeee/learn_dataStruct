package com.seal_de.chapter4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestLinkStack {
    @Test
    public void testPush(){
        LinkStack<String> stack = new LinkStack<>();
        stack.push("aa");
        stack.push(null);
        Assert.assertEquals("[aa,null]", stack.toString());
    }

    @Test
    public void testPop() {
        LinkStack<Long> stack = new LinkStack<>();
        stack.push(12L);
        Assert.assertEquals(12L, stack.pop().longValue());
        stack.push(20L);
        stack.push(-1L);
        Assert.assertEquals("[20,-1]", stack.toString());
        stack.pop();
        Assert.assertEquals("[20]", stack.toString());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testPopException() throws IndexOutOfBoundsException {
        expectedEx.expect(IndexOutOfBoundsException.class);
        expectedEx.expectMessage("栈已经没有元素");
        LinkStack<String> stack = new LinkStack<>();
        stack.push("a");
        stack.pop();
        stack.pop();
    }
}
