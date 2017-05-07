# In-mapper combining v.1 realization for WordCount with Hadoop Streaming

# --//---------
# Sample Input:
# aut Caesar aut nihil
# aut aut
# de mortuis aut bene aut nihil
# --//---------
# Sample Output:
# nihil    1
# aut	2
# Caesar	1
# aut	2
# nihil	1
# aut	2
# de	1
# bene	1
# mortuis	1


import sys

for line in sys.stdin:
    all_words = []
    words_counter = {}

    for word in line.strip().split(" "):
        all_words.append(word)

    for words in all_words:
        if words not in words_counter.keys():
            words_counter[words] = 1
        else:
            words_counter[words] = words_counter[words] + 1

    for words in words_counter.keys():
        print(words, words_counter[words], sep='\t')
