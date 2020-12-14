import os


dir = r"D:\Desktop\leetcode202006-202106\src\leetcode"
list = []

for root, dirs, files in os.walk(dir):
    for file in files:
        if file.split(".")[1] == 'java':
            list.append(file.split("_")[0])
print(len(list))

txt = open("D:/Desktop/leetcode202006-202106/src/leetcode/idOfProblems.txt", "w")
for line in list:
    txt.write(line + "\n")
txt.close()


# print(list)
