package org.example.lld.comparisonStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**"Suppose you're given a JSON configuration like the one below, which defines a set of filter conditions with multiple comparison operations per key. Design a flexible and extensible system in Java to evaluate whether a given input (e.g., a user request or app context) matches the filters. How would you implement this using the Strategy Pattern?"

json
        Copy
Edit
[
        {
        "key": "appVersion",
        "comparisons": [
        { "comparison": "greaterThan", "value": "493" },
        { "comparison": "smallerThan", "value": "499" }
        ]
        },
        {
        "key": "platform",
        "comparisons": [
        { "comparison": "equals", "value": "android" },
        { "comparison": "equals", "value": "iOS" }
        ]
        }
        ]
How would you model this JSON as Java objects?

How would you handle dynamic comparison types like greaterThan, equals, etc. without using multiple if-else or switch statements?

How would you apply the Strategy Pattern to support new comparison types in the future?*/

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonInput = """
        [
            {
                "key": "appVersion",
                "comparisons": [
                    { "comparison": "greaterThan", "value": "493" },
                    { "comparison": "smallerThan", "value": "499" }
                ]
            },
            {
                "key": "platform",
                "comparisons": [
                    { "comparison": "equals", "value": "android" },
                    { "comparison": "equals", "value": "iOS" }
                ]
            }
        ]
        """;

        ObjectMapper mapper = new ObjectMapper();
        List<FilterCondition> filterConditions = mapper.readValue(
                jsonInput, new TypeReference<List<FilterCondition>>() {});

        // Just to verify
        for (FilterCondition condition : filterConditions) {
            System.out.println("Key: " + condition.getKey());
            for (Comparison comparison : condition.getComparisons()) {
                System.out.println(" - " + comparison.getComparison() + ": " + comparison.getValue());
            }
        }
        List<FilterCondition> conditions = filterConditions; // parse your input JSON to this

        Map<String, Object> inputData = new HashMap<>();
        inputData.put("appVersion", 495);
        inputData.put("platform", "android");

        ConditionEvaluator evaluator = new ConditionEvaluator();
        boolean result = evaluator.evaluate(conditions, inputData);

        System.out.println("Evaluation result: " + result);
    }


}
