#include <iostream>
#include <math.h>
#include <limits>

using namespace std;
int grads = 8000000;

double f(double a, double b, double x)
{
  return a * pow(M_E, -pow(x, 2)) + b * sqrt(x);
}

double vol(double a, double b, double h)
{
  double height = h / (double)grads;

  double res = 0.0;

  for (int i = 0; i < grads; i++)
  {
    double x = i * height + (height / 2.0);
    double r = f(a, b, x);
    r = pow(r, 2);
    // if (i != 0 && i != grads - 1)
    // {
    //   if (i % 2 == 0)
    //   {
    //     r *= 2;
    //   }
    //   else
    //   {
    //     r *= 4;
    //   }
    // }
    res += r;
  }

  return  height * M_PI * res;
}

int main()
{
  int N;
  double V;

  cin >> V;
  cin >> N;

  int min = 0;
  double min_diff = numeric_limits<double>::max();

  for (int i = 0; i < N; i++)
  {
    double a, b, h;

    cin >> a;
    cin >> b;
    cin >> h;

    double cv = vol(a, b, h);
    // cout << cv << endl;

    double diff = abs(cv - V);

    if (diff < min_diff)
    {
      min_diff = diff;
      min = i;
    }
  }

  cout << min << endl;

  return 0;
}