package com.seal_de.chapter3;

import java.util.ArrayList;
import java.util.List;

public class SqList<T> {

    private static int MAXSIZE = 20;
    private T[] data;
    private int length = 0;

    public SqList(){
        this.data = (T[])new Object[MAXSIZE];
    }

    public T getElem(int i){
        if(this.length == 0 || i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        }
        return data[i];
    }

    public boolean add(T e) {
        if(this.length == MAXSIZE)
            throw new IndexOutOfBoundsException("数组已经达到最大存储空间");
        this.data[this.length++] = e;
        return true;
    }

    public boolean insert(int i, T e) {
        int k;
        if (this.length == MAXSIZE)
            throw new IndexOutOfBoundsException("数组已经达到最大存储空间");
        if (i < 0 || i > this.length)
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        if (i < this.length) {
            for (k = this.length; k >= i; k--)
                this.data[k] = this.data[k-1];
        }
        this.data[i] = e;
        this.length ++;
        return true;
    }

    public T delete(int i){
        int k;
        T temp = null;
        if(this.length == 0)
            throw new IndexOutOfBoundsException("数组长度为0，不能进行删除操作");
        if(i < 0 || i > this.length-1)
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        if(i < this.length) {
            temp = this.data[i];
            for (k = i; k < this.length; k++)
                this.data[k] = this.data[k+1];
        }
        this.length --;
        return temp;
    }

    private String outOfBoundMsg(int index){
        return "下标越界。下标: " + index +", 当前数组大小： " + this.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < this.length-1; i++)
            sb.append(this.data[i]).append(", ");
        if(this.length != 0)
            sb.append(this.data[this.length-1]);
        sb.append(']');
        return sb.toString();
    }

}
