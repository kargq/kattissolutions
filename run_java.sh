set -e
current_dir=$PWD
javac $1 -d out/
cd out
java Solution
cd $current_dir;