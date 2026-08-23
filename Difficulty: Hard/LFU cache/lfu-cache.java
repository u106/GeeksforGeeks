import java.util.HashMap;
import java.util.Map;

class LFUCache {
    // Node representing each key-value pair and its frequency
    private static class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // Doubly Linked List for nodes with the same frequency
    private static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                return lruNode;
            }
            return null;
        }
    }

    private final int capacity;
    private int curSize;
    private int minFreq;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int cap) {
        this.capacity = cap;
        this.curSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            curSize++;
            if (curSize > capacity) {
                // Evict LFU (and LRU in tie) node
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node deletedNode = minFreqList.removeTail();
                cache.remove(deletedNode.key);
                curSize--;
            }

            // Insert new node with frequency 1
            minFreq = 1;
            Node newNode = new Node(key, value);
            DoublyLinkedList curList = freqMap.getOrDefault(1, new DoublyLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(Node node) {
        int curFreq = node.freq;
        DoublyLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(node);

        // If the current list is empty and it was the minFreq, increment minFreq
        if (curFreq == minFreq && curList.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }
}