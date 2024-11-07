package com.org.bank;

import java.util.*;

public class polymorphism {
    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>();
        l.add(78);
        l.add(43);
        l.add(26);
        l.add(69);
        l.add(45);
        l.add(43); // Adding duplicate for testing
        l.add(69); // Adding duplicate for testing

        // Find maximum and minimum using iterators
        Iterator<Integer> it = l.iterator();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // Loop through the list to find max and min
        while (it.hasNext()) {
            int number = it.next();
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        // Find duplicates using a nested loop
        List<Integer> duplicates = new ArrayList<>();
        
        // Outer loop to go through each element
        for (int i = 0; i < l.size(); i++) {
            int num = l.get(i);
            // Skip if the number is already added to duplicates
            if (!duplicates.contains(num)) {
                // Inner loop to check for duplicates
                for (int j = i + 1; j < l.size(); j++) {
                    if (num == l.get(j)) {
                        duplicates.add(num);
                        break; // Stop checking once a duplicate is found
                    }
                }
            }
        }

        // Output duplicates
        System.out.println("Duplicate values: " + duplicates);

        // Output max and min values
        System.out.println("Maximum number is: " + max);
        System.out.println("Minimum number is: " + min);
    }
}
