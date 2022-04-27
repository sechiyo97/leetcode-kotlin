from os import listdir
from os.path import isfile, join
import leetcode

leetcode_api_instance = leetcode.DefaultApi(leetcode.ApiClient(leetcode.Configuration()))
leetcode_query_get_question_info = """
    query getQuestionDetail($titleSlug: String!) {
        question(titleSlug: $titleSlug) {
            difficulty
            stats
        }
    }
"""

header =""" \
# leetcode-kotlin
LeetCode Algorithm Practice
            
## Problem Solved
\#  | name | link | difficulty
------------- | ------------- | ------------- | -------------
"""

class Problem:
    def __init__(self, problem_number, problem_name):
        self.problem_number = problem_number
        self.problem_name = problem_name
        self.__updateInfo()
        
    def __updateInfo(self):
        graphql_request = leetcode.GraphqlQuery(
            query=leetcode_query_get_question_info,
            variables=leetcode.GraphqlQueryGetQuestionDetailVariables(title_slug=self.problem_name),
            operation_name="getQuestionDetail"
        )

        info = leetcode_api_instance.graphql_post(body=graphql_request)
        question = info.data.question
        self.difficulty = question.difficulty
        self.stats = question.stats
        
    def toReadMeLine(self):
        return self.problem_number +\
            " | " + self.problem_name +\
            " | " + "https://leetcode.com/problems/" + self.problem_name +\
            " | " + self.difficulty +\
            "\n"
    
solution_files = [f for f in listdir("src/main/kotlin/solution/") if f[0:3]=="Sol"]

problems = []
for solution_file in solution_files:
    split = solution_file.split(".")[0].split("_")
    problem_number = split[1]
    problem_name = "-".join(split[2:])
    problem = Problem(problem_number, problem_name)
    problems.append(problem)
    

problems.sort(key=lambda solution: int(solution.problem_number))

readme = open("README.md", "w")
readme.write(header)

for problem in problems:
    readme.write(problem.toReadMeLine())

readme.close()
