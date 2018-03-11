package com.github.dkoval.algopuzzles.hackerrank.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasickAutomaton {

    /**
     * Maximum number of characters in input alphabet.
     */
    public static final int MAX_NUM_CHARS = 26;

    private final int[][] g;
    private final int[] f;
    private final int[] out;
    private final String[] keywords;

    public AhoCorasickAutomaton(String[] keywords) {
        int maxNumStates = Arrays.stream(keywords).mapToInt(String::length).sum();
        this.g = new int[maxNumStates][MAX_NUM_CHARS];
        this.f = new int[maxNumStates];
        this.out = new int[maxNumStates];
        this.keywords = keywords;
        constructKeywordTree();
        constructSuffixLinks();
    }

    private void constructKeywordTree() {
        Arrays.stream(g).forEach(row -> Arrays.fill(row, -1));
        // initially, we just have state 0, i.e. root of the tree
        int numStates = 1;
        for (int i = 0; i < keywords.length; i++) {
            int currentState = 0;
            String keyword = keywords[i];
            // insert all characters of current keyword into the tree
            for (int j = 0; j < keyword.length(); j++) {
                int ch = keyword.charAt(j) - 'a';
                // create a new state if there is no state for ch
                if (g[currentState][ch] == -1) {
                    g[currentState][ch] = numStates++;
                }
                currentState = g[currentState][ch];
            }
            // add current keyword to output
            out[currentState] |= (1 << i);
        }
        // for all characters that don't have an edge
        // from state 0, add an edge to state 0 itself
        for (int ch = 0; ch < MAX_NUM_CHARS; ch++) {
            if (g[0][ch] == -1)
                g[0][ch] = 0;
        }
    }

    private void constructSuffixLinks() {
        Arrays.fill(f, -1);
        Queue<Integer> q = new LinkedList<>();
        // iterate over each possible input
        for (int ch = 0; ch < MAX_NUM_CHARS; ch++) {
            // all nodes of depth 1 have failure function = 0
            int state = g[0][ch];
            if (state != 0) {
                f[state] = 0;
                q.add(state);
            }
        }
        // breadth first search
        while (!q.isEmpty()) {
            int state = q.remove();
            // find failure function for all those chars
            // for which goto function is not defined
            for (int ch = 0; ch < MAX_NUM_CHARS; ch++) {
                int transition = g[state][ch];
                if (transition != -1) {
                    // find the deepest node labeled by proper
                    // suffix  from root to current state
                    int failure = f[state];
                    while (g[failure][ch] == -1) {
                        failure = f[failure];
                    }
                    failure = g[failure][ch];
                    f[transition] = failure;
                    // merge output
                    out[transition] |= out[failure];
                    q.add(transition);
                }
            }
        }
    }

    private int nextState(int currentState, char input) {
        int nextState = currentState;
        int ch = input - 'a';
        // if goto function is not defined, use failure function
        while (g[nextState][ch] == -1) {
            nextState = f[nextState];
        }
        return g[nextState][ch];
    }

    public void search(String text, MatchCallback callback) {
        int currentState = 0;
        for (int i = 0; i < text.length(); i++) {
            currentState = nextState(currentState, text.charAt(i));
            if (out[currentState] == 0) {
                continue;
            }
            // match found
            for (int j = 0; j < keywords.length; j++) {
                if ((out[currentState] & (1 << j)) != 0) {
                    callback.doInMatch(j, i - keywords[j].length() + 1, i);
                }
            }
        }
    }

    public interface MatchCallback {
        void doInMatch(int matchedKeywordIndex, int matchStartIndex, int matchEndIndex);
    }
}
