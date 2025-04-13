package org.example.lld.comparisonStrategy.factory;

// 1. Strategy Interface
public interface ComparisonStrategy {
    boolean compare(Object actualValue, String expectedValue);
}

