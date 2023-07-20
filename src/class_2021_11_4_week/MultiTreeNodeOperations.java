package class_2021_11_4_week;

import java.util.ArrayList;
import java.util.List;

public class MultiTreeNodeOperations {

    static class Node {
        int value;
        List<Node> childNodeList;
        boolean color;//黑色保留 白色去除

        public Node(int value, boolean color) {
            this.value = value;
            this.childNodeList = new ArrayList<>();
            this.color = color;
        }
    }

    public static Node operate(Node head) {

        if (head.childNodeList.isEmpty()) {
            return head.color ? head : null;
        }
        List<Node> newList = new ArrayList<>();
        for (Node node : head.childNodeList) {

            Node newNode = operate(node);
            if (newNode != null && newNode.color) {
                newList.add(newNode);
            }
        }
        head.childNodeList = newList;
        return head;
    }


    public static void preOrderPrint(Node head) {
        System.out.println(head.value);
        for (Node next : head.childNodeList) {
            preOrderPrint(next);
        }


    }

    public static void main(String[] args) {

        Node n1 = new Node(1, false);
        Node n2 = new Node(2, true);
        Node n3 = new Node(3, false);
        Node n4 = new Node(4, false);
        Node n5 = new Node(5, false);
        Node n6 = new Node(6, true);
        Node n7 = new Node(7, true);
        Node n8 = new Node(8, false);
        Node n9 = new Node(9, false);
        Node n10 = new Node(10, false);
        Node n11 = new Node(11, false);
        Node n12 = new Node(12, false);
        Node n13 = new Node(13, true);

        n1.childNodeList.add(n2);
        n1.childNodeList.add(n3);
        n2.childNodeList.add(n4);
        n2.childNodeList.add(n5);
        n3.childNodeList.add(n6);
        n3.childNodeList.add(n7);
        n6.childNodeList.add(n8);
        n6.childNodeList.add(n9);
        n6.childNodeList.add(n10);
        n7.childNodeList.add(n11);
        n7.childNodeList.add(n12);
        n9.childNodeList.add(n13);
        Node newHead = operate(n1);
        preOrderPrint(newHead);

    }

}
