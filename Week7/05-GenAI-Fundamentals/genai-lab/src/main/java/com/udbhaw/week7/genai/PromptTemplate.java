package com.udbhaw.week7.genai;

import java.util.List;

public record PromptTemplate(String role, String task, List<String> constraints, String outputFormat) {
    public PromptTemplate {
        if (role == null || role.isBlank()) throw new IllegalArgumentException("role is required");
        if (task == null || task.isBlank()) throw new IllegalArgumentException("task is required");
        constraints = List.copyOf(constraints == null ? List.of() : constraints);
        outputFormat = outputFormat == null ? "Plain text" : outputFormat;
    }

    public String render(String context) {
        return "ROLE:\n" + role +
                "\n\nTASK:\n" + task +
                "\n\nCONTEXT:\n" + (context == null || context.isBlank() ? "No additional context." : context) +
                "\n\nCONSTRAINTS:\n- " + String.join("\n- ", constraints) +
                "\n\nOUTPUT FORMAT:\n" + outputFormat;
    }
}
