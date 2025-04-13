package org.example.lld.comparisonStrategy.factory;

import java.util.Map;
import java.util.HashMap;

public class StrategyFactory {
    private static final Map<String, ComparisonStrategy> strategies = new HashMap<>();

    static {
        strategies.put("greaterThan", new GreaterThanStrategy());
        strategies.put("smallerThan", new SmallerThanStrategy());
        strategies.put("equals", new EqualsStrategy());
    }

    public static ComparisonStrategy getStrategy(String comparisonType) {

        return strategies.get(comparisonType);
    }
}
