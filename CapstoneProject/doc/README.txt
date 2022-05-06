Balance it!
Authors: Rohan Parikh, Akshat Adsule
Revision: 4/12/22


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
Our program is a game in which users attempt to balance various objects through their phones. Our game will be level-based with increasing difficulty and skill required[a]. 
What problem does it solve? Why did you write it?
Our program is aimed at people who have injuries or conditions in their hands that impede their fine motor skills. Through our game, users can practice their fine motor skills and regain their abilities. 
What is the story?


What are the rules? What is the goal?
The rules are to categorize the various items into the same-colored bins. If an item is dropped or miscategorized, the user has lost and the game will reset. Once a user has successfully categorized all the items, they will win[b] and move on to a more difficult level. [c]


Who would want to use your program?
The main target audience for our program is people with arthritis and this program will aid them in improving their hand-eye coordination along with other traits.


What are the primary features of your program?]
A mobile controller would be used to balance the objects. 


Instructions:


1. Find the runnable Jar file in the dist folder
   1. Alternatively you may build the jar yourself by running ./gradlew assemble
2. Run the jar
   1. This should just work by double clicking the jar file, but you may need to run the java -jar command
   2. Alternatively, you can run ./gradlew run to run the project
3. Profit
   1. Once the program launches, you should be greeted with a QR code. Scan the code with your phone, and you should see your phone’s gyroscope data being reported on the screen. Keep track of the beta value, as this value should show up (and update) on the running java application.
      1. If you have an iPhone, you may need to use Chrome to open the URL


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
*  Mobile-based controller. Controlling the game through a physical device is an integral part of our game. With our goal of helping those with limited mobility, a mobile-based controller is expressly crucial for such a goal.[d]
*  Networking. It would be much easier for the user if the process of playing the game was as simple as possible. Thus, having a network connection between the device and the computer is important as it is the most seamless way of handling inter-device communication (compared to something like having a USB connection)
*  Physics. Our game is based on balancing which is fundamentally physics-based. Being able to do this with accuracy and precision will make our game intuitive and grounded. 
*  Levels. We need to make several levels in order for the players to have options. Also, the same level over again could get repetitive and boring- even if this is designed to aid people with disabilities- so it would be a must to have level.[e]
*  Save feature. A save feature would be necessary if the players want to have a way to get back to the level they were at previously and not restart the whole game every time. 


Want-to-have Features:
[These are features that you would like to have by the project due to date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
*  Being able to go back to previous levels. If a user would like to practice a certain skill again in a level, they should be able to do so. 
*  Being able to skip. If a level is too difficult for someone, they should have the ability to skip the current level and move on to the next. 
*  Stars with time- 3 stars for under a certain time, lower stars if time was higher. Assigning star values will motivate the user to complete the level in a faster time and improve the fine motor skills.[f] 
*  Handling networking errors effectively. Networking errors are bound to happen (such as client disconnects), and our game ideally should be able to handle such errors gracefully.
*  Fancy UI. Ideally, our UI should be cohesive and easy to use. 


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
*  Multiplayer aspect with competition based levels/leaderboards. This would be a very nice feature to have (and is entirely possible with Firebase), it seems out of the timeframe we have for this project. 
*  3D graphics and physics. While this is possible with Processing, we do not believe that we currently have the scope nor the time to fully develop 3D physics and handle that in processing.
*  Level builder. Level building would introduce a whole new UI and flow we would have to design and implement, and is thus out of the time frame for this project.




Class List (basic for now, will expand once we start coding):
Main - Starts the program
Drawing surface- for the screen attributes and some methods including the draw method, mouse pressed.
Level - Contains data about the current level
Mass class- Contains information about the actual objects that the user has to move to the balancing mechanism
Balancing aspect class- contains how velocity-gravity works with a seesaw or other mechanisms(changes with levels)
Networking - Handles establishing communication and receiving data from client devices. 


Credits:
Developers
* Akshat: Networking, level design, and game code.
* Rohan: Physics, level design, and game code.
Libraries
* Processing
* Firebase
* QRGen
* Java Standard Library
[a]How would you implement harder difficulties and levels? Would you have more objects to balance or objects that are harder to balance?
[b]Will there be a final level where something special happens once you beat it? Will you be able to go back ad replay levels once you beat the game?
[c]How does the tilting of the phone control the movement of the items?
[d]Would you also be able to have the choice to play it on a computer or will it be specifically a mobile game? I believe making it a choice would give more freedom to the user and would not restrict them.
[e]You could also make game levels randomly generated, so that you can keep playing it and have a different game setup each time.
[f]With this, you could also make a simpler version that just displays the time as you play without needing to display stars when you complete the level.