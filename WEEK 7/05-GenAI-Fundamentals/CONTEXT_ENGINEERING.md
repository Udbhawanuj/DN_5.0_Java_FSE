# Context Engineering

Context engineering is the design of the full information environment supplied to an AI system. It includes system rules, user request, retrieved documents, conversation state, tool results, memory and output schemas.

## Good Context Practices

- include only relevant information
- label trusted and untrusted content
- state precedence rules
- remove secrets and unnecessary personal data
- cite the source and freshness of retrieved facts
- fit within the model context limit
- validate tool output before reuse

The Java lab includes a `ContextBuilder` that selects the most recent context items within a character budget.
