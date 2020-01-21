package com.puchs;

public class LinkedList {

    static class MyLinkedList {
        public int data;
        public MyLinkedList next;

        public MyLinkedList(int data) {
            this.data = data;
            this.next = null;
        }

        public MyLinkedList() {
            this.next = null;
        }

        public static void traverse (MyLinkedList head) {
            System.out.print("List : \t\t");
            while (head != null) {
                System.out.print(head.data + (head.next != null ? " --> " : "\n\n"));
                head = head.next;
            }
        }

        public static MyLinkedList reverseLL(MyLinkedList head) {
            if(head == null || head.next == null) {
                return head;
            }
            MyLinkedList prev = null;
            MyLinkedList curr = head;
            MyLinkedList temp = null;
            while(curr.next != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            curr.next = prev;
            return curr;
        }

        public static MyLinkedList insertFront(MyLinkedList head, MyLinkedList node) {
            if(head == null || head.next == null) {
                head = node;
                return head;
            }
            node.next = head;
            head = node;
            return head;
        }

        public static MyLinkedList insertLast(MyLinkedList head, MyLinkedList node) {
            if(head == null || head.next == null) {
                head = node;
                return head;
            }

            MyLinkedList curr = head;
            while (curr.next != null)
                curr = curr.next;

            curr.next = node;
            return head;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.data = 10;
        ll.next = new MyLinkedList();

        ll.next.data = 20;
        ll.next.next = new MyLinkedList();

        ll.next.next.data = 30;
        ll.next.next.next = new MyLinkedList();

        ll.next.next.next.data = 40;
        ll.next.next.next.next = null;

        MyLinkedList.traverse(ll);
        ll = MyLinkedList.reverseLL(ll);
        System.out.println("After reverseLL() : ");
        MyLinkedList.traverse(ll);

        System.out.println("After insertFront(ll, node) (5): ");
        MyLinkedList node = new MyLinkedList();
        node.data = 5;

        ll= MyLinkedList.insertFront(ll, node);
        MyLinkedList.traverse(ll);

        ll = MyLinkedList.insertLast(ll, createNode(50));
        System.out.println("After reverseLL() : ");
        MyLinkedList.traverse(ll);
    }

    private static MyLinkedList createNode(int data) {
        return new MyLinkedList(data);
    }


}
