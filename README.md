# SpeedRunBrowser [Test project]
Browser for http://www.speedrun.com

## Requirements
You must develop an Android app that shows the world records speedruns. Your task is to
extract the information from http://www.speedrun.com using its api:
http://www.speedrun.com/api/v1/games.
The app must:
- Show a list with the games. You must show the game logo and the game name.
There is no need to implement pagination.
- When you select a game in the list, it must open a new screen containing information
of the first run in the api runs list. The screen must contain:
  - a button to see the video in an outside app,
  - the name of the player (if there is more than one, you must show only the first
  player’s name),
  - the time of that run,
  - the game logo and,
  - the game name.
