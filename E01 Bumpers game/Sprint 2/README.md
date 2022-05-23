### Bumpers Sprint 2
Bumpers is a small single-player game in which the player aims to destroy all other cars on the gameboard. You can find more details in the [Bumpers Problem Statement]().

#### Status of the Application
This code already contains all Backlog items of sprint 1. You don't have to implement these again. Two Backlog Itmes of sprint 2, Items 2 and 7, have already been implemented. The player is now able to steer the red player car with his mouse. Cars can crash into each other. For each car collision, there is exactly one loser and one winner car.

#### Your Task
Implement Backlog item 12! Import the Maven project into your IDE and take a look at the open TODOs. Complete all TODOs, test your code and upload your solution. You don't have to add any new classes to solve this task.

##### Sprint 2 Backlog

 - __Backlog Item 02: Cars collide with each other and each collision has a winning car__
 - __Backlog Item 07: The player steers the car with the mouse__
 - __Backlog Item 12: A crash sound and/or animation plays when two cars collide__

Extend the implementation of the method moveCars() in the GameBoard. Take a look at the provided methods of the AudioPlayerInterface.

##### Additional change requests
_Change the crash sound_

Configure your own crash sound. In order to add a new sound, drag and drop your own audio file into the resources folder. Make sure to use an .au, .wav or .mp3 file. Then, modify the AudioPlayer’s CRASH_SOUND_FILE variable to use your audio file instead.

Hints:

After adding new files to your project you also have to push these to the remote repository.
Always use the AudioPlayer provided by the GameBoard via getAudioPlayer(), do not create own new instances.