from os import listdir
from os.path import isfile, join

header =""" \
# leetcode-kotlin
LeetCode Algorithm Practice
            
## Problem Solved
\#  | name | link
------------- | ------------- | -------------
"""

class Solution:
    def __init__(self, problem_number, problem_name):
        self.problem_number = problem_number
        self.problem_name = problem_name
    def toReadMeLine(self):
        return self.problem_number + " | " + self.problem_name + " | " + "https://leetcode.com/problems/" + self.problem_name + "\n"

solution_files = [f for f in listdir("src/main/kotlin/solution/") if f[0:3]=="Sol"]

solutions = []
for solution_file in solution_files:
    split = solution_file.split(".")[0].split("_")
    problem_number = split[1]
    problem_name = "-".join(split[2:])
    solutions.append(Solution(problem_number, problem_name))
    

solutions.sort(key=lambda solution: int(solution.problem_number))

readme = open("README.md", "w")
readme.write(header)

for solution in solutions:
    readme.write(solution.toReadMeLine())

readme.close()
