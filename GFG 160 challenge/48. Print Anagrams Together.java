// Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.

// Examples:

// Input: arr[] = ["act", "god", "cat", "dog", "tac"]
// Output: [["act", "cat", "tac"], ["god", "dog"]]

// Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

// Input: arr[] = ["no", "on", "is"]
// Output: [["is"], ["no", "on"]]

// Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.

// Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
// Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]

// Explanation: 
// Group 1: "abc", "bac", and "cab" are anagrams.
// Group 2: "listen", "silent", and "enlist" are anagrams.
// Group 3: "rat", "tar", and "art" are anagrams.

// Constraints:
// 1<= arr.size() <=100
// 1<= arr[i].size() <=10



class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<List<Integer>, ArrayList<String>> res = new HashMap<>();
        ArrayList<ArrayList<String>> op = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            int[] map = new int[26];
            for(int j=0; j<arr[i].length(); j++){
                map[arr[i].charAt(j) - 'a']++;
            }

            List<Integer> freq = new ArrayList<>();
            for(int num :map){
                freq.add(num);
            }
            if(res.containsKey(freq)){
                res.get(freq).add(arr[i]);
            }else{
                ArrayList<String> val = new ArrayList<>();
                val.add(arr[i]);
                res.put(freq, val);
            }
        }
        
        for(ArrayList<String> value: res.values()){
            op.add(value);
        }
        return op;
    }
}