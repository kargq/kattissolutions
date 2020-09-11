set -e
current_dir=$PWD
javac $1 -d out/
cd out
cat ../$2 | java Solution
cd $current_dir;