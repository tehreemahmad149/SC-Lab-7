package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class perms {

    public static void main(String[] args) {
        
        String input = args[0];
        
        if (input.isEmpty()) {
            System.out.println("Input string cannot be empty.");
            return;
        }

        List<String> permutations = generatePermutations(input);
        System.out.println("Permutations of \"" + input + "\": " + permutations);// debugging console output
    }

    public static List<String> generatePermutations(String str) {
        Set<String> uniquePermutations = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        if (str == null || str.isEmpty()) {//if string is null re turn empty ArrayList<>
            return result;
        }
        
        permute(str.toCharArray(), 0, uniquePermutations);//string to char array so character handling is easier
        result.addAll(uniquePermutations);//set of all perms
        return result;
    }

    private static void permute(char[] chars, int index, Set<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars)); // only unique permutation as for duplicate characters same permutations are also present
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);           // swap two characters to start the permuation
            permute(chars, index + 1, result); // recursive call for the next character so the permutations are like a stack call
            swap(chars, index, i);           // backing
        }
    }

    private static void swap(char[] chars, int i, int j) {//swap code...look for inbuilt function 
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
