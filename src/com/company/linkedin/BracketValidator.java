package com.company.linkedin;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

public class BracketValidator {

    public static void main(String[] args) {

    }
    /**
     * Solution O(n) Time,Space
     * We iterate through our string, making sure that:
     *
     * each closer corresponds to the most recently seen, unclosed opener
     * every opener and closer is in a pair
     * We use a stack ↴ to keep track of the most recently seen, unclosed opener.
     * And if the stack is ever empty when we come to a closer, we know that closer doesn't have an opener.
     *
     * So as we iterate:
     *
     * If we see an opener, we push it onto the stack.
     * If we see a closer, we check to see if it is the closer for the opener at the top of the stack.
     * If it is, we pop from the stack. If it isn't, or if the stack is empty, we return false.
     * If we finish iterating and our stack is empty, we know every opener was properly closed.
     * */
        /** Time : O(n) , Space : O(n)*/
    public static boolean isValid(String code) {
        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Deque<Character> openersStack = new ArrayDeque<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();
                    // if this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }

        return openersStack.isEmpty();

    }
}
