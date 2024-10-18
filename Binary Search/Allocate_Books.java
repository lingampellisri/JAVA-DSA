/*
Problem statement
Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.



There are ‘m’ number of students, and the task is to allocate all the books to the students.



Allocate books in such a way that:

1. Each student gets at least one book.
2. Each book should be allocated to only one student.
3. Book allocation should be in a contiguous manner.


You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.



If the allocation of books is not possible, return -1.



Example:
Input: ‘n’ = 4 ‘m’ = 2 
‘arr’ = [12, 34, 67, 90]

Output: 113

Explanation: All possible ways to allocate the ‘4’ books to '2' students are:

12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.

12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.

12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.

We are getting the minimum in the last case.

Hence answer is ‘113’.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 2
12 34 67 90
Sample Output 1:
113
Explanation of sample input 1:
All possible ways to allocate the ‘4’ books to '2' students are:

12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.

12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.

12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.

We are getting the minimum in the last case.

Hence answer is ‘113’.
Sample Input 2:
5 4
25 46 28 49 24
Sample Output 2:
71
Explanation of sample input 2:
All possible ways to allocate the ‘5’ books to '4' students are:

25 | 46 | 28 | 49 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '28', and '73'. So the maximum is '73'.

25 | 46 | 28 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '77', and '24'. So the maximum is '77'.

25 | 46 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '74', '49', and '24'. So the maximum is '74'.

25 46 | 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '71', '28', '49', and '24'. So the maximum is '71'.

We are getting the minimum in the last case.

Hence answer is ‘71’.
Expected time complexity:
The expected time complexity is O(n * log(s)), where ‘n’ is the number of integers in the array ‘arr’ and ‘s’ is the sum of all the elements of ‘arr’.
Constraints:
2 <= 'n' <= 10 ^ 3
1 <= 'm' <= 10 ^ 3
1 <= 'arr[i]' <= 10 ^ 9
The sum of all arr[i] does not exceed 10 ^ 9.

Where ‘n’ denotes the number of books and ‘m’ denotes the number of students. ‘arr[i]’ denotes an element at position ‘i’ in the sequence.

Time limit: 1 second
*/


********************************Brute Force Solution****************************
  import java.util.ArrayList;
public class Solution {

    public static int allocateBooks(ArrayList<Integer> arr,int pages)
    {
            int students=1;
            int pageStudents=0;

            for(int i=0;i<arr.size();i++)
            {
                if(pageStudents+arr.get(i)<=pages)
                {
                    pageStudents=pageStudents+arr.get(i);
                }
                else{
                    pageStudents=arr.get(i);
                    students++;
                }
            }
            return students;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        int max=Integer.MIN_VALUE;
        int sum=0;


        for(int i=0;i<arr.size();i++)
        {
            sum=sum+arr.get(i);
            if(arr.get(i)>max)
            {
                max=arr.get(i);
            }
        }
        if(m==1)
        {
            return sum;

        }
        if(m>n)
        {
            return -1;
        }

        // System.out.println(max);
        // System.out.println(sum);

        for(int i=max;i<=sum;i++)
        {
                if(allocateBooks(arr,i)==m)
                {
                    return i;
                }
        }
        
        return -1;

    }
}

Time complexity : O(max-sum)*O(n);
Space COmplexity : O(1);



********************************Optimal Solution****************************

  import java.util.ArrayList;
public class Solution {

    public static int allocateBooks(ArrayList<Integer> arr,int pages)
    {
            int students=1;
            int pageStudents=0;

            for(int i=0;i<arr.size();i++)
            {
                if(pageStudents+arr.get(i)<=pages)
                {
                    pageStudents=pageStudents+arr.get(i);
                }
                else{
                    pageStudents=arr.get(i);
                    students++;
                }
            }
            return students;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        int max=Integer.MIN_VALUE;
        int sum=0;


        for(int i=0;i<arr.size();i++)
        {
            sum=sum+arr.get(i);
            if(arr.get(i)>max)
            {
                max=arr.get(i);
            }
        }
        if(m==1)
        {
            return sum;

        }
        if(m>n)
        {
            return -1;
        }

        // System.out.println(max);
        // System.out.println(sum);

        int left=max;
        int right=sum;
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;

            if(allocateBooks(arr,mid)<=m)
            {
                ans=mid;
                right=mid-1;

            }
            else{
                left=mid+1;
            }

        }
        
        return ans;

    }
}


Time Complexity :  O(n * log(sum - max))
Space Complexity : O(1)
