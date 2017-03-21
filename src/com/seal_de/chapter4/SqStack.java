package com.seal_de.chapter4;

public class SqStack<E> {
    private static int MAXSIZE = 20;
    private int top = -1;
    private E data[];

    public SqStack(){
        this.data = (E[])new Object[MAXSIZE];
    }

    public SqStack(int maxsize) {
        this.MAXSIZE = maxsize;
        this.data = (E[]) new Object[maxsize];
    }

    public boolean push(E element){
        if(this.top == MAXSIZE-1)
            throw new IndexOutOfBoundsException("栈已经达到最大存储空间："+MAXSIZE);
        this.data[++this.top] = element;
        return true;
    }

    public E pop(){
        if(this.top == -1)
            throw new IndexOutOfBoundsException("栈为空，不能再进行出栈操作");
        E topElement = this.data[this.top];
        this.data[this.top] = null;
        top--;
        return topElement;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i=0; i < this.top; i++){
            sb.append(this.data[i]).append(",");
        }
        if(this.top != -1)
            sb.append(this.data[this.top]);
        sb.append(']');
        return sb.toString();
    }

}
