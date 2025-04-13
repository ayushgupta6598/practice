package org.example.lld.comparisonStrategy;

import java.util.List;

public class FilterCondition {
    private String key;
    private List<Comparison> comparisons;

    // getters and setters
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public List<Comparison> getComparisons() { return comparisons; }
    public void setComparisons(List<Comparison> comparisons) { this.comparisons = comparisons; }
}
