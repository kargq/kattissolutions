#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

long n, m, a, c, x0;

vector<long> seq;

long total_vals;

void generate_seq() {
    seq.reserve(n);
    long prev = x0;

    for(long i = 0; i < n; i++) {
        seq[i] = (((a % m) * (prev % m)) + (c % m)) % m;
        prev = seq[i];
    }
}

void prlong_seq() {
    std::cout << "\n";
    for(long i = 0; i < n; i++) {
        std::cout << seq[i] << " ";
    }
    std::cout << "\n";
}

void binary_search(long lo, long hi, long rmin, long rmax) {
 // cout << lo << " " << hi << " " << rmin << " " << rmax << endl;
    long mid = (lo + hi) / 2;
    if(lo > hi) return;
    // cout << (rmin < seq[mid]) << " " << (seq[mid] < rmax) << endl;    
    if(rmin < seq[mid] && seq[mid] < rmax) {
        // cout << "midval " << seq[mid] << endl;
        total_vals++;
    }
        binary_search(lo, mid -1, rmin, min(seq[mid], rmax));
        binary_search(mid + 1, hi, max(rmin, seq[mid]), rmax);
}

int main() {
    // turn off sync for iostreams
    ios_base::sync_with_stdio(false);
    // flushing cout off
    cin.tie(NULL);

    cin >> n;
    cin >> m;
    cin >> a;
    cin >> c;
    cin >> x0;
    
    generate_seq();
    // prlong_seq();
    
    binary_search(0, n-1, -1, 2147483648);

    cout << total_vals;

    return 0;
}
