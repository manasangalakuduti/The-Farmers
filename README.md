# TheFarmers
This project is a group application for a farming game. It is supposed to be able to allow a player to purchase tools, grow crops and sell their harvest and get more money.

## File Structure -- Milestone 2 (iteration 1)
The structure of our code is arranged as follows:

**TheFarmers**
* src
  * sample
    * backend - classes that aren't displays themselves but have information and functions that can and will be used throughout the game and will be displayed
    * frontend - most often display classes that are applications in JavaFX
    * media - media includes photos used for backgrounds in our frontend
  * tests - has our testrunner class that runs our JUnit tests, marked in various separate files.

## JUnit Test Writeups -- Milestone 2 (iteration 1)
### Valentin Stelea
The two tests I made had to do with testing the most likely edge cases for when the user is inputting a name in the configuration screen textbox. The two most possible edge cases I came up with are ensuring the textbox is not empty (length != 0), and that the String does not begin with a space (“ ”). I was contemplating having a third edge case where the String cannot begin with a number, however I decided that if for some very unlikely reason the user's name contains or starts with a number, that that would be deemed acceptable. My tests verify that these edge cases are accounted for by verifying that the output done by the input validator method outputs what it should when it encountered the edge cases, and by having my JUnit tests pass when I give it both a valid and invalid input means that the method works and accounts for the edge cases correctly. There was no need to test a null case as the application does not continue if the text field is not used properly.

### Karthik Subramanian
The two tests I made had to do with testing the functionality of the Player and Date classes. One test I made dealt with testing for updates to the player’s balance in the case that the player can purchase an item. This JUnit test is very important because when the Player accumulates enough money to purchase more seeds, we want to make sure that the player has the most updated balance at the time of purchase so that the appropriate functions operate on the correct parameters. The second test I made dealt with testing for the current date of the Date object. After the user enters the name, selects difficulty, starting seed, starting season, the initial Farm UI screen pops up and the current date is recorded. I developed a JUnit test that tests if the current date is the date that is shown on the Farm UI screen when the Player starts the game. Since this test case passed with the current state of the application, in later milestones, we hope to test for a real-time update of time.

### Sidharta Vadaparty
For the FarmUITest.java, I created three test functions centered around the Player class. Despite it being named FarmUITest.java, based on one of our frontend programs, I performed tests on the backend class Player because the player is highly integrated into the FarmUIscreen class, so it needs to work properly in every iteration. The first of these three tests I programmed are testPlayerConstructorName(), which checks that the initialization of the name attribute for a player is set correctly. Next, I designed two functions related to the Player class’s purchaseObject(double price) method. This method not only adjusts a Player object’s balance, but also determines whether or not a purchase goes through, returning a boolean. Therefore, I had to design two tests: testPurchaseSuccess and testPurchaseFailure. These methods test examples of purchases that would and would not go through, respectively. In later iterations, the purchaseObject method will become more crucial and more carefully designed as it will play a role not just in balance maintenance, but also inventory adjustments.

### Manas Angalakuduti
The first test I created is to verify the correct timestamp of the game. If the time in the game and the actual current time are not the same, then the test should fail. If both of these timestamps are equal, then the test should run perfectly. Even though we imported LocalDate and LocalTime, there might be a scenario where the timestamps do not line up, therefore causing an error. The second test I created is verifying that the season and the date are linked up. For example, if the user selects “Winter” for their starting season, then the date cannot be sometime in July. This test compares the month with the starting season to ensure the month is within the starting season. This test will be used in future iterations of our project when we implement the ability for the date to start at a certain day rather than the real-life current date.

### Connor Cole
In plot test, we chose to test the functionality of the getter and setter methods defined to confirm they would perform as expected. This included initializations of the seed names and coordinates of each seed. These tests were chosen as they will be fundamental building blocks for the future game’s code. Figuring out which plots display what and updating according were the two chosen to look into, later tests will have similar tests to ensure the button click works as we want it to (at the moment, it’s just a dummy scene for clicks, so this test was not added yet). The code verifies that both the coordinates and the names store values as we want, and allows us to update those values too.
