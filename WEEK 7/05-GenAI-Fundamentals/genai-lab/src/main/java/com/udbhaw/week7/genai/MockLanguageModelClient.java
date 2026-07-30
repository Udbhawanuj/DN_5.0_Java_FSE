package com.udbhaw.week7.genai;

public final class MockLanguageModelClient implements LanguageModelClient {
    @Override
    public String generate(String prompt) {
        boolean docker = prompt.toLowerCase().contains("docker");
        return "Generated study plan:\n" +
                "1. Review the supplied context and identify the required outcome.\n" +
                "2. Implement one small verifiable example" + (docker ? " using a Docker image and health check" : "") + ".\n" +
                "3. Run validation, document assumptions, and retain human review before submission.";
    }
}
