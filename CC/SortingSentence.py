'''
Nidhee loves reading Shakespeare. Once she read his famous quote, "To be or not to be." Being a Computer Science Geek, she thought of manipulating this quote.
She sorts all the words in the sentence according to the length, such that shorter words come before the longer words. This means that the word with smallest length would be at the start of the sentence and the largest would be at the end. If two words are of same length, then the words appear in same order as in the original sentence.
After her manipulation, quote became something like this - "To be or to be not."  She was amazed because the meaning of the sentence didn't change much. This intrigued her and she wanted to do this with every sentence in the Shakespeare's book. After working on few sentences, she got tired and sad as well. Can you make her happy by giving her the code that could do this task for her?
'''
# Write your code here
inp = input()
arr_words = inp.split(' ')
first_word = arr_words[0]
arr_words = [s.strip('.') for s in arr_words]
arr_words = sorted(arr_words, key=lambda x:len(x))

ans = ""
for index, word in enumerate(arr_words):
    if index == 0:
        ans += word.capitalize() + " "
    elif index == len(arr_words) -1:
        ans += word.lower() + "."        
    else:
        ans += word.lower() + " "

print(ans)