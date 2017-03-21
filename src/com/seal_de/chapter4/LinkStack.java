package com.seal_de.chapter4;

public class LinkStack<E> {
    private Node<E> top;
    private Node<E> firstNode;
    private int count=0;

    public LinkStack(){}

    public int push(E element){
        if(this.firstNode == null){
            this.firstNode = new Node(element);
            this.top = this.firstNode;
            return ++count;
        }
        Node newNode = new Node(element, top);
        top.next = newNode;
        top = top.next;
        return ++count;
    }

    public E pop(){
        if(this.firstNode == null)
            throw new IndexOutOfBoundsException("栈已经没有元素，不能执行出栈操作");
        if(this.firstNode == this.top){
            E element = firstNode.data;
            firstNode = null;
            top = null;
            this.count--;
            return element;
        }
        Node<E> tempNode = top;
        E element = tempNode.data;
        top = tempNode.pre;
        top.next = null;
        this.count--;
        return element;
    }

    class Node<E> {
        private E data;
        private Node next;
        private Node pre;

        public Node(E element){this.data = element;}

        public Node(E element, Node preNode) {
            this.data = element;
            this.pre = preNode;
        }
    }

    @Override
    public String toString(){
        Node node = this.firstNode;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(node != null){
            sb.append(node.data).append(",");
            node = node.next;
        }
        if(sb.length() != 1)
            sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

}
