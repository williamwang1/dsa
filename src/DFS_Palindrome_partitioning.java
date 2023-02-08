import java.util.ArrayList;
import java.util.List;

public class DFS_Palindrome_partitioning {

    public static void main(String[] argus) {
        String input = "ccd";
        DFS_Palindrome_partitioning p = new DFS_Palindrome_partitioning();
        List<List<String>> result = p.partition(input);
        for (List<String> ss : result) {
            for (String s : ss) {
                System.out.print(s + " ");
            }
            System.out.println("////");
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        dfs(res, new ArrayList<String>(), s);
        return res;
    }

    private void dfs(List<List<String>>res, List<String>cur, String s) {
        if(s.equals("")) {
            List<String>copy = new ArrayList<>(cur);
            res.add(copy);
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String substr = s.substring(0, i);
            if(isPali(substr)) {
                cur.add(substr);
                dfs(res, cur, s.substring(i));
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPali(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

/**
 * state define and initialization
 * state isPalindrome[i][j], string start i, end j is Palindrome or not
 *
 * initialization :
 * single charater is plaindrome Palindrome[i][i] = true
 * two adjacent characters
 *
 *
 * state transit
 * if "aa" is palindrome, then "baab"  is palindrome
 * if "aa" is palindrome, then "baac"  is palindrome
 * if "ab" is not palindrome, then "aaba", "aabb" is also not palindrome
 *
 * isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
 *
 * Q : why start index start at n - 3, not n - 1
 * coz n - 1, then no place for end index, also 1 charater and 2 charecters has been checked already
 *
 * Q: int start in helper() means ?
 * index of first letter of cur string in String s
 *
 *
 * Q: why i + start - 1 ?
 * i is cut positon, array index postion = i - 1
 *
 * Q: why next start is start + i ?
 * next start index = previous start index + current cut position in cur string
 */

//public class Solution {
//    /*
//     * @param s: A string
//     * @return: A list of lists of string
//     */
//    List<List<String>> result = new ArrayList<>();
//    boolean[][] isPalindrome;
//
//    public List<List<String>> partition(String s) {
//        if (s == null) {
//            return result;
//        }
//        if (s.length() == 0) {
//            return result;
//        }
//
//        List<String> partiton = new ArrayList();
//
//        getPalindrome(s);
//
//        helper(s, partiton, 0);
//
//        return result;
//    }
//
//    private void getPalindrome(String s) {
//        int length = s.length();
//        isPalindrome = new boolean[length][length];
//
//        for (int i = 0; i < length; i++) {
//            isPalindrome[i][i] = true;
//        }
//
//        for( int i = 0; i < length - 1; i++) {
//            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
//        }
//
//        // start index from end to begin
//        for (int i = length - 3; i >= 0; i--) {
//            for (int j = i + 2; j < length; j++) {
//                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
//            }
//        }
//
//    }
//
//    private void helper(String cur, List<String> partition, int start) {
//        // end condition
//        if (cur.length() == 0) {
//            result.add(new ArrayList(partition));
//            return;
//        }
//
//        for (int i = 1; i <= cur.length(); i++) {
//            // skip
//            String sub = cur.substring(0, i);
//
//            if (!isPalindrome[start][i + start - 1]) {
//                continue;
//            }
//            partition.add(sub);
//            helper(cur.substring(i), partition, start + i);
//            partition.remove(partition.size() - 1);
//        }
//    }
//
//}
