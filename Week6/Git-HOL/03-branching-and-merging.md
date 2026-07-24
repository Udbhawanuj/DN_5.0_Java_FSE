# HOL 3: Branching and merging

Run each command in Git Bash. Replace `<repository-url>` with your own GitHub repository URL.

```bash
git switch -c GitNewBranch
echo "Branch content" > branch.txt
git add branch.txt
git commit -m "Add branch content"
git switch main
git diff main..GitNewBranch
git merge GitNewBranch
git log --oneline --graph --decorate --all
git branch -d GitNewBranch
```
