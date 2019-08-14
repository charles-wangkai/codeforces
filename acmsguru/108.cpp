#include <iostream>
#include <vector>
using namespace std;

int computeDigitSum(int x)
{
    int result = 0;
    while (x != 0)
    {
        result += x % 10;
        x /= 10;
    }

    return result;
}

int main()
{
    int N;
    int K;
    cin >> N >> K;

    int *s = new int[K];
    for (int i = 0; i < K; i++)
    {
        cin >> s[i];
    }

    bool *isSelfs = new bool[N + 1];
    for (int i = 1; i <= N; i++)
    {
        isSelfs[i] = true;
    }
    for (int i = 1; i <= N; i++)
    {
        int nonSelf = i + computeDigitSum(i);
        if (nonSelf <= N)
        {
            isSelfs[nonSelf] = false;
        }
    }

    vector<int> selfs;
    for (int i = 1; i <= N; i++)
    {
        if (isSelfs[i])
        {
            selfs.push_back(i);
        }
    }

    cout << selfs.size() << endl;

    for (int i = 0; i < K; i++)
    {
        if (i != 0)
        {
            cout << " ";
        }

        cout << selfs[s[i] - 1];
    }

    return 0;
}
