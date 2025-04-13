package org.example.lld.comparisonStrategy.factory;

public class SmallerThanStrategy implements ComparisonStrategy {
    public boolean compare(Object actualValue, String expectedValue) {
        return Integer.parseInt(actualValue.toString()) < Integer.parseInt(expectedValue);
    }
}
