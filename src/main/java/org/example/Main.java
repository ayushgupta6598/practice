package org.example;

public class Main {
    public static void main(String[] args) {



//        LargestSegmentFinder largestSegmentFinder=new LargestSegmentFinder();
//        String aab = largestSegmentFinder.findLargestSegment("aab");
//        System.out.println(aab);


//        int[] A = {10, 20, 30, 60,50};
//        int[] B = {20, 30, 60, 50,10};
//        int[] A = {47, 11, 30, 22};
//        int[] B = {47, 22,30,11};
//
//        int result = maxMatchingPairs(A, B);
//        System.out.println("Maximum matching pairs: " + result);  // Output: 4
//        System.out.println("Hello world!");
//        int[] arr={1,2,3,4,5};
//        Node num=new Node(arr[0]);
//        Node temp=num;
//        for(int i=1;i<=arr.length;i++){
//            Node temp1=new Node(arr[i]);
//            num.next=temp1;
//            temp1=temp;
//        }
//        return num;
//    }


//    static Node constructLL(int arr[]) {

//    }
}


        public static int maxMatchingPairs(int[] A, int[] B) {
            int N = A.length;
            int maxPairs = 0;

            // Try all possible shifts
            for (int k = 0; k < N; k++) {
                int currentPairs = 0;
                for (int i = 0; i < N; i++) {
                    if (A[i] == B[(i + k) % N]) {
                        currentPairs++;
                    }
                }
                maxPairs = Math.max(maxPairs, currentPairs);
            }

            return maxPairs;
        }


}