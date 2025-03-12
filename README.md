Insertion Sort
  - Insertion sort is a simple sorting algorithm that builds the final sorted array one element at a time by using comparisons
  - iteratively inserting each element of an unsorted list into its correct position
    - Start w/ the 2nd element of array b/c first element is assumed to be sorted
    - compare 2nd element w/ the first element and check if the second element is smaller
      -if so swap them
    - move to third element and compare it w/ first two and place it correctly
    - repeat until array is sorted
 - Pros
   - efficent for small data sets
   - simple and easy to use/implement
   - stable sorting algorithm
 - Cons
   -  It is much less efficient on large lists than more advanced algorithms such as quicksort and merge sort
   -  
 - Big O Notation
   - O(n²)

 - Pseudo Code
    - Step 1: Iterate through the deck starting from the second card (index 1).
    - Step 2: For each card, determine its correct position in the sorted portion of the deck.
    - Step 3: Shift all larger cards one position to the right to make space.
    - Step 4: Insert the current card into its correct position.
    - Step 5: Repeat until the entire deck is sorted
   Bubble Sort
- Repeadetly swaps the adjacent elements if they are in the wrong order.
- Not suitable for large data sets and worst case time complexity are quite high
- Sort the array using multiple passes. After the first pass the maximum element goes to the end. So on and so forth.
- In every pass only elements that haven't been sorted get moved
  Pros
- Easy to understand and implement
- Doesn't require additional memory
- Stable algorithim
  Cons
- Very slow for large data sets
- No or limited real world application. 
   

  
   

  
