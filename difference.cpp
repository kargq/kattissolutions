#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

int main()
{
  int a, m;

  cin >> a;
  cin >> m;

  vector<int> nums;
  nums.reserve(10000);

  vector<bool> found;
  found.reserve(m + 1);

  nums.push_back(a);

  int unfound = 1;

  if (a <= m)
  {
    found[a] = true;
  }

  while (!found[m])
  {
    while (found[unfound])
    {
      unfound++;
    }

    int next = nums[nums.size() - 1] + unfound;

    // cout << next << endl;

    if (next <= m)
    {
      found[next] = true;
    }

    nums.push_back(next);

    for (int num : nums)
    {
      int diff = abs(num - next);
      if (diff <= m)
      {
        found[diff] = true;
      }
    }
  }

  cout << nums.size() << endl;
}