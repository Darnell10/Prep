package com.company.stacksandqueues;

import java.util.*;

public class BracketValidator {

    public static void main(String[] args) {


    }

    /** O(n) Time and Space */
    public static boolean isValid(String code) {

        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Deque<Character> openerStack = new ArrayDeque<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (openers.contains(c)) {
                openerStack.push(c);
            } else if (closers.contains(c)) {
                if (openerStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openerStack.pop();

                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }
        return openerStack.isEmpty();
    }
}
