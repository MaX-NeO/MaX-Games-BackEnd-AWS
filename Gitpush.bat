@echo off
set /p commit_message="Enter commit message: "

git pull
git add .
git commit -m "%commit_message%"
git push origin master

echo Commit to master branch complete.
pause
