# You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

# Note: The answer should be returned in an increasing format.

# Examples:

# Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
# Output: [5, 6]
# Explanation: 5 and 6 occur more n/3 times.
# Input: arr[] = [1, 2, 3, 4, 5]
# Output: []
# Explanation: no candidate occur more than n/3 times.
# Constraint:
# 1 <= arr.size() <= 106
# -109 <= arr[i] <= 109

class Solution:
    def findMajority(self, arr):
        count = {}
        res = []
        
        for i in arr:
            if i in count: 
                count[i] += 1          
            else : 
                count[i] = 1
        
        for i in count:
            if count[i] > len(arr) // 3:
                    res.append(i)
    
        return sorted(res)

class Solution:
    # Function to find the majority elements in the array
    def findMajority(self, arr):
        num1, num2, count1, count2 = 0, 0, 0, 0
        res = []
        
        for i in arr:
            if i == num1:
                count1 += 1
            elif i == num2:
                count2 += 1
            elif count1 == 0:
                num1 = i
                count1 += 1
            elif count2 == 0:
                num2 = i
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1
        
        count1, count2 = 0, 0
        
        for i in arr:
            if num1 == i:
                count1 += 1
            elif num2 == i:
                count2 += 1
        
        if count1 > len(arr) // 3:
            res.append(num1)
        if count2 > len(arr) // 3:
            res.append(num2)
        
        return sorted(res)  