# HOL 2: Git ignore

Run each command in Git Bash. Replace `<repository-url>` with your own GitHub repository URL.

```bash
echo "*.log" >> .gitignore
echo "log/" >> .gitignore
mkdir -p log
echo "debug" > application.log
git status
git add .gitignore
git commit -m "Add gitignore rules"
```
