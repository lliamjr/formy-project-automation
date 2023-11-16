import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        // Iterate through each word in the array
        for (String word : strs) {
            // Sort the characters of the word and use it as a key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // Check if the key is already in the map
            if (anagramsMap.containsKey(sortedWord)) {
                // If yes, add the word to the existing group
                anagramsMap.get(sortedWord).add(word);
            } else {
                // If no, create a new group with the word
                List<String> group = new ArrayList<>();
                group.add(word);
                anagramsMap.put(sortedWord, group);
            }
        }

        // Convert the values of the map to a list to get the final result
        return new ArrayList<>(anagramsMap.values());
    }

    public static void main(String[] args) {
        // Example usage:
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // Output: [[""]]

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // Output: [["a"]]
    }
}
