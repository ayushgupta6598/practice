package org.example.lld.comparisonStrategy.factory;

public class EqualsStrategy implements ComparisonStrategy {
    public boolean compare(Object actualValue, String expectedValue) {
        return actualValue.toString().equalsIgnoreCase(expectedValue);
    }
}
