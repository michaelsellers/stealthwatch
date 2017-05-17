#!/bin/bash
#Write a quick and dirty program (Shell, Python, Perl, Java, Lisp,
#   C++, APL, or whatever) to produce a count of all the different
#   "words" in a text file.  Use any definition of word that makes
#   logical sense or makes your job easy. 

# I used bash as it was the quickest( & dirtiest) way to count words.
# I liberally stole the code from the internet a the following URL
# https://unix.stackexchange.com/questions/39039/get-text-file-word-occurrence-count-of-all-words-print-output-sorted

# The explanation was given in the URL I include it here for convenience.
#    tr just replaces spaces with newlines
#    grep -v "^\s*$" trims out empty lines
#    sort to prepare as input for uniq
#    uniq -c to count occurrences
#    sort -bnr sorts in numeric reverse order while ignoring whitespace

cat $1 | tr '[:space:]' '[\n*]' | grep -v "^\s*$" | sort | uniq -c | sort -bnr
