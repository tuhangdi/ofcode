package leetcode.Tree;

import com.sun.scenario.animation.shared.TimerReceiver;

/**
 * Created by thd on 2017/8/28
 *
 *
 Implement a trie with insert, search, and startsWith methods.
 使用insert，search和startsWith方法实现一个字典树（trie）。
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 假设所有输入都是小写字母a-z。


 使用我的解决方案，我采取了简单的方法，给每个TrieNode一个每个可能的子节点的26元素数组。我只给了26个子节点，因为我们只使用小写的'a' - 'z'。如果你不确定为什么我把我的Trie的根是一个空字符，这是一个标准的/典型的方法来构建一个Trie它是有点任意的根节点是什么。

 对于插入，我使用以下算法。循环通过正在插入的单词中的每个字符检查字符是否是当前TrieNode的子节点，也就是检查数组是否具有该字符索引中的填充值。如果当前字符不是我当前节点的子节点，则将此字符表示添加到相应的索引位置，然后将当前节点设置为等于添加的子节点。但是，如果当前字符为当前节点的子节点，则仅将当前节点设置为等于该子节点。在评估整个字符串后，我们遗漏的节点被标记为一个单词，这使我们的Trie知道我们的“字典”中存在哪些单词

 对于搜索，我只需浏览Trie，如果我发现当前字符不在Trie我返回false。
 在检查字符串中的每个Char后，我检查以查看我是否已经停止的节点被标记为返回结果的单词。

 开始与搜索是相同的，除了如果节点I离开被标记为单词无关，如果整个字符串评估我总是返回true;

 */
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class n208ImplementTriePrefixTree {
    private TrieNode root;

    /** Initialize your data structure here. */
    public n208ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                ws.children[c - 'a'] = new TrieNode();
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
