package com.learnings;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringReConstruct {

    public static void main(String[] args) {
        System.out.println(verifyString());
    }


    private static boolean verifyString() {
        String[] givenStr = "AAABBCCCCCCDLLlolp```111123430-/.,;'`!@#$%^&*()_+<>:".split("");
        List<Map<String, Integer>> frequencyMaps = getFrequencyMaps(givenStr);
        String reconstructedString = reconstructString(frequencyMaps);
        return reconstructedString.equals(String.join("", givenStr));
    }


    private static String reconstructString(List<Map<String, Integer>> frequencyMaps) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Integer> map : frequencyMaps) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                sb.append(entry.getKey().repeat(entry.getValue()));
            }
        }
        return sb.toString();
    }

    private static List<Map<String, Integer>> getFrequencyMaps(String[] givenStr) {
        List<Map<String, Integer>> frequencyMaps = new ArrayList<>();
        Map<String, Integer> currentMap = new LinkedHashMap<>();

        for (int i = 0; i < givenStr.length; i++) {
            String currentChar = givenStr[i];
            currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);

            if (i + 1 < givenStr.length && !currentChar.equals(givenStr[i + 1])
                    || i == givenStr.length - 1) {
                frequencyMaps.add(new LinkedHashMap<>(currentMap));
                currentMap.clear();
            }
        }
        return frequencyMaps;
    }
}
