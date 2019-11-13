# Banned Card Checker 

* Unofficial Magic the Gathering Banned Card checker
* Author: Jason Egbert
* Date: 11/12/2019

## Overview

This program is an unofficial Magic the Gathering card checker. It takes in
details from user input about which format you are playing, and which card or
cards you would like to check. It compares them to a pre-prepared list of banned
cards for that format, and tells the user whether or not that card is on the
banned list. For vintage, it will also check to see if any cards are on the
restricted list, and report them to the user via the command line. 

## Manifest

The program includes the following files:
- src
    - Main -- the primary driver for this program
    - BanList -- the class that holds the ban lists
    - Verifier -- verifies user input
- data
    - block.txt -- ban list for block format
    - brawl.txt -- ban list for brawl format
    - commander.txt -- ban list for commander format
    - legacy.txt -- ban list for legacy format
    - modern.txt -- ban list for modern format
    - pioneer.txt -- ban list for pioneer format
    - standard.txt -- ban list for standard format
    - vintage.txt -- ban list for vintage format
    - vintage-restricted.txt -- restricted list for vintage format
- Makefile - the build system for this program
- README.md - this file

## Building the Program

In order to build this program, utilize the Makefile system by typing the
following into the command line of your choice:
```
make
```
This will compile to program for command line use.

## Features and Usage

The program can be run with the following command from the command line:
```
$ java Banned
```
from the same directory the executable is in. 

Upon successful start, the program will begin asking the user questions, and
accepting user input in order to determine whether or not your card is banned.

In order to successfully check your individual cards, you must include the
complete English name of the card, with correct spelling and punctuation.
Capitalization is not important, and can be done at random for all the program
cares.

The same rules regarding name format apply to cards in a deck list file as well.
Additionally, deck lists must contain one complete card name per line, with no
additional information (like quantities) that is not contained in the standard
English name of each card.

When the program prompts the user for a deck-list file, the user must currently
input the absolute path to the file, or it likely won't be found. I haven't
tested file paths relative to the source directory, so I cannot say that they
will not work. Yet.

## Future Content
Planned future content includes the addition of allowing the user to check more
than one individual card or deck list (or both) in a single session, and for
more than one format. Also there may be additional formats included as they are
brought to my attention (i.e. pauper is not currently included in the program).
I also intend (long-term) to build a program to occasionally update the ban
lists based on data scraped from the [MTG banned and restricted
page](https://magic.wizards.com/en/game-info/gameplay/rules-and-formats/banned-restricted?gclid=CjwKCAiAzanuBRAZEiwA5yf4uuYQpEgVfQy_iqE3Je7HHtu68buTne9uIWrY3VKcu6b8I7k5H5wKmRoCovIQAvD_BwE).
Further down the line, I may also include a GUI user interface to make the
program more accessible to less technically inclined users, as well as a
pre-packaged executable that can be run on a user's machine without the need for
compilation by the user.

I also intend to make the user file input more simplistic, making the file
search a little more intelligent so the user doesn't have to input the absolute
path.

## Known Bugs
At present, there are issues, but no known bugs. Please leave a comment on or
raise an issue if you discover one.
