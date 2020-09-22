set -e
current_dir=$PWD
javac $1 -d out/
cd out
cat ../$2 | java Solution > ../output.txt
cd $current_dir;