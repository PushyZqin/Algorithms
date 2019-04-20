# encoding:utf-8
import os

path = './src/site/pushy/algorithms/leetcode/problemset'

problemset_name_list = []
title_list = []

for dir_name in os.listdir(path):
    if (dir_name.startswith('_')):
        absolute_path = '{}/{}'.format(path, dir_name)

        words = dir_name.split('_')[2:]
        new_dir_name = '-'.join([word.lower() for word in words])
        title = ' '.join(words)

        print(title)

        # title_list.append(title)
        # problemset_name_list.append(new_dir_name)
        #
        # # 修改目录名
        # new_path = '{}/{}'.format(path, new_dir_name)
        # os.rename(absolute_path, new_path)
        # absolute_path = new_path
        #
        # # 修改 README.html -> index.html
        # html_path = os.path.join(absolute_path + '/README.html')
        # if (os.path.exists(html_path)):
        #     new_path = os.path.join(absolute_path + '/index.html')
        #     os.rename(html_path, new_path)

# template = """
# <!DOCTYPE html>
# <html lang="en">
# <head>
# 	<meta charset="UTF-8">
# 	<title>Document</title>
# </head>
# <body>
#     <div>{}</div>
# </body>
# </html>
# """
# 
# # 生成首页index.html
# div_string = ""
# for name, title in zip(problemset_name_list, title_list):
#     index_html_path = '{}/{}/index.html'.format(path, name)[1:]
# 
#     a_ele = '<a href="{}">{}</a></br>'.format(index_html_path, title)
#     div_string+=a_ele
# 
# print(template.format(div_string))