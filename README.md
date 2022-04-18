# Scaler

## Some of the observation need to noted when you are solving a problem.

### If input array is sorted/rotated/max/min[cow problem] then
  ```  
    - Binary Search
    - Two Pointer
  ```
### if asked for all permutation/subset then
  ```
     - Backtracking
  ```   
### if given a tree then
  ```
     - BSF
     - DFS
     - inOrder
     - preOrder 
     - postOrder
     - stack
     - queue
  ```

### if given a BST tree
  ```
     -inOrder [This will give a sorted array]
  ```
     
### if given a graph then
  ```
    -DFS
    -BFS
  ```  

### if given a linked list
  ```
    -Two pointers [slow and fast]
    -mergesort logic
  ```

### if recursion is banned then
  ```
   - stack
   - master Therom T(N) = a * T(n/b) + O( n^d)
  ```

### if must solve in-place then
  ```
   - swap corresponding value
   - store or more different values in the same pointer 
   - A[i] = A[i] + (A[A[i]] %N) *N 
  ```

### if asked for max/ min subarray/subset
  ``` 
   - Dynamic Programming  
   - prefix {pref[i] = pref[i - 1] + A.get(i)}
   - subarray = n*(n+1)/2 
   - subset = n^2
   - sum of all - contribution of ith element {a[i] * no of elements it appears to array}
           Start of point - (i + 1)
           End of point   - (n -i)
   - Kadane's Algo        
  ```            

### if asked for common string then
   ```
   - Map
   - Tries
   ``` 

## then
```
    - Map/Set for TC O(1) and SC O(N)
    - Sort input for TC O(nlogn) and SC(N)
```    
    
### if same diff between two number in array
```
    - A.P - n/2[2a + (n-1)d] 
           n - number of items
           a - first iterms
           d - common diff    
```
    
### if Geometric Progression
```
    - a(r^n -1)/r - 1
```
    
### if Subsequence - means non-continuous but maintain order
```
    - 2^n - total subseq  
```
    
### Bits
   ```
   - n & 1 = 1 [odd] / 0 [even]
   - n ^ 0 = n
   - n ^ n = 0
   - n ^ n ^ y = y
   - N&(N-1) = power of 2
   - A ^= 1<<i - toggle a bit
  ```

### Mod
   ```
   if you need to store data  within a range always for given input - %
   ```
### To calculate large power
```
    Fast Power Function
    Fermat's theorem  
```

### Tree
```
    https://www.scaler.com/topics/data-structures/binary-tree-in-data-structure/
    https://www.scaler.com/topics/data-structures/tree-data-structure/
```

### Common time complexities

```
    Let n be the main variable in the problem.

• If n ≤ 12, the time complexity can be O(n!).

• If n ≤ 25, the time complexity can be 0(2").

• If n ≤ 100, the time complexity can be O(n^).

• If n ≤ 500, the time complexity can be 0(n³). • If n ≤ 104, the time complexity can be O(n²).

• If n ≤ 106, the time complexity can be O(n log n).

• If n ≤ 108, the time complexity can be O(n).

• If n > 108, the time complexity can be O(log n) or 0(1).

Examples of each common time complexity

• O(n!) [Factorial time]: Permutations of 1 ... n

• O(2¹) [Exponential time]: Exhaust all subsets of an array of size n

• O(n³) [Cubic time]: Exhaust all triangles with side length less than n

• O(n²) [Quadratic time]: Slow comparison-based sorting (eg. Bubble Sort, Insertion Sort, Selection Sort)

• O(n log n) [Linearithmic time]: Fast comparison-based sorting (eg. Merge Sort)

• O(n) [Linear time]: Linear Search (Finding maximum/minimum element in a 1D array), Counting Sort

• O(log n) [Logarithmic time]: Binary Search, finding GCD (Greatest Common Divisor) using Euclidean Algorithm

• 0(1) [Constant time]: Calculation (eg. Solving linear equations in one

unknown)

```

### 14 Patterns to Ace Any Coding Interview Question

https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed