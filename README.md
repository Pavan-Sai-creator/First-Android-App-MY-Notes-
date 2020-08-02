# Project Name: MY-Notes

## About Me:

My name is Pavan Sai.K, I had lot of enthusiasm to help people by developing android Apps. Now that I have spent enough time in learning, I want to combine and put all the pieces of information into action. So, I decided to make a simple Android App which would include all the fundamental Android Components.

## Overview of the Project:

This is a basic Note taking App which not only allows users to add text but also allows them to add images. In this App, an image can be added in two ways. You can either add an image which already exists in your device or download it from internet by entering URL of the image. 

## UI and Structure:

- The launcher activity includes an **add button** (*plus symbol*) at bottom right corner of the screen. Users can start adding their Note by tapping on it.
- Once the add button is tapped, a new activity starts which allows users to add Title and Body of thier Note. This activity will include an **Add image** button at the bottom left corner of the screen, which allows the users to add images.
- After clicking on the **Add image** button, a new activity is initiated which has 2 buttons in the center of the screen. They are:
  1. **Choose from device**
  2. **Get from internet** 
- To add an image which already exists in the device, **Choose from device** should be selected.
- To fetch an image from *remote-server*, **Get from internet** should be selected.
  - This will take the Users to another activity in which they will be prompted to enter the **URL** of the image that they intend to download.
  - #### URL Used:
    
    https://pictures.topspeed.com/IMG/jpg/201303/2014-rolls-royce-wraith-25.jpg
  - Now, to initiate downloading, Users will have to tap the **download button** (*Down arrow symbol*) at the bottom right corner of the screen.
  - Once the image is downloaded, Users will recieve a notification saying *Image Downloaded* and the downloaded image will be added to their Note.
  

## Fundamental Android Components used:

1. Activities
2. Services
3. Broadcast Receivers
4. Content Providers
