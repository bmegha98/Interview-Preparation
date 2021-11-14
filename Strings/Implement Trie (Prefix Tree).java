/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various 
applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/

class TrieNode {
    char data;
    boolean endOfWord;
    TrieNode[] children;
    
    public TrieNode(char ch) {
        data = ch;
        endOfWord = false;
        children = new TrieNode[26];
        for(int i=0;i<26;i++)
            children[i] = null;
    }
}
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode('/');
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new TrieNode(ch);
            curr = curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}
