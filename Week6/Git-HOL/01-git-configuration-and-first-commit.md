# HOL 1: Git configuration and first commit

Run each command in Git Bash. Replace `<repository-url>` with your own GitHub repository URL.

```bash
git --version
git config --global user.name "Udbhaw Anuj"
git config --global user.email "udbhawanuj53@gmail.com"
mkdir GitDemo && cd GitDemo
git init
echo "Welcome to Git Hands-on" > welcome.txt
git add welcome.txt
git commit -m "Add welcome file"
git remote add origin <repository-url>
git push -u origin main
```
