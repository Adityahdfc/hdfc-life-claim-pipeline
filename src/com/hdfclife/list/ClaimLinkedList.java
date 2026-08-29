package com.hdfclife.list;

public class ClaimLinkedList {


    ClaimNode head;
    int size = 0;

    public ClaimLinkedList() {
        head = new ClaimNode();
    }

    public void addLast(int amount) {
        ClaimNode newNode = new ClaimNode(amount);

        if (head.next == null) {
            head.next = newNode;
        } else {
            ClaimNode ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
            ptr = null;
        }
        size++;
    }

    public void addFirst(int amount) {
        ClaimNode newNode = new ClaimNode(amount);

        if (head.next == null) {
            head.next = newNode;
        } else {
            ClaimNode ptr = head.next;
            head.next = newNode;
            newNode.next = ptr;
            ptr = null;
            newNode = null;
        }

        size++;
    }

    public void insertAt(int index, int amount) {
        ClaimNode newNode = new ClaimNode(amount);
        ClaimNode ptr = head;

        while (index-- > 0 && ptr != null) {
            ptr = ptr.next;
        }


        //        if(index != 0) throw new InvalidIndexException();

        ClaimNode temp = ptr.next;
        ptr.next = newNode;
        newNode.next = temp;
        ptr = null;
        newNode = null;

        size++;
    }

    public void deleteAt(int index) {
        //if(size == 0)throw new EmptyListException();
        ClaimNode ptr = head;
        while (index-- > 0 && ptr != null) {
            ptr = ptr.next;
        }

//        if(index != 0) throw new InvalidIndexException();

        ptr.next = ptr.next.next;

        size--;
    }

    public ClaimNode nodeAt(int index) {
        ClaimNode ptr = head;
        while (index-- >= 0 && ptr != null) {
            ptr = ptr.next;
        }
        return ptr;
    }

    public int[] toArray() {
        int[] arr = new int[size];

        ClaimNode ptr = head.next;
        int i = 0;
        while (ptr != null) {
            arr[i++] = ptr.amount;
            ptr = ptr.next;
        }

        return arr;
    }

    public int size() {
        return size;
    }


//    static void main() {
//        ClaimLinkedList cll = new ClaimLinkedList();
//
//        cll.addLast(25000);
//        cll.addLast(18000);
//        cll.addLast(42000);
//        cll.addLast(15000);
//        cll.addLast(31000);
//        cll.addLast(9000);
//
//        Arrays.stream(cll.toArray()).forEach(System.out::println);
//
//        cll.insertAt(2, 22000);
//
//        System.out.println();
//        Arrays.stream(cll.toArray()).forEach(System.out::println);
//
//        cll.deleteAt(2);
//
//        System.out.println();
//        Arrays.stream(cll.toArray()).forEach(System.out::println);
//
//    }
}
