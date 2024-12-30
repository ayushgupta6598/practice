package org.example.java8;

import java.util.Objects;

public class CustomMap<K, V> { // Renamed from CustomHashMap to CustomMap

    static class Node<K, V> {
        final K key; // Changed from private to final for direct access within CustomMap.
        V value; 
        final int hash; // Changed from private to final for direct access within CustomMap.
        Node<K, V> next; // Pointer to the next node in case of collision.

        Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    private Node<K, V>[] buckets;
    private static int capacity = 16;
    private int size = 0;
    private float loadfactor = 0.75F;

    public CustomMap() { // Updated constructor for CustomMap
        buckets = new Node[capacity];
    }

    public void put(K key, V value) {
//        if (key == null) { // Added null key handling explicitly.
//            buckets[0] = new Node<>(null, value, 0, buckets[0]); // Store null key in the first bucket.
//            size++;
//            if (size > loadfactor * capacity) {
//                resize(); // Trigger resize if size exceeds threshold.
//            }
//            return;
//        }
        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);
        Node<K, V> bucket = buckets[bucketIndex];
        while (bucket != null) {
            if (bucket.hash == hash && Objects.equals(bucket.key, key)) { // Changed to Objects.equals to ensure proper key comparison.
                bucket.value = value; // Update the value if key exists.
                return;
            }
            bucket = bucket.next; // Traverse the linked list in case of collision.
        }
        Node<K, V> node = new Node<>(key, value, hash, buckets[bucketIndex]); // Add new node to the head of the list.
        buckets[bucketIndex] = node;
        size++;
        if (size > loadfactor * capacity) {
            resize(); // Resize the array if load factor exceeds the threshold.
        }
    }

    private void resize() {
        capacity *= 2; // Double the capacity.
        Node<K, V>[] oldBuckets = buckets; // Save the old bucket array.
        buckets = new Node[capacity]; // Create a new, larger bucket array.
        size = 0; // Reset size and rehash entries to recalculate size properly.
        for (Node<K, V> node : oldBuckets) {
            while (node != null) {
                put(node.key, node.value); // Use put method to rehash and add nodes to the new buckets.
                node = node.next;
            }
        }
    }

    private static int getBucketIndex(int hash) {
        return hash & (capacity - 1); // Fixed precedence by adding parentheses around capacity - 1.
    }

    private static <K> int getHash(K key) {
        return Objects.hashCode(key); // Ensures a consistent hash code for null and non-null keys.
    }

    public V get(K key) {
        if (key == null) { // Explicit handling of null key.
            Node<K, V> bucket = buckets[0]; // Check the special bucket for null keys.
            while (bucket != null) {
                if (bucket.key == null) {
                    return bucket.value;
                }
                bucket = bucket.next;
            }
            return null;
        }
        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);
        Node<K, V> bucket = buckets[bucketIndex];
        while (bucket != null) {
            if (bucket.hash == hash && Objects.equals(bucket.key, key)) { // Fixed key comparison using Objects.equals.
                return bucket.value;
            }
            bucket = bucket.next; // Traverse the linked list in case of collision.
        }
        return null; // Return null if key not found.
    }

    public V remove(K key) {
        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);
        Node<K, V> bucket = buckets[bucketIndex];
        Node<K, V> previous = null; // Added previous pointer to properly unlink nodes.
        while (bucket != null) {
            if (bucket.hash == hash && Objects.equals(bucket.key, key)) { // Fixed key comparison using Objects.equals.
                V value = bucket.value;
                if (previous == null) {
                    buckets[bucketIndex] = bucket.next; // Remove head node if it's the match.
                } else {
                    previous.next = bucket.next; // Unlink the matched node from the linked list.
                }
                size--;
                return value;
            }
            previous = bucket; // Keep track of the previous node.
            bucket = bucket.next; // Traverse the linked list.
        }
        return null; // Return null if key not found.
    }

    public int size() {
        return size; // Return the current size of the map.
    }

    public static void main(String[] args) {
        CustomMap<Integer, Integer> map = new CustomMap<>(); // Updated to CustomMap
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1)); // Output: 1
        System.out.println(map.remove(2)); // Output: 2
        System.out.println(map.get(2)); // Output: null
        System.out.println(map.size()); // Output: 1
    }
}
