#include <iostream>
using namespace std;

class Array {
    int n;
    int* arr;
public:
    void init(int size) {
        n = size;
        arr = new int[n];
    }
    int* getArray() {
        return arr;
    }
    int binsearch(int key) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) 
                return m;
            if (arr[m] < key) 
                l = m + 1;
            else 
                r = m - 1;
        }
        return -1;
    }
    int size() {
        return n;
    }
    ~Array() {
        delete[] arr;
    }
};

int main() {
    int n, key;
    cout << "Enter size of array: ";
    cin >> n;
    Array a;
    a.init(n);
    int* ar = a.getArray();
    cout << "Enter sorted array elements: ";
    for (int i = 0; i < n; i++) cin >> ar[i];
    cout << "Enter element to search: ";
    cin >> key;
    int res = a.binsearch(key);
    if (res == -1) cout << "Element not found" << endl;
    else cout << "Element found at index: " << res << endl;
    return 0;
}
