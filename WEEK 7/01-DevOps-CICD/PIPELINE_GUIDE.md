# CI/CD Pipeline Guide
The Week 7 pipeline performs the following stages:
1. Checkout source code.
2. Configure Java 17.
3. Compile and test the Java task service.
4. Compile and test the GenAI lab.
5. Build the Docker image.
6. Scan the source tree for accidentally committed secrets.

The workflow supplied in `week7-ci.yml` must be copied to the main repository root:

```text
<repository>/.github/workflows/week7-ci.yml
```

A workflow nested inside `WEEK 7/.github/workflows` is documentation only and will not be detected by GitHub Actions.

## CI/CD Tool Comparison
| Tool | Best fit | Pipeline file |
|---|---|---|
| GitHub Actions | GitHub-native automation | YAML workflow |
| Jenkins | Self-hosted and highly customizable | Jenkinsfile |
| GitLab CI/CD | GitLab-native pipelines | `.gitlab-ci.yml` |
| Azure DevOps | Microsoft enterprise ecosystem | `azure-pipelines.yml` |
