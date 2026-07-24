# CI/CD Guide

The workflow at `.github/workflows/react-ci.yml` runs on every push and pull request.

It performs:

1. Repository checkout
2. Node.js 20 setup
3. Root npm workspace installation
4. Production builds for all 19 React applications
5. Unit tests for HOL 18 and HOL 19

Open the repository's **Actions** tab after pushing to GitHub to see the result.
