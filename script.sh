export GIT_STATUS=`git status -s | grep ' M ' | grep -c --file=class.lst | head -1`;
if [ $GIT_STATUS = 0 ]; then
 git commit -m'commit';
else
  echo 'Какой-то файл из списка class.lst был изменен!'
fi;
