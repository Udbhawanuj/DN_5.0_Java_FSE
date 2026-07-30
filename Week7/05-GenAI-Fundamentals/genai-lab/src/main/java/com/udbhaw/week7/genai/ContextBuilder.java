package com.udbhaw.week7.genai;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ContextBuilder {
    private final int maxCharacters;
    private final Deque<String> items = new ArrayDeque<>();

    public ContextBuilder(int maxCharacters) {
        if (maxCharacters < 100) throw new IllegalArgumentException("Context budget must be at least 100 characters");
        this.maxCharacters = maxCharacters;
    }

    public ContextBuilder add(String source, String text) {
        if (text == null || text.isBlank()) return this;
        String item = "[Source: " + source + "]\n" + text.trim();
        items.addLast(item);
        trim();
        return this;
    }

    public String build() {
        return String.join("\n\n", items);
    }

    private void trim() {
        while (build().length() > maxCharacters && items.size() > 1) {
            items.removeFirst();
        }
        if (build().length() > maxCharacters) {
            String current = items.removeFirst();
            items.addFirst(current.substring(0, maxCharacters));
        }
    }
}
