---
title: "Problem Sheet 5"
author: 'Matt Roberts, University of Bath'
date: 'October 2026'
site: bookdown::bookdown_site
language: en
documentclass: article
classoption: a4paper
fontsize: 10pt
geometry: margin=2.5cm
output:
  clavertondown::gitbook_clav:
    keep_md: true
    config:
      download: [["probsheet4.html", "HTML page"], ["probsheet4.pdf","Standard print PDF"], ["probsheet4Clear.pdf","Clear print PDF"], ["probsheet4Large.pdf","Large print PDF"]]
      sharing: no
    pandoc_args: --default-image-extension=svg
  clavertondown::pdf_clav:
    latex_engine: pdflatex
    number_sections: false
    keep_tex: true
    fig_caption: true
    toc: false
    extra_dependencies: ["float"]
    pandoc_args: --default-image-extension=pdf
  clavertondown::html_clav:
    toc: false
    number_sections: false
    pandoc_args: --default-image-extension=svg
header-includes:
  - \usepackage{fdsymbol}
  - \newcommand{\BOO}{BOO}
  - \renewcommand{\P}{\mathbb{P}}
  - \newcommand{\E}{\mathbb{E}}
  - \newcommand{\F}{\mathcal{F}}
---

<!-- The block below contains R code that determines which solutions appear in the output.  The part that says echo=FALSE means that this code runs but is not displayed in the output document.  The code below defines two boolean (i.e TRUE or FALSE) values: solutionsw and solutionsh, which determine whether solutions appear for whole and hoc (tutorial) questions respectively. -->



<!-- This hand-in information only appears when the solutionsh is FALSE.  As before, echo determines whether this text is displayed.  The ! acts as logical not, i.e. !solutionsh is TRUE if solutionsh is FALSE, and vice versa. -->

**Released:** Wednesday 28th October 2025.

