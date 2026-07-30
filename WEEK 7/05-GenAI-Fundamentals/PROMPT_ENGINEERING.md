# Prompt Engineering

A strong developer prompt normally contains:

1. Role or system instruction
2. Goal
3. Relevant context
4. Constraints
5. Examples when needed
6. Required output format
7. Quality and safety checks

## Techniques

- zero-shot prompting
- few-shot prompting
- role prompting
- decomposition into smaller tasks
- structured output requests
- self-check or critique prompts
- grounding with supplied context

## Example

```text
Role: You are a Java code reviewer.
Task: Review the supplied method for correctness and security.
Constraints: Do not invent missing code. Explain uncertainty.
Output: Return JSON with issues, severity and suggested fix.
Context: <method and project rules>
```
