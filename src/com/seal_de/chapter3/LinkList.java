package com.seal_de.chapter3;

public class LinkList<E> {
    private Node firstNode;
    private int length=0;

    public LinkList(){}

    public LinkList<E> add(E element){
        if (this.firstNode == null) {
            Node newNode = new Node(element);
            this.firstNode = newNode;
            length++;
            return this;
        }
        Node node = this.firstNode;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(element);//下一个节点为空时，执行这一句
        length++;
        return this;
    }

    public E getElem(int i){
        int j = 0;
        Node<E> node = this.firstNode;
        if(node == null)
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        while (node != null && j < i) {
            node = node.next;
            j++;
        }
        if(node == null || j > i){
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        }
        return node.data;
    }

    public boolean insert(int i, E element) {
        if(i == 0) {
            insertFirst(element);
            return true;
        }
        int j = 1;
        Node node = this.firstNode;
        while (node != null && j < i){
            node = node.next;
            j++;
        }
        if (node == null || j > i)
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        Node<E> newNode = new Node<>(element);
        newNode.next = node.next;
        node.next = newNode;
        this.length++;
        return true;
    }

    public E delete(int i) {
        if(i == 0 && this.firstNode != null){
            return deleteFirst();
        }
        int j = 1;
        Node node = this.firstNode;
        while(node != null && j < i){
            node = node.next;
            j++;
        }
        if(node == null || node.next == null)
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        Node<E> deNode = node.next;
        E element = deNode.data;
        node = deNode.next;
        deNode.next = null;
        deNode.data = null;
        this.length--;
        return element;
    }

    private boolean insertFirst(E e) {
        Node<E> newNode = new Node<E>(e, this.firstNode);
        this.firstNode = newNode;
        this.length++;
        return true;
    }

    private E deleteFirst(){
        Node<E> deNode =  this.firstNode;
        E element = deNode.data;
        this.firstNode = deNode.next;
        deNode.next = null;
        deNode.data = null;
        this.length--;
        return element;
    }

    class Node<E> {
        private E data;
        private Node next;

        public Node(E element){this.data = element;}

        public Node(E element, Node nextNode) {
            this.data = element;
            this.next = nextNode;
        }
    }

    private  String outOfBoundMsg(int i){
        return "下标： " + i + "，链表长度： " + this.length;
    }

    public String toString(){
        Node node = this.firstNode;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.data).append(",");
            node = node.next;
        }
        if(sb.length() != 1)
            sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

}