Hand in your solutions by putting them into the correct folder in the correct pigeon hole (identified by your tutorial group, e.g. A1, A2,... , B1, B2,...) under the "PRB&STAT" label on level 3 of 4W **by the day and time advised by your tutor**. Remember to put your name on **each sheet of paper that you use** to avoid confusion, or alternatively staple the sheets together (don't just fold over the corners).

Bookwork questions are there to check that you are familiar with the material from lectures. The tutorial question will be covered during your tutorial. You should do the problems yourself and hand in question 7. The extra questions are there if you want further practice.

If you spot any mistakes, please send corrections to mir20@bath.ac.uk

# Bookwork questions

## Question 1

Which of the following are always true? For those that are not always true, give a condition under which they *are* true.

(a) For events $E$ and $F$,
$$\P(E\cup F) = \P(E)+\P(F).$$

(b) For events $E$ and $F$,
$$\P(E\cap F) = \P(E)\P(F).$$
(c) For events $E$ and $F$,
$$\P(F) = \P(F\cap E) + \P(F\cap E^c).$$

(d) For events $E_1$, $E_2$ and $F$ such that $\P(E_1)>0$ and $\P(E_2)>0$,
$$\P(F) = \P(E_1)\P(F|E_1) + \P(E_2)\P(F|E_2).$$

(e) For events $E$ and $F$ such that $\P(E)\in(0,1)$,
$$\P(F) = \P(E)\P(F|E) + \P(E^c)\P(F|E^c).$$

(f) For events $E$ and $F$,
$$\P(E | F) = \frac{\P(E\cap F)}{\P(F)}.$$

<!-- This solution only appears when solutionsh is TRUE. -->


## Question 2

The probability that Dave's partner is angry at him is 0.5. If Dave has done something wrong, then the probability that his partner is angry at him increases to 0.8. Dave estimates that at any given time, the probability that he has done something wrong is 0.4.

Dave observes that his partner is angry at him. What is the probability that he has done something wrong?


<!-- This solution only appears when solutionsh is TRUE. -->




# Tutorial questions

## Question 3

In a game of "One or a million", a mysterious contestant known only as "GJ" is faced with three boxes. Inside two of the boxes is £1. Inside the other is £1million. (We can assume that the choice of which box contains £1million has been made at random.)

GJ picks box number 2. Dramatic music plays. The lights dim.

The host, Leon Sdnomde, offers GJ a deal. He knows what is inside all three boxes, and slowly walks over to box number 1, opening it to show that it contains just £1. (This is a standard feature of the show; since there are two boxes containing £1, Sdnomde can always choose one of the unchosen boxes and show that it contains £1. If both unchosen boxes contain £1, then he chooses one of them at random to open.) He then offers GJ the opportunity to either stick with box number 2, or switch to box number 3. If he chooses to switch, he has to give 10% of his winnings to Sdnomde.

Should GJ stick with box number 2 or switch to box number 3?

<!-- This solution only appears when solutionsh is TRUE. -->


## Question 4

A certain disease is found in 1 in 5000 people, and a further 1 in 1000 people are naturally immune to the disease (cannot have the disease at all). If a person has the disease, a test will give a positive result with probability $92/100$. If a person is immune, the test will give a positive result with probability $8/10$. If a person does not have the disease nor is immune, the test will give a positive result with probability $1/500$.

(a) What is the probability that a randomly chosen individual is neither immune nor has the disease?

(b) Determine the probability that a person showing a positive test result actually has the disease.

<!-- This solution only appears when solutionsw is TRUE. -->




# Problems

## Question 5 (Section A)

(Note: the numbers in this question are entirely made up and not based on any real homework / exam!)

(a) Suppose that events $E_1$, $E_2$ and $E_3$ form a partition of a sample space $\Omega$. State the law of total probability for calculating the probability of event $F$ from its conditional probabilities given $E_1$, $E_2$ and $E_3$. [1]

(b) Students who do at least 90% of the homework have a 90% chance of passing the exam. Students who do at most 60% of the homework have a 50% chance of passing the exam. We know that 20% of students do at least 90% of the homework, and 70% of students do more than 60% of the homework. Overall 70% of students pass the exam. What proportion of students who do between 60% and 90% of the homework pass the exam? Give your answer as a percentage. [3]

(c) What does it mean to say that three events $E$, $F$ and $G$ are independent? [2]

<!-- This solution only appears when solutionsh is TRUE. -->



<!-- ## Question 3

A box of chocolates contains 25 chocolates, of which 9 are nutty, 6 are toffee-centred and 10 are plain. Four chocolates are chosen at random from the box.

(a) What is the probability that exactly three of the chosen chocolates are nutty?

(b) If you know that there are at least 3 nutty chocolates, what is the probability that all four are nutty? -->

<!-- This solution only appears when solutionsh is TRUE. -->


<!-- ```{block, echo=solutionsw}

### Solution to question 3

(a) Let $E_{r} = \{\mbox{exactly} \ r \ \mbox{of the chocolates are nutty}\}$ and let $\Omega$ be the set of all possible choices of the chocolates. Then $\displaystyle |\Omega| = \binom{25}{4}$ and
$$
|E_r| = \dbinom{\# \ \mbox{ways choosing}}{r \ \mbox{nutty}} \times \dbinom{\# \mbox{ ways choosing}}{4-r \ \mbox{ plain or toffee}}= \binom{9}{r} \times \binom{16}{4-r},
$$
for $r = 0, 1, \dots 4$. All outcomes are equally likely, so
$$
\mathbb{P}(E_3) = \frac{|E_3|}{|\Omega|} = \frac{\binom{9}{3} \times \binom{16}{1}}{\binom{25}{4}} = \frac{84 \times 16}{12650} = 0.1062 \quad (4 \mbox{ dp}).
$$

(b) We have
\begin{eqnarray*}
\mathbb{P}(\{\mbox{all 4 nutty}\} \, | \, \{\mbox{at least 3 nutty}\}) & = & \mathbb{P}(E_4 \, | \, E_3 \cup E_4)\\
& = &\frac{\mathbb{P}(E_4 \cap (E_3 \cup E_4))}{\mathbb{P}(E_3 \cup E_4)}
\end{eqnarray*}
Now  $E_4 \cap (E_3 \cup E_4) = E_{4}$ and, noting that $E_{3}$ and $E_{4}$ are disjoint, we thus have
\begin{eqnarray*}
\mathbb{P}(\{\mbox{all 4 nutty}\} \, | \, \{\mbox{at least 3 nutty}\}) & = &\frac{\mathbb{P}(E_4)}{\mathbb{P}(E_3) + \mathbb{P}(E_4)} \\
& = & \frac{\binom{9}{4} \binom{16}{0}}{\binom{9}{3} \binom{16}{1} + \binom{9}{4} \binom{16}{0}}\\
& = &\frac{126 \times 1}{84 \times 16 + 126 \times 1}\\
& = &\frac{126}{1470} \ = \ 0.0857\quad (4 \mbox{ dp}).
\end{eqnarray*}

```-->





## Question 6 (Section A)

Some surprising election results have led to Parliament containing a proportion $p$ of members from the Count Binface party, who are incapable of changing their minds about anything, and a proportion $(1-p)$ of members from the Monster Raving Loony party, who change their minds at random with probability $r$ between successive votes on the same issue. (Every member of Parliament must vote "Yes" or "No" in each vote.)

In the course of a debate about the budget, there are three votes on the same issue.

(a) What is the probability that a randomly chosen member of Parliament voted in the same way on the first two votes? [2]

(b) Given that a randomly chosen member of Parliament voted in the same way on the first two votes, what is the probability that they will vote in the same way on the third vote? [2]

(c) A member of the Monster Raving Loony party initially decides to vote Yes with probability $1/2$ and No with probability $1/2$ on an issue. There is then another vote on the same issue. For what value of $r$ is their second vote independent of their first vote? Justify your answer. [2]
 
<!-- This solution only appears when solutionsh is TRUE. -->



## Question 7 (Section B) (**Hand in**)

(a) For events $E$ and $F$ such that $\P(F)>0$, state the definition of the conditional probability of $E$ given $F$. [1]

(b) What does it mean for events $E_1$ and $E_2$ to form a partition of a sample space $\Omega$? [1]

(c) A plane is equally likely to have crashed in one of two possible regions. If the plane crashed in region 1, the probability that a search of that region will successfully find the plane is judged to be $9/10$. The corresponding figure for region 2 is $4/5$. Let $P_j$ be the event that the plane is in region $j$, for $j=1,2$. Let $U_j$ be the event that a search of region $j$ is unsuccessful, for $j=1,2$. [7]

\ \ \ \ (i) Explain why $\P(U_2\, |\, P_1\cap U_1) = 1$.

\ \ \ \ (ii) Calculate $\P(P_1\cap U_1\cap U_2)$ and $\P(P_2\cap U_1\cap U_2)$.

\ \ \ \ (iii) Calculate the probability that the plane is in region 2, given that searches of both regions are unsuccessful. Write your answer as a fraction in its simplest form.

(d) A lake contains $52$ fish of which $13$ are perch and $39$ are carp. Assume that carp and perch are equally likely to be caught. A fisherman has caught five fish. For this part of the question, you may leave your answers as fractions involving factorials or combinations. [6]

\ \ \ \ (i) Find the probability that exactly two of the five caught fish are perch.

\ \ \ \ (ii) You are told that the fisherman has caught at least three perch. What is the probability that all five of the caught fish are perch?
 

<!-- This solution only appears when solutionsh is TRUE. -->





# Extra questions

A reminder that you aren't expected to do all the extra questions. They are there in case you want more practice.

## Question 8

A ball is drawn at random from each of two urns. The first urn contains 3 red and 3 black balls; the second urn contains 4 red and 6 black balls.

(a) What is the probability that both balls have the same colour?

(b) Find the probability that both balls are black given that they are the same colour.
 
<!-- This solution only appears when solutionsh is TRUE. -->




## Question 9

Initially, an urn contains three white and five red balls. Balls are drawn at random from the urn. Whenever a red ball is drawn, it is placed back into the urn together with one extra red ball. Whenever a white ball is drawn, it is placed back into the urn together with two extra white balls. Find the probability that the first three balls drawn out of the urn alternate in colour.

<!-- This solution only appears when solutionsh is TRUE. -->


## Question 10

Suppose we have six cards identical in form apart from the colours on each side. Three of the cards have both sides coloured red, two of them have both sides coloured blue whilst one card has a red and a blue side. The six cards are mixed up in a hat, and a random card is drawn and put down on a table. If the visible side of this card is coloured red, what is the probability the other side is coloured blue?

<!-- This solution only appears when solutionsh is TRUE. -->


## Question 11

Joyce, a traveller from the distant kingdom of Wilworia, arrives at dusk at a small village. She knows that 5\% of the villagers are vampires, 10\% are werewolves and the remainder are humans. She meets a stranger, and asks them if they are a human. She knows that humans always answer this question truthfully. She also knows that vampires are particularly arrogant, so that any particular vampire has only a 10\% chance of lying to this question. Werewolves are less arrogant and more reserved, and have a 30\% chance of not answering truthfully.

(a) What is the probability that the stranger will claim to be a human?

(b) The stranger claims to be a human. What is the probability that they are lying?
 
<!-- This solution only appears when solutionsh is TRUE. -->


## Question 12

Suppose that $\P(A)>0$ and $\P(B)>0$. Show each of the following statements. 

(a) If $\mathbb{P}(B)=1$, then $\mathbb{P}(A\mid B) = \mathbb{P}(A)$ for any $A$.

(b) If $A \subset B$, then $\mathbb{P}(B\mid A) = 1$ and $\mathbb{P}(A\mid B) = \mathbb{P}(A) / \mathbb{P}(B)$.

(c) If $A \cap B = \emptyset$, then $$\mathbb{P}(A \mid A \cup B) = \frac{\mathbb{P}(A)}{\mathbb{P}(A) + \mathbb{P}(B)}.$$

<!-- This solution only appears when solutionsh is TRUE. -->


<!--

## Question 15

We roll a fair dice 3 times. Let $E_{i,j}$ be the event that rolls $i$ and $j$ have the same result, for $i,j\in\{1,2,3\}$. Show that $E_{1,2}$ is independent of $E_{1,3}$, $E_{1,2}$ is independent of $E_{2,3}$, and $E_{1,3}$ is independent of $E_{2,3}$. (We say that the events are *pairwise independent*.) Are $\{E_{1,2},E_{1,3},E_{2,3}\}$ independent?




-->

<!--chapter:end:index.Rmd-->

