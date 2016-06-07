# number-guessing-game

The game works as follows:

    The user chooses a number in his mind and types “ready” to indicate to the computer that he is ready to begin playing.

    The computer asks a series of questions to arrive at the number the user has in mind. The user can only respond with “higher”,
    “lower” or “yes”.

    The game ends when the user responds with “yes” or “end”.


If you simply want to clone the repo and play, you can run do so with:

    git clone git@github.com:srinivas1988/number-guessing-game.git
    cd number-guessing-game
    mvn clean install -DskipTests


Use the following maven command to play Number Guessing Game.
    mvn exec:java