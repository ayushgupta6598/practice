package org.example.lld.comparisonStrategy;

import org.example.lld.comparisonStrategy.factory.ComparisonStrategy;
import org.example.lld.comparisonStrategy.factory.StrategyFactory;

import java.util.List;
import java.util.Map;

public class ConditionEvaluator {
    public boolean evaluate(List<FilterCondition> conditions, Map<String, Object> data) {
        for (FilterCondition condition : conditions) {
            Object actualValue = data.get(condition.getKey());

            boolean atLeastOneComparisonTrue = false;
            for (Comparison comparison : condition.getComparisons()) {
                ComparisonStrategy strategy = StrategyFactory.getStrategy(comparison.getComparison());
                if (strategy != null && strategy.compare(actualValue, comparison.getValue())) {
                    atLeastOneComparisonTrue = true;
                    break; // OR logic within comparisons of same key
                }
            }

            if (!atLeastOneComparisonTrue) {
                return false; // AND logic across different keys
            }
        }
        return true;
    }
}
