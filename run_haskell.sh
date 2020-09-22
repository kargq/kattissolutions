set -e
mkdir -p hout
ghc $1 -o hout/prog.o
cat $2 | ./hout/prog.o > output.txt