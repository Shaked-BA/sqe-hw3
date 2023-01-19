# Assignment 3: Software Quality Engineering
This is a repository for assignment 3 of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called Prestashop (https://www.prestashop.com).

Prestashop supplies flexible and scalable ecommerce platform to launch an online business owned and designed the user.

## Installation
* Docker installation guide: https://www.docker.com/products/docker-desktop/
* Prestashop installation guides: https://webkul.com/blog/running-prestashop-in-docker-container/ https://hub.docker.com/r/prestashop/prestashop/
* Another tutorial: https://www.youtube.com/watch?v=J4lq2eW_npE&ab_channel=PatriTech
## What we tested
We tested the guest commenting module that responsible for the guest users reviews permission. We chose to test the following user stories: 

*User story:* A guest user adds a review on a product of the online shop. 

*Preconditions:* There product in the system to review.

*Expected outcome:* The review is published in the products page.

*User story:* The shops admin turns off the guest commenting option.

*Preconditions:* The guest commenting option is turned on.

*Expected outcome:* The guest commenting option is turned off.

*User story:* The shops admin turns off the guest commenting option while a guest user is posting a comment.

*Preconditions:* There product in the system to review and the guest commenting option is turned on.

*Expected outcome:* The review is not published in the products page.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a BDD testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Prestashops guest commenting module works properly and performs the expected outcome.
