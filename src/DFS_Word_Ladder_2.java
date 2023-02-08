import java.util.*;

public class DFS_Word_Ladder_2 {

    /**
     * Inspiration :
     * 所有问题 --》 DFS， 选择列表剪枝，排除不是最短路径的选择
     * 怎样知道每一个选择是否为最短？
     * bfs 从end 开始统计每个点到end 的距离
     * 为了之后DFS方便，同时build graph
     *
     * bfs from end to start, build distance map and build graph
     * 1. initialize
     * 		initial queue - put end into queue
     * 		initialize distance - distance.put(end, 0);
     * 		initialize graph - loop element in graph, graph.put(s, new ArrayList());
     * 2. poll element out and return if any
     * 3. get next selections
     * 4. loop next elements
     * 		graph <--> next element  不需要剪枝
     * 				map.get(pre).add(cur);
     * 		distance <--> next element  需要剪枝, avoid to put duplicate elements
     * 				distance.put(pre, distance.get(cur) + 1);
     * 		queue.offer() <--> next element 需要剪枝
     *
     * 	dfs
     * Note:
     * end condition : cur.equals(end)
     * 选择列表 剪枝 ： distance.get(cur) != distance.get(next) + 1
     *
     * */

    public static void main(String[] argus) {
        DFS_Word_Ladder_2 dfs = new DFS_Word_Ladder_2();
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("c");
        dfs.findLadders("a", "c",dict );
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        bfs(distance, graph, start, end, dict);
        List<List<String>> ladders = new ArrayList<>();
        List<String> ladder = new ArrayList();
        ladder.add(start);
        dfs(ladders, graph, distance, start ,end, ladder);
        return ladders;
    }

    private void bfs(Map<String, Integer>distance,
                     Map<String, List<String>>graph,
                     String start,
                     String end,
                     Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);
        for (String s : dict) {
            graph.put(s, new ArrayList());
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> preWords = getPreviousWords(cur, dict);
            for (String pre : preWords) {
                graph.get(pre).add(cur);
                if (!distance.containsKey(pre)) {
                    distance.put(pre, distance.get(cur) + 1);
                    queue.offer(pre);
                }
            }

        }
    }

    private List<String> getPreviousWords(String cur, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (cur.charAt(i) != c) {
                    String newString = cur.substring(0, i)  + c + cur.substring(i + 1);
                    if (dict.contains(newString)) {
                        result.add(newString);
                    }
                }
            }
        }
        return result;
    }

    private void dfs(List<List<String>> ladders, Map<String, List<String>> graph, Map<String, Integer> distance, String cur, String end, List<String> ladder) {
        // ladder.add(cur);
        if (cur.equals(end)) {
            ladders.add(new ArrayList(ladder));
            return;
        }

        List<String> nextWords = graph.get(cur);
        for (String next : nextWords) {
            if (!distance.containsKey(next)) {
                continue;
            }
            if (distance.get(cur) != distance.get(next) + 1) {
                continue;
            }

            ladder.add(next);
            dfs(ladders, graph, distance, next, end, ladder);
            ladder.remove(ladder.size() - 1);
        }
    }


