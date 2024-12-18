// There are some cubes, and each cube has an alphabet (from A to Z) 
// printed on it. You can construct different, non-empty words using these 
// cubes and each of the word length should be 0 < length <= number of cubes.

// You are given a string of alphabets S, 
// Your task is to findout number of possible non-empty distinct words

// Input Format:
// -------------
// A string S, consist of A-Z letters only.

// Output Format:
// --------------
// Print an integer, number of possible non-empty distinct words.


// Sample Input-1:
// ---------------
// EGG

// Sample Output-1:
// ----------------
// 8

// Explanation:
// --------------
// The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


// Sample Input-2:
// ---------------
// MADAM

// Sample Output-2:
// ----------------
// 89


import java.util.HashSet;
import java.util.Set;

public class DistinctWords {
    public static void main(String[] args) {
        String input = "MADAM"; // Change input to test other cases
        System.out.println(findDistinctWords(input));
    }

    public static int findDistinctWords(String s) {
        Set<String> distinctWords = new HashSet<>();
        generatePermutations(s, "", distinctWords);
        return distinctWords.size();
    }

    // Helper method to generate all permutations
    private static void generatePermutations(String s, String current, Set<String> distinctWords) {
        // Base case: If we have a non-empty current word, add it to the set
        if (!current.isEmpty()) {
            distinctWords.add(current);
        }

        // Recursive case: Iterate through all characters and create permutations
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the permutation and remove it from the remaining string
            generatePermutations(s.substring(0, i) + s.substring(i + 1), current + s.charAt(i), distinctWords);
        }
    }
}
