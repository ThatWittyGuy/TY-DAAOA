#include <iostream>
using namespace std;

int binarySearch(int arr[], int low, int high, int key) {
    if (low > high) 
        return -1;
    int mid = low + (high - low) / 2;
    if (arr[mid] == key) 
        return mid;
    if (arr[mid] < key) 
        return binarySearch(arr, mid + 1, high, key);
    return binarySearch(arr, low, mid - 1, key);
}

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    int* arr = new int[n];
    cout << "Enter sorted array elements: ";
    for (int i = 0; i < n; i++) 
        cin >> arr[i];
    int key;
    cout << "Enter element to search: ";
    cin >> key;
    int result = binarySearch(arr, 0, n - 1, key);
    if (result == -1) 
        cout << "Element not found\n";
    else 
        cout << "Element found at index: " << result << "\n";
    delete[] arr;
    return 0;
}
