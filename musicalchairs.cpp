#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<vector<int> > profs;
    profs.reserve(n);

    for (int i = 0; i < n; i++)
    {
        int n;
        cin >> n;
        vector<int> pairNotPair;
        pairNotPair.reserve(2);
        pairNotPair.push_back(n);
        pairNotPair.push_back(i);
        profs.push_back(pairNotPair);
    }

    int startIndex = 0;

    for (int i = 0; i < n - 1; i++)
    {
        // n - 1 eliminations
        int opus = profs[startIndex][0];
        int removeIndex = (startIndex + opus + (profs.size() - 1)) % profs.size();
        profs.erase(profs.begin() + removeIndex);
        startIndex = removeIndex % profs.size();
    }

    cout << profs[0][1] + 1 << endl;

    return 0;
}