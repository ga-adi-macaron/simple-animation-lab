---
title: Simple animation
type: lab
duration: "1:30"
creator:
    name: Yuliya Kaleda
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Simple Animation Lab

## Introduction

> ***Note:*** _This lab should done independently._

In this lab, you will be building an animated wish list using your knowledge of view and layout animation. The app should have an edit text where a user
can type in his/her wish. After clicking the button "add a wish", the wish should get animated and then be added to the wish list on top
of other wishes. The app does not have to look the same, but it needs to have the same functionality.  

## Exercise

#### Requirements

- contain an edit text (to type in a wish), button (to add a wish), text view (the place where the wish will get animated) and a
view group (wish list)
  - for the view group, see what was used in the independent practice app in the lesson - a familiar layout element that extends ViewGroup
- edit text should allow no more than one line of input - find the right XML attribute to control this
- text view should get animated (use *alpha* and *rotate* types of animation)
- a new wish should be added to the top of the list
  - refer to the independent practice from the lesson as an example
  - when adding a new text view to the view group, be sure to specify position 0
- input field should get cleared after a wish is added to the list

**Bonus:**
- add functionality to remove a wish from the list

#### Starter code

There is no starter code for this lab. You will need to set up your main activity to have the correct elements, and create an animation xml file in the `res/anim/`.

#### Deliverable

Here is a gif that shows view and layout animation:

<p align="center">
  <img src="./screenshots/solution_code_lab.gif">
</p>

---

## Additional Resources
- [Android Animations and Graphics](https://developer.android.com/guide/topics/graphics/overview.html)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
