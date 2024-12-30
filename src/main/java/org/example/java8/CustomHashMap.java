package org.example.java8;

import java.util.Objects;

// Custom implementation of HashMap
public class CustomHashMap<K, V> {

    static class Node<K,V>{
        private K key;
        V value;
        private int hash;
        Node<K, V> next;

        Node(K key,V value, int hash, Node<K,V > next) {
            this.key = key;
            this.value= value;
            this.hash = hash;
            this.next= next;
        }
    }

    private Node<K,V> buckets[];
    private static int capacity=16;
    private int size=0;
    private float loadfactor=0.75F;



    public CustomHashMap(){
        buckets= new Node[capacity];
    }

    public void put(K key, V value){
        int hash = getHash(key);
        int bucketIndex= getBucketIndex(hash);
        Node<K,V> bucket= buckets[bucketIndex];
        while (bucket!=null){
            if(bucket.hash==hash && bucket.key== key){
                bucket.value=value;
                return;
            }
            bucket=bucket.next;
        }
        Node<K,V> node =new Node<>(key, value,hash, buckets[bucketIndex]);
        buckets[bucketIndex]= node;
        size++;
        if(size>loadfactor*capacity){
            resize();
        }
    }

    private void resize() {
        capacity*=2;
        Node[] newBuckets= new Node[capacity];
        for (Node<K, V> node : buckets) { // Iterate through the existing buckets
            while (node != null) { // Process each node in the linked list of the current bucket
                Node<K, V> next = node.next; // Save the reference to the next node
                int bucketIndex = getBucketIndex(node.hash); // Calculate the new bucket index
                node.next = newBuckets[bucketIndex]; // Link the current node to the new bucket
                newBuckets[bucketIndex] = node; // Place the node in the new bucket
                node = next; // Move to the next node in the old bucket
            }
        }
        buckets=newBuckets;
    }

    private static int getBucketIndex(int hash) {
        return hash & capacity-1;
    }

    private static <K> int getHash(K key) {
        return Objects.hash(key);
    }

    public V get(K key){
        int hash = getHash(key);
        int bucketIndex= getBucketIndex(hash);
        Node<K,V> bucket= buckets[bucketIndex];
        while (bucket!=null){
            if(bucket.hash==hash && bucket.key== key){
                return bucket.value;
            }
            bucket=bucket.next;
        }
       return null;
    }
    public V remove(K key){
        int hash = getHash(key);
        int bucketIndex= getBucketIndex(hash);
        Node<K,V> bucket= buckets[bucketIndex];
        while (bucket!=null){
            if(bucket.hash==hash && bucket.key== key){
                V value= bucket.value;

                bucket.value=null;
                size--;
                return value;
            }
            bucket=bucket.next;
        }
        return null;
    }
    public int size(){
            return size;
}



    public static void main(String[] args) {
        CustomHashMap<Integer, Integer > map= new CustomHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println( map.get(1));
        System.out.println(map.remove(2));
        System.out.println(map.get(2));
        System.out.println(map.size());


    }

}
