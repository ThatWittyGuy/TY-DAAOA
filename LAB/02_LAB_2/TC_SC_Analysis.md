### **Time Complexity Analysis**

Both iterative and recursive binary search approaches **have the same time complexity**:

- **Best case:**  
  The element is at the middle index, found in one comparison: **O(1)**[1][2][3][5][6].
- **Average/Worst case:**  
  The search space is halved at each step, leading to **O(log n)** time complexity. This holds whether or not the element is present, as binary search may repeat the halving up to $$ \log_2 n $$ times[1][2][3][5][6].

| Case           | Time Complexity | Explanation                                                                             |
|:---------------|:---------------|:----------------------------------------------------------------------------------------|
| Best           | O(1)           | First comparison finds the element at center                                            |
| Average/Worst  | O(log n)       | Each step halves the array; max $$\log_2 n$$ steps required                            |

### **Space Complexity Comparison**

| Approach        | Space Complexity | Explanation                                                                                            |
|:--------------- |:----------------|:-------------------------------------------------------------------------------------------------------|
| Iterative       | O(1)             | Uses a constant number of variables (low, high, mid), regardless of input size[1][2][5][7].           |
| Recursive       | O(log n)         | Each recursive call adds a new frame to the function call stack; up to $$\log_2 n$$ calls may be made[2][5]. |

- **Iterative:**  
  - Only a few variables are used and no extra stack frames are created. The amount of memory required does **not** increase with input size[1][2][3][5][7].
- **Recursive:**  
  - Each recursive call waits for the next, so the call stack grows, with maximum depth up to $$ \log_2 n $$ in the worst case. Each stack frame consumes memory, leading to **O(log n)** space requirement[2][5].

> **Summary:**  
> - Both iterative and recursive binary search have **O(1) best-case time** and **O(log n) average/worst-case time**.  
> - **Iterative binary search** uses **O(1)** space; **recursive binary search** uses **O(log n)** space due to stack calls[2][5].

