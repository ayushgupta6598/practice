package org.example.Code;

public class TemperatureRise {
    public static int maxTemperatureRise(int[] temperatures) {
        if (temperatures == null || temperatures.length < 2) {
            return 0;
        }

        int minTemp = temperatures[0];
        int maxDiff = 0;

        for (int i = 1; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            // Calculate the difference between the current temperature and the minimum temperature so far
            int diff = currentTemp - minTemp;

            // Update the maximum difference
            if (diff > maxDiff) {
                maxDiff = diff;
            }

            // Update the minimum temperature
            if (currentTemp < minTemp) {
                minTemp = currentTemp;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {170, 10, 50, 30, 60, 40};
        System.out.println("Maximum Temperature Rise: " + maxTemperatureRise(temperatures1)); // Output: 50

        int[] temperatures2 = {70, 60, 40, 30, 10};
        System.out.println("Maximum Temperature Rise: " + maxTemperatureRise(temperatures2)); // Output: 0
    }
}

