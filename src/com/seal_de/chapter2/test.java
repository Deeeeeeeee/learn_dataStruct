package com.seal_de.chapter2;

import org.junit.Test;

public class test {
    @Test
    public void t(){
        int sum = 0,n =100;
        sum = (1 + n) * n / 2;
        System.out.println(sum);
    }

    @Test
    public void randomArray(){
        int deInt = 100;
        int tempInt;
        int count;
        int[] dest = new int[100];
        int[] temp = new int[100];
        for(; deInt > 0; deInt --){                 //从100循环到1
            int ranInt = (int)(deInt * Math.random());  //随机生成0到99之间的数
            for (tempInt = 0, count = 0; tempInt < 100; tempInt++) {   //
                if(count == ranInt){
                    dest[deInt-1] = tempInt + 1;
                    break;
                }
                if(temp[tempInt] == 0){
                    count++;
                }
            }
        }
        for(int i = 0; i < 100; i++)
            System.out.print(dest[i] + ", ");
    }
}
