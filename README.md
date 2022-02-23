# Scaler

##Some of the observation need to noted when you are solving a problem.

###If input array is sorted/rotated/max/min[cow problem] then
  ```  
    - Binary Search
    - Two Pointer
  ```
###if asked for all permutation/subset then
  ```
     - Backtracking
  ```   
###if given a tree then
  ```
     - BSF
     - DFS
     - inOrder
     - preOrder 
     - postOrder
     - stack
     - queue
  ```

###if given a BST tree
  ```
     -inOrder [This will give a sorted array]
  ```
     
###if given a graph then
  ```
    -DFS
    -BFS
  ```  

###if given a linked list
  ```
    -Two pointers [slow and fast]
    -mergesort logic
  ```

###if recursion is banned then
  ```
   - stack
   - master Therom T(N) = a * T(n/b) + O( n^d)
  ```

###if must solve in-place then
  ```
   - swap corresponding value
   - store or more different values in the same pointer 
   - A[i] = A[i] + (A[A[i]] %N) *N 
  ```

###if asked for max/ min subarray/subset
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

###if asked for common string then
   ```
   - Map
   - Tries
   ``` 

##then
```
    - Map/Set for TC O(1) and SC O(N)
    - Sort input for TC O(nlogn) and SC(N)
```    
    
###if same diff between two number in array
```
    - A.P - n/2[2a + (n-1)d] 
           n - number of items
           a - first iterms
           d - common diff    
```
    
###if Geometric Progression
```
    - a(r^n -1)/r - 1
```
    
###if Subsequence - means non-continuous but maintain order
```
    - 2^n - total subseq  
```
    
###Bits
   ```
   - n & 1 = 1 [odd] / 0 [even]
   - n ^ 0 = n
   - n ^ n = 0
   - n ^ n ^ y = y
   - N&(N-1) = power of 2
   - A ^= 1<<i - toggle a bit
  ```

###Mod
   ```
   if you need to store data  with a range always for given input - %
   ```