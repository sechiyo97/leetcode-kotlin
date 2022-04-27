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

title_project = "# leetcode-kotlin"
desc_project = "LeetCode Algorithm Practice"

title_problem_solved = "## Problem Solved"

table_header_total = """\
Total |
------------- |\
"""
table_header_difficulty = """\
Easy | Medium | Hard
------------- | ------------- | -------------\
"""
table_header_problems = """\
\# | name | link | difficulty | accepted rate
------------- | ------------- | ------------- | ------------- | -------------\
"""


def get_table_content_string_total(problems):
    return str(len(problems)) + " |"

def get_table_content_string_difficulty(problems):
    easy_count = sum(problem.difficulty == 'Easy' for problem in problems)
    medium_count = sum(problem.difficulty == 'Medium' for problem in problems)
    hard_count = sum(problem.difficulty == 'Hard' for problem in problems)
    return str(easy_count) + " | " + str(medium_count) + " | " + str(hard_count)

def get_table_content_string_problems(problems):
    content = ""
    for problem in problems:
        content += problem.to_read_me_line()
    return content
    

class Problem:
    def __init__(self, problem_number, problem_ref_name):
        self.problem_number = problem_number
        self.problem_ref_name = problem_ref_name
        self.__update_name()
        self.__update_info()

    def __update_name(self):
        self.problem_name = ' '.join([name[0].upper() + name[1:].lower() for name in problem_ref_name.split('-')])
        
    def __update_info(self):
        graphql_request = leetcode.GraphqlQuery(
            query=leetcode_query_get_question_info,
            variables=leetcode.GraphqlQueryGetQuestionDetailVariables(title_slug=self.problem_ref_name),
            operation_name="getQuestionDetail"
        )

        info = leetcode_api_instance.graphql_post(body=graphql_request)
        question = info.data.question
        self.difficulty = question.difficulty
        self.acRate = eval(question.stats)['acRate']

    def get_problem_link_title(self):
        return self.problem_number + ". " + self.problem_name
        
    def get_problem_link(self):
        return "https://leetcode.com/problems/" + self.problem_ref_name
        
    def to_read_me_line(self):
        return self.problem_number +\
            " | " + self.problem_name +\
            " | " + "["+self.get_problem_link_title()+"]("+self.get_problem_link()+")" +\
            " | " + self.difficulty +\
            " | " + self.acRate +\
            "\n"

solution_files = [f for f in listdir("src/main/kotlin/solution/") if f[0:3]=="Sol"]

problems = []
for solution_file in solution_files:
    split = solution_file.split(".")[0].split("_")
    problem_number = split[1]
    problem_ref_name = "-".join(split[2:])
    problem = Problem(problem_number, problem_ref_name)
    problems.append(problem)
    
problems.sort(key=lambda solution: int(solution.problem_number))

readme = open("README.md", "w")
readme.write(title_project + "\n" + desc_project + "\n\n")
readme.write(title_problem_solved + "\n")
readme.write(table_header_total + "\n" + get_table_content_string_total(problems) + "\n\n")
readme.write(table_header_difficulty + "\n" + get_table_content_string_difficulty(problems) + "\n\n")
readme.write(table_header_problems + "\n" + get_table_content_string_problems(problems))

readme.close()
