set -e
mkdir -p cout
g++ $1 -o cout/a.out
cat $2 | ./cout/a.out