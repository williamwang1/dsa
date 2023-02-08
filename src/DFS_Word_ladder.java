import java.util.*;

public class DFS_Word_ladder {

    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here


        if (dict == null) {
            return 0;
        }

        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int length = 1;
        while(!queue.isEmpty()) {
            length++; // end string will also count as a step, so put here, not at the end of while loop
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nextWords = getNextWords(cur, dict);
                for (String next : nextWords) {
                    if (next.equals(end)) {
                        return length;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }

        }


        return 0;
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {  // loop words
            for (char c = 'a'; c <= 'z'; c++) {    // loop possibility for every letter
                if (c != word.charAt(i)) {
                    String next = word.substring(0, i) + c + word.substring(i + 1);
                    if (dict.contains(next)) {
                        result.add(next);
                    }
                }
            }
        }
        return result;
    }
}

// https://www.jiuzhang.com/solutions/word-ladder/

// why 2 ? should be 1, form "a" to "c"
//Input：start = "a"，end = "c"，dict =["a","b","c"]
//        Output：2
//        Explanation：
//        "a"->"c"

