//package org.example.java8;
//
//import java.util.List;
//
//public class NewOne {
//    public static void main(String[] args) {
//        List<String> names = List.of("ayush", "gupta");
//
//        // This would work if display() is static
//        names.forEach(name -> {
//            Practice practice = new TestPractice();
//            practice.display();
//        });
//
//        // OR use a method reference to a specific object's method
//        TestPractice testPractice = new TestPractice();
//        names.forEach(name -> testPractice.display()); // or use a method reference: names.forEach(testPractice::display);
//    }
//}
