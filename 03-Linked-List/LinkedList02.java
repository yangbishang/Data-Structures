//双向链表

public class LinkedList02<E> {

    //内部类
    private class Node{
        public E e;
        public Node next;
        public Node previous;

        public Node(E e, Node next,Node previous){
            this.e = e;
            this.next = next;
            this.previous = previous;
        }

        public Node(E e){
            this(e, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        //显示方法
        public void display() {
            System.out.print(e + " ");
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }


    //头结点
    private Node first;
    //尾结点
    private Node last;

    public LinkedList02() {
        first = null;
        last = null;
    }




    /**
     * 插入一个结点，在头结点后进行插入
     */
    public void insertFirst(E e) {
        Node node = new Node(e);
        if(isEmpty()) {
            last = node;
        } else {
            first.previous = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * 插入一个结点，从尾结点进行插入
     */
    public void insertLast(E e) {
        Node node = new Node(e);
        if(isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
    }

    /**
     * 删除一个结点，在头结点后进行删除
     */
    public Node deleteFirst() {
        Node tmp = first;
        if(first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = tmp.next;
        return tmp;
    }

    /**
     * 删除结点，从尾部进行删除
     */
    public Node deleteLast() {
        Node tmp = last;
        if(first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return last;
    }

    /**
     * 显示方法
     */
    public void display() {
        Node current = first;
        while(current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 查找方法
     */
    public Node find(E e) {
        Node current = first;
        while(current.e != e) {
            if(current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除方法，根据数据域来进行删除
     */
    public Node delete(E e) {
        Node current = first;
        while(current.e != e) {
            if(current.next == null) {
                return null;
            }
            current = current.next;
        }

        if(current == first) {
            first = first.next;
        } else {
            current.previous.next = current.next;
        }
        return current;

    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return (first == null);
    }
}
