

# GroceryApp

## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)
3. [Wireframes](#Wireframes)
4. [Schema](#Schema)

## Overview
### Description
Grocery checkout app that enables quick checkout in the world of self serving stores and checkout free supermarkets. Keeps track of purchased items and potentially suggest items based on purchase date.

### App Evaluation
- **Category:** Reatil
- **Mobile:** This app would be primarily developed for mobile
- **Story:** Enables users to select purchased items for different stores and suggest items to purchase based on history.
- **Market:** Any age group.
- **Habit:** The apps suggestion feature would increase the frequency with which users use the app.
- **Scope:** The app could be used in conjuction with existing mobile platforms for grocery retailers enabling users to purchase items and keep track of purchasing history accross different stores.

## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User logs in to access previous items bought and preference settings
* User can select items to buy from a particular store.
* Profile pages with purchase history of user
* Settings (Accesibility, Notification, General, etc.)

**Optional Nice-to-have Stories**

* Ratings and reviews of stores
* Payment portal access
* List with predicted items that the user might want 

### 2. Screen Archetypes

* Login 
* Register - User signs up or logs into their account
   * Upon Download/Reopening of the application, the user is prompted to log in to gain access to their profile information to acess various stores in the users vicinity. 
* Stores Screen - Stores in the users vicinity ordered by distance
   * Upon selecting store choice items screen opens
* Profile Screen 
   * Allows user to upload a photo and fill in relevant information (billing details etc.)
* Grocery Selection Screen.
   * Allows user to be able to choose their desired items and add them to a cart.
* Settings Screen
   * Lets people change language, and app notification settings.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Store selection
* Profile
* Settings

Optional:
* Discover (Suggested Choices)

**Flow Navigation** (Screen to Screen)
* Forced Log-in -> Account creation if no log in is available
* Store Selection  -> Jumps to Grocery items
* Profile -> Text field to be modified. 
* Settings -> Toggle settings

## Wireframes

**Example**
<img src="https://i.imgur.com/9CrjH1K.jpg" width=800><br>


## Schema 
### Models
#### Store

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | storeId      | String   | unique id for the store (default field) |
   | name          | String   | store name |
   | image         | File     | photo of store |
   | description   | String   | Store description |
   | commentsCount | Number   | number of reviews for a store |
   | rating        | Number   | store rating |
   | timings       | DateTime | store timings |

#### Grocery item 
   
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | itemId        | String   | unique id for the grocery item (default field) |
   | name          | String   | store name |
   | image         | File     | photo of item |
   | description   | String   | item description |
   | quantity      | Number   | intended purchase quantity |
   | discount      | String   | applicable discount  |


  
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all stores for user 
      - (Create/POST) Create a new review for store 
      - (Delete) Delete existing user review
   - Grocery Item Screen
      - (Read/GET) Query item information
      - (Update/PUT) Update users cart with items

   - Profile Screen
      - (Read/GET) Query logged in user object
      - (Update/PUT) Update user profile image
