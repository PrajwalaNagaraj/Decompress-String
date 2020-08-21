# Decompress-String

Solution solves cases such as this:

i/p: (abc(3)d)(2) 
o/p: abcccdabcccd

i/p: ((ab)(2)(cd)(2))(2)
o.p: ababcdcdababcdcd

i/p: (ab(10)c)(2)
o/p: abbbbbbbbbbcabbbbbbbbbbc

Algorithm uses a Stack to process the letters from left to rigth and count variable to hold the number of times we need to multiply.
On encounter with every closing parenthesis:
1) if count is set -> multiply the latest char/String on top of stack and push it back in.
2) if count is not set -> then we got a closing parenthesis, combine all chars from stack into one string and push it back in.
