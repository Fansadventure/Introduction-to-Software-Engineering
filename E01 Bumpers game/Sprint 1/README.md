### Bumpers Sprint 1
Bumpers is a small single-player game in which the player aims to destroy all other cars on the gameboard. You can finde more details in the [Bumpers Problem Statement]().

#### Status of the Application
The template gives you all the required classes for this exercise. The game is not completed yet, don't worry if your cars don't move initially.

#### Your Task
Implement all backlog items for this sprint! Import the Maven project into your IDE and take a look at the open TODOs. Complete all TODOs, test your code and upload your solution. You don't have to add any new classes to solve this task.

#### Sprint 1 Backlog

* **Backlog Item 1: Cars drive on the game board**

    This item is already implemented. Take a look at the method moveCars() of the GameBoard. The functionality will be visible as soon as Backlog Item 4 is implemented.
* **Backlog Item 4: The player starts and stops the game**

    The GameBoard contains the two methods startGame() and stopGame(). Implement them and make sure that the value of running is always correct.
* **Backlog Item 5: Music plays when the game begins and stops to play when the game ends**

    Implement the methods playMusic() and stopMusic() and make sure they are called correctly. Take a look at the methods provided by the AudioPlayerInterface.

#### Additional Change Requests

* ** Backlog Item 14: Choose a different fast car image **
    
    In order to add a new image, drag and drop your own file into the resources folder. Then modify the FastCar’s FAST_CAR_IMAGE_FILE variable to use your own file instead.
* ** Backlog Item 15: Choose a different game music **

    Choose a new background music and update the variable BACKGROUND_MUSIC_FILE in AudioPlayer accordingly. Make sure to use an .au, .wav or .mp3 file.

Hints:

After adding new files to your project you also have to push these to the remote repository.
Always use the AudioPlayer provided by the GameBoard via getAudioPlayer(), do not create own new instances.