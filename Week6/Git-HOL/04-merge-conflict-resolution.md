# HOL 4: Merge conflict resolution

Run each command in Git Bash. Replace `<repository-url>` with your own GitHub repository URL.

```bash
git switch -c GitWork
echo "Content from GitWork" > hello.xml
git add hello.xml && git commit -m "Add hello.xml in GitWork"
git switch main
echo "Different content from main" > hello.xml
git add hello.xml && git commit -m "Add hello.xml in main"
git merge GitWork
# Open hello.xml, remove conflict markers, keep desired content
git add hello.xml
git commit -m "Resolve hello.xml merge conflict"
git branch -d GitWork
```
