/*
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes right next to original nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers to the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurr.next != null) {
                cloneCurr.next = cloneCurr.next.next;
            }
            original = original.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }
}