//    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        // write your code here
//
//
//        List<List<String>> ladders = new ArrayList<>();
//        Map<String, Integer> distance = new HashMap<>();
//        Map<String, List<String>> map = new HashMap<>();
//
//        dict.add(start);
//        dict.add(end);
//        bfs(distance, map, start, end, dict);
//
//        // List<String> path = new ArrayList(); // 已作出的选择
//        List<String> path = new ArrayList<String>(); // 已作出的选择
//        path.add(start);  // path must contain start as a start point
//        dfs(ladders, path, start, end, distance, map);
//        return ladders;
//    }
//
//    // dfs to get all paths
//    // recusion definition
//    // find all paths start with path, put all paths into ladders
//    private void dfs (List<List<String>> ladders, List<String> path, String cur, String end,
//                      Map<String, Integer> distance, Map<String, List<String>> map) {
//        // end condition
//        if (cur.equals(end)) {
//            ladders.add(new ArrayList<String>(path));
//            return;
//        }
//        // loop selection for next level element
//        for (String next : map.get(cur)) {
//            // make sure distance map has next element
//            if (!distance.containsKey(next)) {
//                continue;
//            }
//            // make sure shortest path selected
//            // next level element = previous element + 1
//            if (distance.get(cur) != distance.get(next) + 1) {
//                continue;
//            }
//            // select one option
//            path.add(next);
//            // dfs next level start --> next
//            dfs(ladders, path, next, end, distance, map);
//            // remove selection
//            path.remove(path.size() - 1);
//        }
//    }
//
//
//    // private void dfs(List<List<String>> ladders, List<String> path, String cur, String end,
//    // Map<String, Integer> distance, Map<String, List<String>> map) {
//    //     path.add(cur); // 做出选择
//    //     if (cur.equals(end)) { // end conditon
//    //         ladders.add(new ArrayList<String>(path)); // add into results
//    //     } else {
//    //         for (String next : map.get(cur)) { // loop next level element for selection
//    //             // ????
//    //             if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
//    //                 dfs(ladders, path, next, end, distance, map); // change next as cur, recusion
//    //             }
//    //         }
//    //     }
//    //     path.remove(path.size() - 1); // remove selection from path
//    // }
//
//
//    // bfs get distance from every string to end
//    // bfs get relaition between string to next level strings
//    // distance --> distance to end
//    // end --> as a start for bfs
//    // start --> as end condition
//    // map --> key is element in dict, value is next level elements in dict
//    private void bfs(Map<String, Integer> distance, Map<String, List<String>> map, String start, String end, Set<String> dict) {
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(end);
//        distance.put(end, 0);
//
//        // initailize relation between element and next level element
//        for (String s : dict) {
//            map.put(s, new ArrayList<String>());
//        }
//
//        while (!queue.isEmpty()) {
//            String cur = queue.poll();
//            List<String> nextWords = getNextWords(cur, dict);
//            for (String next : nextWords) {
//                // why get(next).add(cur) ? not get(cur).add(next) ?,
//                //coz next is upper level, cur is lower level, bfs start from end
//                map.get(next).add(cur);
//
//                if (!distance.containsKey(next)) { // avoid dupliacte distance calculation
//                    // distance of next level element = distance of previous level element + 1
//                    distance.put(next, distance.get(cur) + 1);
//                    queue.offer(next);
//                }
//
//            }
//        }
//    }
//
//    //
//    private List<String> getNextWords(String cur, Set<String> dict) {
//        List<String> result = new ArrayList();
//        for(int i = 0; i < cur.length(); i ++) { // loop charecter in string
//            for (char c = 'a'; c <= 'z'; c++) { // try every possible replacement for every letter
//                if (c == cur.charAt(i)) {      // replacement and current is the same, skip
//                    continue;
//                }
//                // new string after replacement
//                String replacment = cur.substring(0, i) + c + cur.substring(i + 1);
//                if (dict.contains(replacment)) {
//                    result.add(replacment);
//                }
//            }
//        }
//        return result;
//    }
}




//public class Solution {
//    /*
//     * @param start: a string
//     * @param end: a string
//     * @param dict: a set of string
//     * @return: a list of lists of string
//     */
//    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        // write your code here
//        List<List<String>> result = new ArrayList<>();
//        if (start == null || end == null) {
//            return result;
//        }
//        dict.add(start);
//        dict.add(end);
//
//        Map<String, List<String>> graph = new HashMap<>();
//        buildGraphWithBFS(graph, start, end, dict);
//
//        List<String> ladder = new ArrayList<>();
//        ladder.add(start);
//        findLaddersWithDFS(result, graph, start, end, ladder);
//
//        return result;
//    }
//
//    private void buildGraphWithBFS(Map<String, List<String>> graph, String start, String end, Set<String> dict) {
//        Set<String> visitedWords = new HashSet<>();
//        boolean wordNotFound = true;
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(start);
//        visitedWords.add(start);
//
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            Set<String> visitedWordsCurrentLevel = new HashSet<>();
//            for (int i = 0; i < levelSize; ++i) {
//                String currWord = queue.poll();
//                char[] currWordArray = currWord.toCharArray();
//                for (int j = 0; j < currWordArray.length; ++j) {
//                    char origianlChar = currWordArray[j];
//
//                    for (char k = 'a'; k <= 'z'; ++k) {
//                        if (k == origianlChar) {
//                            continue;
//                        }
//                        currWordArray[j] = k;
//                        String nextWord = String.valueOf(currWordArray);
//                        if (dict.contains(nextWord) && !visitedWords.contains(nextWord)) {
//                            if (nextWord.equals(end)) {
//                                wordNotFound = false;
//                            }
//
//                            if (!visitedWordsCurrentLevel.contains(nextWord)) {
//                                queue.offer(nextWord);
//                                visitedWordsCurrentLevel.add(nextWord);
//                            }
//
//                            if (!graph.containsKey(currWord)) {
//                                graph.put(currWord, new ArrayList<>());
//                            }
//
//                            graph.get(currWord).add(nextWord);
//
//                        }
//                        currWordArray[j] = origianlChar;
//                    }
//                }
//            }
//            if (!wordNotFound) {
//                break;
//            }
//            visitedWords.addAll(visitedWordsCurrentLevel);
//        }
//    }
//
//
//    private void findLaddersWithDFS(List<List<String>> result, Map<String, List<String>> graph,
//                                    String currentWord, String target, List<String> ladder) {
//        if (currentWord.equals(target)) {
//            result.add(new ArrayList<>(ladder));
//            return;
//        }
//
//        if (graph.containsKey(currentWord)) {
//            for (String nextWord: graph.get(currentWord)) {
//                ladder.add(nextWord);
//                findLaddersWithDFS(result, graph, nextWord, target, ladder);
//                ladder.remove(ladder.size() - 1);
//            }
//        }
//    }
//}
