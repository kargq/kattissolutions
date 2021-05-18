#include <iostream>
#include <vector>

using namespace std;

void printArr(int *arr, int n)
{
  cout << "[";
  for (int i = 0; i < n; i++)
  {
    cout << arr[i];
    cout << ", ";
  }
  cout << "]" << endl;
}

int min(int a, int b)
{
  return a < b ? a : b;
}

int max(int a, int b)
{
  return a > b ? a : b;
}

int main()
{
  int s, p, m, n;
  cin >> s;
  cin >> p;
  cin >> m;
  cin >> n;

  vector<int> ts;

  ts.reserve(n);

  for (int i = 0; i < n; i++)
  {
    int read;
    cin >> read;
    ts.push_back(read);
  }

  int *prices;
  prices = new int[n];

  for (int i = 0; i < n; i++)
  {
    // printArr(prices, n);
    // Decide if to buy pass up to i or not
    int start = i;

    while (start >= 0 && ts[i] - ts[start] < m)
    {
      start--;
    }

    start++;

    // start = max(0, start);
    // start = min(i, start);
    // cout << i - 1 << endl;
    
    int wo;

    if (i > 0) {
      wo = prices[i - 1] + s;
    } else {
      wo = s;
    }

    int with = wo;

    if (start > 0)
    {
      with = prices[start - 1] + p;
    } else {
      with = p;
    }

    // cout << start << endl;
    // cout << i << endl;
    // cout << wo << endl;
    // cout << with << endl;

    prices[i] = min(wo, with);
  }

  cout << prices[n - 1] << endl;

  return 0;
}