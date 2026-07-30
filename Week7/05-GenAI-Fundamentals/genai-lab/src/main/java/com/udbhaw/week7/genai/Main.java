package com.udbhaw.week7.genai;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        ContextBuilder context = new ContextBuilder(800)
                .add("Week 7 plan", "Topics include DevOps, CI/CD, Docker, Agile, AWS cloud services, prompt engineering and agentic AI.")
                .add("Student progress", "The Java task service and Docker Compose files are already available for practical work.");

        AgenticWorkflow workflow = new AgenticWorkflow(new MockLanguageModelClient(), new SafetyGuard());
        AgenticWorkflow.AgentResult result = workflow.execute(
                "Create a safe practical revision plan for Docker and CI/CD.",
                context.build()
        );

        System.out.println("=== AGENT TRACE ===");
        result.trace().forEach(System.out::println);
        System.out.println("\n=== FINAL OUTPUT ===");
        System.out.println(result.output());
        System.out.println("\nSuccess: " + result.success());
    }
}
