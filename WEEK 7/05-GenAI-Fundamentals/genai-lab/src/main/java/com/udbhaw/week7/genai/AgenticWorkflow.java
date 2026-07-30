package com.udbhaw.week7.genai;

import java.util.ArrayList;
import java.util.List;

public final class AgenticWorkflow {
    private final LanguageModelClient client;
    private final SafetyGuard guard;

    public AgenticWorkflow(LanguageModelClient client, SafetyGuard guard) {
        this.client = client;
        this.guard = guard;
    }

    public AgentResult execute(String userGoal, String context) {
        List<String> trace = new ArrayList<>();
        trace.add("PLAN: break the goal into a study-plan generation task");
        SafetyGuard.ValidationResult input = guard.validateInput(userGoal + "\n" + context);
        if (!input.valid()) return new AgentResult(false, input.message(), trace);
        trace.add("RETRIEVE: use the bounded context supplied by ContextBuilder");

        PromptTemplate template = new PromptTemplate(
                "You are a careful Java FSE learning assistant.",
                userGoal,
                List.of("Use only supplied context", "State assumptions", "Keep the answer actionable"),
                "A numbered three-step plan"
        );
        trace.add("GENERATE: call the language model client");
        String output = client.generate(template.render(context));
        SafetyGuard.ValidationResult validation = guard.validateOutput(output);
        trace.add("VALIDATE: " + validation.message());
        if (!validation.valid()) {
            trace.add("REVISE: ask the model for a more complete response");
            output = client.generate(template.render(context) + "\nThe previous response was incomplete. Expand it.");
            validation = guard.validateOutput(output);
        }
        return new AgentResult(validation.valid(), output, trace);
    }

    public record AgentResult(boolean success, String output, List<String> trace) {
        public AgentResult { trace = List.copyOf(trace); }
    }
}
