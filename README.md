# Java-Algo-DS
Practicing Algo-DS in Java

Many of these java programs use StdIn (and StdOut is used some places but SrdIn is dependent on StdOut as well). So keep StdIn and StdOut java files in same directory.

### Files on root Folder:
   
   ##### java Files:
    - Data structure Stack of <item>s : can be used with generic type -- file as input (test.txt for test client)
    - Data structure Queue of <Item>s : can be used with generic type -- file as input (test.txt for test clien
    - BinarySearch for int value with whitelist filter example (limited scope) -- one argument is number to search and input file (whitelistnums.txt for test)
    - PairtoSum : finding pair to sum to given number (arguments needed - desired sum for given test array.). 
          Can comment line 49 and remove comments from line 38-47 to work with randoms (two args - desired sum and length of random array)
    - WeightedQuickUnionUF : UF with wighted strategy. input file example union.txt

  ##### txt Files:
    - test.txt ==> for Stack and Queue java programs
    - union.txt ==> for WeightedQuickUnionUF.java as input
    - whitelistnums.txt ==> for testing Binary Search java program

 
 
 
### Files on Folder "Sorting" under root: 
   
   ##### java Files:
    note: Need StdIn and StdOut in same directory 
    - SelectionSort
    - InsertionSort
    - ShellSort
    - MergeSort
    - AllSorts - to compare timing sorts from above for same input file (Note: MergeSort file will be required to be in same directory)

   ##### txt Files:
    - words.txt: small 9 words file
    - characters.txt: small 11 characters file
    - 10000words.txt: large 10000 words file with 1000 unique words repeated 10 times (to get ms level timing)
