package com.seal_de.chapter4;

import org.junit.Test;

public class JudgeStackOrder {

    public boolean judge(String str){
        char maxFlag = '1';
        SqStack<Character> stack = new SqStack<>(9+26);
        char[] chars = str.toCharArray();
        stack.push('1');
        for (char c : chars){
            checkChar(c);
            if(c > maxFlag){
                for(char i = ++maxFlag; i <= c; i++){
                    if(i > '9' && i < 'a')
                        i = 'a';
                    stack.push(i);
                }
                maxFlag = c;
            }
            char temp = stack.pop();
            if(temp != c)
                throw new IllegalArgumentException("错误字符：" + c);
        }
        return true;
    }

    private void checkChar(char c){
        if(!(c >= '1' && c <= '9') && !(c >= 'a' && c <= 'z'))
            throw new IllegalArgumentException("非法字符：" + c);
    }

    @Test
    public void testJudge(){
        String s = "ahwtvxn";
        System.out.println(judge(s));
    }

}
