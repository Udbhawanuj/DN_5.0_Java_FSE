package com.udbhaw.week7.task;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JsonSupport {
    private static final Pattern STRING_FIELD = Pattern.compile("\\\"([a-zA-Z0-9_]+)\\\"\\s*:\\s*\\\"((?:\\\\.|[^\\\"])*)\\\"");

    private JsonSupport() {}

    public static String task(Task task) {
        return "{" +
                "\"id\":" + task.id() + "," +
                "\"title\":\"" + escape(task.title()) + "\"," +
                "\"status\":\"" + task.status() + "\"," +
                "\"createdAt\":\"" + task.createdAt() + "\"" +
                "}";
    }

    public static String tasks(List<Task> tasks) {
        return "[" + tasks.stream().map(JsonSupport::task).reduce((a, b) -> a + "," + b).orElse("") + "]";
    }

    public static String field(String json, String name) {
        if (json == null) return null;
        Matcher matcher = STRING_FIELD.matcher(json);
        while (matcher.find()) {
            if (matcher.group(1).equals(name)) return unescape(matcher.group(2));
        }
        return null;
    }

    public static String message(String message) {
        return "{\"message\":\"" + escape(message) + "\"}";
    }

    static String escape(String text) {
        return text.replace("\\", "\\\\").replace("\"", "\\\"")
                .replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    static String unescape(String text) {
        return text.replace("\\n", "\n").replace("\\r", "\r")
                .replace("\\t", "\t").replace("\\\"", "\"").replace("\\\\", "\\");
    }
}
