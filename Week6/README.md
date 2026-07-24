# Week 6 – React, Git, Application Debugging and CI/CD

**Candidate:** Udbhaw Anuj  
**Track:** Cognizant Digital Nurture 5.0 – Java FSE

This repository contains all **19 React hands-on exercises**, all **5 Git hands-on exercises**, application-debugging notes/configuration and a GitHub Actions CI pipeline.

## Run from the root folder

```bash
npm install
npm start
```

`npm start` opens HOL 1. To run a specific hands-on (1–19):

```bash
npm run hol -- 6
```

The application normally opens at `http://localhost:5173`.

## Verify the complete submission

```bash
npm run verify
```

This builds all 19 applications and runs the automated tests for HOL 18 and HOL 19.

## Run one application independently

```bash
cd React-HOL/06-trainersapp
npm install
npm start
```

## Important folders
- `React-HOL/` – React hands-on 1 through 19.
- `Git-HOL/` – Git configuration, ignore rules, branching, merging, conflicts, pull and push.
- `Application-Debugging/` – Chrome DevTools and VS Code debugging steps.
- `.github/workflows/react-ci.yml` – CI pipeline for install, builds and tests.
- `COMPLETION_MATRIX.md` – full coverage checklist.

The projects use Vite with React 18 for a stable, quick setup while implementing the outcomes in the supplied Cognizant hands-on documents.
