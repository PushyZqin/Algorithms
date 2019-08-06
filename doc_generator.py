# encoding:utf-8
import os
from typing import List, Dict

problemset_path = './src/leetcode/problemset'

row_temp = '| {}    |  [{}]({})    |    {}  |'

def find_readme_title(path: str) -> str:
    readme_path = '{}/{}'.format(path, "README.md")
    if os.path.exists(readme_path):
        with open(readme_path, encoding='utf-8') as f:
            text = ""
            for i in range(10):
                line = f.readline()
                if line.startswith("#"):
                    text = line
                    break
            text: str = text.replace("\n", "")
            if text.find('[') != -1 and text.find(']') != -1:
                sub_text = text[text.find('['): text.index(']')]
                title = sub_text[sub_text.find('.') + 2:]
            else:
                idx: int = text.index('.')
                title = text[idx + 2:]

            return title

def get_map():
    map = {}
    for dir_name in os.listdir(problemset_path):
        if dir_name.startswith('_'):
            absolute_path: str = '{}/{}'.format(problemset_path, dir_name)

            words: List[str] = dir_name.split('_')[2:]
            idx: int = dir_name.split('_')[1]
            en_title: str = ' '.join(words)

            title = find_readme_title(absolute_path)
            if not title or len(title) == 0:
                title = en_title

            map[idx] = {
                'en_title': en_title,
                'title': title,
                'absolute_path': absolute_path[1:]
            }
    return map

def main():
    data_map = get_map()

    for i in range(1, 1500):
        idx: str = str(i)
        if idx in data_map:
            data = data_map[idx]
            row = row_temp.format(idx, data['title'], data['absolute_path'], data['en_title'])
            print(row)

if __name__ == '__main__':
    main()