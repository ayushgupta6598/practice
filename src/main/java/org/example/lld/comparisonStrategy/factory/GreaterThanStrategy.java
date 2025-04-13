package org.example.lld.comparisonStrategy.factory;

// 2. Strategy Implementations
public class GreaterThanStrategy implements ComparisonStrategy {
    public boolean compare(Object actualValue, String expectedValue) {
        return Integer.parseInt(actualValue.toString()) > Integer.parseInt(expectedValue);
    }
}
