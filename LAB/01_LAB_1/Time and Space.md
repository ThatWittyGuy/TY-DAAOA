Here is a detailed time and space complexity analysis for the **Bubble Sort** and **Quick Sort** implementations in the provided Java code:

### Bubble Sort Complexity

**Time Complexity:**

- **Best Case: O(n)**  
  When the array is already sorted, the algorithm still performs one full pass with $$n-1$$ comparisons but no swaps. If optimized with a swapped flag (not in your code), it can terminate early. Without optimization, it still does all passes, but theoretically best case is linear if optimized.  
- **Average Case: O(n²)**  
  On average, the algorithm performs about $$n(n-1)/2$$ comparisons and swaps because elements need to be bubbled through multiple passes.  
- **Worst Case: O(n²)**  
  When the array is sorted in reverse order, every adjacent pair is swapped in each pass, resulting in the maximum number of comparisons and swaps. The outer loop runs $$n-1$$ times and the inner loop decreases from $$n-1$$ to 1, totaling roughly $$n^2/2$$ operations.  

**Space Complexity:**

- **O(1)** (Constant space)  
  Bubble sort is an in-place sorting algorithm that only requires a few extra variables for swapping and indexing. It does not need additional arrays or data structures regardless of input size[1][2][4][5][6][7].

### Quick Sort Complexity

**Time Complexity:**

- **Best Case: O(n log n)**  
  Occurs when the pivot divides the array into two nearly equal halves every time, resulting in a balanced recursion tree of height $$\log n$$ and $$n$$ operations per level.  
- **Average Case: O(n log n)**  
  For a random pivot or average input, the partitioning tends to split reasonably evenly, leading to the same behavior as the best case on average.  
- **Worst Case: O(n²)**  
  Happens when the pivot is consistently the smallest or largest element (e.g., already sorted or reverse sorted array without random pivot selection), causing highly unbalanced partitions and recursion depth of $$n$$.  

**Space Complexity:**

- **O(log n)** on average due to recursion stack in balanced partitions.  
- **O(n)** in the worst case due to recursion stack depth when partitions are highly unbalanced.  
- Quick sort is an in-place algorithm with no significant extra array storage, but recursion stack space depends on partitioning[5][10].

### Summary Table

| Algorithm   | Best Case Time | Average Case Time | Worst Case Time | Space Complexity      |
|-------------|----------------|-------------------|-----------------|----------------------|
| Bubble Sort | O(n)           | O(n²)             | O(n²)           | O(1) (in-place)      |
| Quick Sort  | O(n log n)     | O(n log n)        | O(n²)           | O(log n) average, O(n) worst (recursion stack) |

### Additional Notes

- Your Bubble Sort implementation does not include an early termination optimization, so best case is practically still $$O(n^2)$$ in your code, but theoretically it can be $$O(n)$$ if optimized.
- Quick Sort’s performance heavily depends on pivot choice. Your code uses the last element as pivot, which can degrade performance on sorted or nearly sorted inputs.
- Both algorithms sort in-place, so no extra arrays are needed beyond the input array and a few variables.

This analysis aligns with standard algorithmic theory and references from GeeksforGeeks, BuiltIn, Simplilearn, and other authoritative sources[1][2][4][5][6][7][10].

[1] https://www.geeksforgeeks.org/dsa/time-and-space-complexity-analysis-of-bubble-sort/
[2] https://builtin.com/data-science/bubble-sort-time-complexity
[3] https://www.simplilearn.com/tutorials/data-structure-tutorial/bubble-sort-algorithm
[4] https://programiz.pro/resources/dsa-bubble-sort-complexity/
[5] https://www.codecademy.com/article/time-complexity-of-bubble-sort
[6] https://iq.opengenus.org/time-space-complexity-bubble-sort/
[7] https://www.w3schools.com/dsa/dsa_timecomplexity_bblsort.php
[8] https://www.geeksforgeeks.org/bubble-sort-algorithm/
[9] https://en.wikipedia.org/wiki/Bubble_sort
[10] https://www.wscubetech.com/resources/dsa/time-space-complexity-sorting-algorithms