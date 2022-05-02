from os import listdir
from os.path import isfile, join
import leetcode
import time

solution_file_dir = "../src/main/kotlin/solution/"

leetcode_api_instance = leetcode.DefaultApi(leetcode.ApiClient(leetcode.Configuration()))
leetcode_query_get_question_info = """
    query getQuestionDetail($titleSlug: String!) {
        question(titleSlug: $titleSlug) {
            title
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
\# | Problem(Solution) | LeetCode Link | Difficulty | Accepted Rate
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
    def __init__(self, problem_number, problem_ref_name, solution_file_name):
        self.problem_number = problem_number
        self.problem_ref_name = problem_ref_name
        self.solution_file_name = solution_file_name
        self.__update_info()

    def __update_info(self):
        not_success = True
        try_count = 0
        while not_success and try_count<30:
            try:
                try_count += 1
                print("trying to get problem info (try " + str(try_count) + "): " + self.problem_ref_name)
                graphql_request = leetcode.GraphqlQuery(
                    query=leetcode_query_get_question_info,
                    variables=leetcode.GraphqlQueryGetQuestionDetailVariables(title_slug=self.problem_ref_name),
                    operation_name="getQuestionDetail"
                )

                info = leetcode_api_instance.graphql_post(body=graphql_request)
                question = info.data.question
                self.title = question.title
                self.difficulty = question.difficulty
                self.acRate = eval(question.stats)['acRate']
                not_success = False
            except Exception as e:
                if (try_count >= 30): raise e
                print("*** Exception occured: " + str(e))
                time.sleep(0.3)

    def get_leet_code_link_title(self):
        return self.problem_number + ". " + self.title
        
    def get_leet_code_link(self):
        return "https://leetcode.com/problems/" + self.problem_ref_name
        
    def get_solution_path(self):
        return solution_file_dir + self.solution_file_name
        
    def to_read_me_line(self):
        return self.problem_number +\
            " | " + "["+self.title+"]("+self.get_solution_path()+")" +\
            " | " + "["+self.get_leet_code_link_title()+"]("+self.get_leet_code_link()+")" +\
            " | " + self.difficulty +\
            " | " + self.acRate +\
            "\n"

solution_files = [f for f in listdir(solution_file_dir) if f[0:3]=="Sol"]

problems = []
for solution_file in solution_files:
    split = solution_file.split(".")[0].split("_")
    problem_number = split[1]
    problem_ref_name = "-".join(split[2:])
    problem = Problem(problem_number, problem_ref_name, solution_file)
    problems.append(problem)
    
problems.sort(key=lambda solution: int(solution.problem_number))

readme = open("../README.md", "w")
readme.write(title_project + "\n" + desc_project + "\n\n")
readme.write(title_problem_solved + "\n")
readme.write(table_header_total + "\n" + get_table_content_string_total(problems) + "\n\n")
readme.write(table_header_difficulty + "\n" + get_table_content_string_difficulty(problems) + "\n\n")
readme.write(table_header_problems + "\n" + get_table_content_string_problems(problems))

readme.close()
