/*
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from
startWord to targetWord. You can return them in any order possible.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList.
Return an empty list if there is no such transformation sequence.
The first part of this problem can be found here.


Example 1:

Input:
startWord = "der", targetWord = "dfs",
wordList = {"des","der","dfr","dgt","dfs"}
Output:
der dfr dfs
der des dfs
Explanation:
The length of the smallest transformation is 3.
And the following are the only two ways to get
to targetWord:-
"der" -> "des" -> "dfs".
"der" -> "dfr" -> "dfs".
*/

//Time = O(26*m*n+VE) 

class pair{
  String word;
  int dist;
  public pair(String w, int d) {
    word = w;
    dist = d;
  }
  public String getKey() {
    return word;
  }
  public int getValue() {
    return dist;
  }
}
class WordLadder
{
  Map<String,Integer> visited = new HashMap<>();
  Map<String, ArrayList<String>> adj = new HashMap<>();
  Set<String> aux = new HashSet<>();
  ArrayList<ArrayList<String>> res = new ArrayList<>();
  public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
  {
    aux.addAll(Arrays.asList(wordList));
    if(!aux.contains(targetWord))
      return res;

    Queue<pair> q = new LinkedList<>();
    q.add(new pair(startWord,0));
    visited.put(startWord,0);
    while(!q.isEmpty()) {
      pair p = q.poll();
      String curr = p.getKey();
      int d = p.getValue();
      if(curr.equals(targetWord))
        break;

      for(int i=0;i<curr.length();i++) {
        char[] w = curr.toCharArray();
        char ch = w[i];
        for(char j ='a';j<='z';j++) {
          if(ch == j)
            continue;
          w[i] = j;
          String newWord = new String(w);
          if(!aux.contains(newWord))
            continue;
          if(!visited.containsKey(newWord)) {
            q.add(new pair(newWord,d+1));
            visited.put(newWord,d+1);
            ArrayList<String> l;
            if(!adj.containsKey(curr))
              l = new ArrayList<>();
            else
              l = adj.get(curr);
            l.add(newWord);
            adj.put(curr,l);
          }
          else if(visited.get(newWord) > d) {
            ArrayList<String> l;
            if(!adj.containsKey(curr))
              l = new ArrayList<>();
            else
              l = adj.get(curr);
            l.add(newWord);
            adj.put(curr,l);
          }
        }
      }
    }

    dfs(startWord,targetWord,new ArrayList<>());
    return res;
  }

  private void dfs(String start, String target, ArrayList<String> path) {
    path.add(start);
    if(start.equals(target)) {
      res.add(new ArrayList<>(path));
      path.remove(path.size()-1);
      return;
    }

    for(String ele : adj.get(start))
      dfs(ele,target,path);
    path.remove(path.size()-1);
  }
}
public class WordLadder2 {
  public static void main(String[] args) {
    WordLadder s = new WordLadder();
    String startWord = "der", targetWord = "dfs";
    String[] wordList = {"des","der","dfr","dgt","dfs"};
    ArrayList<ArrayList<String>> seq = s.findSequences(startWord, targetWord, wordList);
    for(ArrayList<String> p : seq) {
      for (String w : p) System.out.print(w+"- ");
      System.out.println();
    }
  }
}
