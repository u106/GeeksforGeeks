import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int capacity;
    private static Map<Integer, Node> cache;
    private static Node head;
    private static Node tail;

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        capacity = cap;
        cache = new HashMap<>();

        // Dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insertToHead(node); // Move to most recently used position
        return node.value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value = value;
            remove(existingNode);
            insertToHead(existingNode);
        } else {
            if (cache.size() == capacity) {
                // Evict LRU node (node before dummy tail)
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
        }
    }

    // Helper method to remove a node from the doubly linked list
    private static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right after the dummy head
    private static void insertToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}