package com.udbhaw.week7.genai;

import java.util.List;
import java.util.Locale;

public final class SafetyGuard {
    private static final List<String> INJECTION_MARKERS = List.of(
            "ignore previous instructions",
            "reveal the system prompt",
            "print your secret",
            "bypass security"
    );

    public ValidationResult validateInput(String input) {
        String normalized = input == null ? "" : input.toLowerCase(Locale.ROOT);
        for (String marker : INJECTION_MARKERS) {
            if (normalized.contains(marker)) {
                return new ValidationResult(false, "Potential prompt injection detected: " + marker);
            }
        }
        return new ValidationResult(true, "Input passed basic safety checks");
    }

    public ValidationResult validateOutput(String output) {
        if (output == null || output.isBlank()) return new ValidationResult(false, "Output is empty");
        if (output.length() < 40) return new ValidationResult(false, "Output is too short to be useful");
        return new ValidationResult(true, "Output passed validation");
    }

    public record ValidationResult(boolean valid, String message) {}
}
