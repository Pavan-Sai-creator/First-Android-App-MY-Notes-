# Project Name: MY-Notes

## About Me:

My name is Pavan Sai.K, I had lot of enthusiasm to help people by developing android Apps. Now that I have spent enough time in learning, I want to combine and put all the pieces of information into action. So, I decided to make a simple Android App which would include all the fundamental Android Components.

## Overview of the Project:

This is a basic Note taking App in which you can add any image of your choice to the home screen to customize your app and feel good. The app uses HTTP framework to connect to remote server to download the image. All the notes can be saved in an SQLite DataBase and can be viewed anytime. You can also update or delete your notes. 

## UI and Structure:

- The launcher activity has 2 EditText fields. One for Title and one for Body of the note. It contains 3 buttons namely, **SAVE**, **ADD IMAGE**, **SHOW ALL NOTES**
- Once the SAVE button is tapped, the note gets saved to the SQLite DataBase. This activity will include an **Add image** button, which allows the users to add images to their Home screen and customize it.
  - #### URL Used:
    
    https://www.google.com/logos/doodles/2020/india-independence-day-2020-6753651837108500.3-l.png
  - Once the image is downloaded, It will be displayed on Home Screen
  - On clicking on **SHOW ALL NOTES**, All notes in DataBase will be displayed in list view. On clicking any one of the notes you can update it or delete it from your DataBase.
  

## Fundamental Android Components used:

1. Activities
2. Services
3. Broadcast Receivers
4. Content Providers
