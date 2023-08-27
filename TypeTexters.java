import java.util.*;
import java.awt.*;
import hsa.Console;
public class TypeTexters2
{
    static Console c;
    static Console c1;
    public static void main (String[] args)
    {
	c = new Console ();
	c1 = new Console (10, 55);
	char repeat;
	titleGraphics ();

	while (true)
	{
	    String wordMain, userInput;
	    int numOfLetters = 1, lives = 3, level = 1;
	    int counter = 30; //max num of letters possible in word



	    for (int i = 1 ; i < counter ; i++) //loop to generate the words
	    {

		mainGraphics ();
		wordMain = CreateWord (numOfLetters, counter); //stores word created in method 'CreateWord'
		livesAndLevel (lives, level);
		wordMovement (wordMain); //moves the generated word
		userInput = userWord (); //gets user input


		//checks if the word recieved from user in 'userWord' method mathches generated word
		if (userInput.equals (wordMain))
		{
		    c.setColor (Color.black);
		    c.drawString ("" + level, 85, 20);
		    level++;
		    numOfLetters++;
		}
		else //removing lives when user enters the word incorrectly
		{
		    c.setColor (Color.black);
		    c.drawString ("" + lives, 570, 20);
		    lives--;
		}
		levelCounter (level, lives);



		if (lives == 0 || level == 30)
		{
		    endScreen (lives, level);
		    break; //exits out of loop when lives equals 0
		}
	    }


	    repeat = c1.getChar ();
	    c1.clear (); //clears
	}

    } //end of main



    public static String CreateWord (int numOfLetters1, int counter1)
    {

	String wordMain1 = "";

	String[] randomStrings = new String [counter1]; //array for storing each word
	Random random = new Random (); //creating variable to randomize


	for (int i = 1 ; i < counter1 ; i++) //loop to generate the words
	{

	    char[] word = new char [numOfLetters1];  //an array for deciding the number of letters in the generated word

	    for (int j = 0 ; j < word.length ; j++) //creates the word
	    {
		word [j] = (char) ('a' + random.nextInt (26)); //generates a random letter in the alphabet
	    }
	    randomStrings [i] = new String (word); //assigns the created word to the i value of randomStrings
	    wordMain1 = randomStrings [i];
	}
	return wordMain1;
	//returns generated word to main method


    } //end of CreateWord


    public static void livesAndLevel (int lives1, int level1)
    {
	c.setColor (Color.yellow);
	c.drawString ("" + level1, 85, 20); //display level
	c.setColor (Color.green);
	c.drawString ("" + lives1, 570, 20); //display lives

    } //end of livesAndLevel method


    public static void titleGraphics ()
    {
	Font ft4 = new Font ("Ariel", Font.BOLD + Font.ITALIC, 50); //font for title
	c.setFont (ft4); //sets title font


	//fills console black
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);

	//integer variables, for x coordinates of title, and speed it travels
	int x2 = 0, xSpeed1 = 1, x3 = 630, yTitle = -20;
	//while loop that runs until "Type" reaches desired position
	while (x2 < 160)
	{
	    c.setColor (Color.white);
	    c.drawString ("Type", x2, 90);
	    slowDown (5);
	    c.setColor (Color.black);
	    c.drawString ("Type", x2, 90);
	    x2 = x2 + xSpeed1;
	}
	//redraws "Type" in white after movement is done
	c.setColor (Color.white);
	c.drawString ("Type", 160, 90);
	//while loop that runs until "Blasters" reaches desired position
	while (x3 > 330)
	{
	    c.setColor (Color.white);
	    c.drawString ("Blasters", x3, 90);
	    slowDown (5);
	    c.setColor (Color.black);
	    c.drawString ("Blasters", x3, 90);
	    x3 = x3 - xSpeed1;
	}
	//redraaws "Blasters" in white after movement is done
	c.setColor (Color.white);
	c.drawString ("Blasters", 330, 90);




	//code for animating a blue beam that rises from the botttom of the middle of the screen
	for (int x4 = 590 ; x4 > 120 ; x4--)
	{
	    c.setColor (Color.blue);
	    c.fillOval (300, x4, 60, 60);
	    slowDown (5);
	}
	for (int x4 = 590 ; x4 > 120 ; x4--)
	{
	    c.setColor (Color.black);
	    c.fillRect (300, x4, 60, 60);
	    slowDown (5);
	}
	//draws a "2" after the beam animation is complete
	c.setColor (Color.white);
	c.drawString ("2", 315, 180);
	slowDown (3000);

	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);

	c.setColor (Color.yellow);
	c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	//left arm
	c.fillRect (50, 285, 25, 45);
	//right arm
	c.fillRect (215, 285, 25, 45);
	//left leg
	c.fillRect (80, 335, 45, 25);
	//right leg
	c.fillRect (165, 335, 45, 25);

	c.setColor (Color.black);
	//mouth
	c.drawLine (125, 300, 165, 300);
	//eyes
	c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.setColor (Color.white);
	c.fillOval (105, 253, 7, 7);
	c.fillOval (170, 253, 7, 7);

	c.fillOval (115, 263, 4, 4);
	c.fillOval (180, 263, 4, 4);

	//levelStory
	Color color3;
	color3 = new Color (66, 227, 136);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color3);
	c.drawString (". . . . .", 260, 100);
	slowDown (2000);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("OH NO! the agency has been hacked into...", 260, 150);
	slowDown (2000);
	c.drawString ("We dont have access to any important files", 240, 200);
	slowDown (2000);
	c.drawString ("The only way to get them back is to solve all the puzzles", 260, 250);
	slowDown (2000);
	c.drawString ("It is your assignment to save the agency", 240, 300);

	for (int z = 0 ; z < 8 ; z++)
	{
	    for (int x = 620 ; x > -20 ; x--)
	    {
		c.setColor (Color.black);
		c.fillOval (x, yTitle, 50, 50);
		slowDown (2);


	    }
	    yTitle = yTitle + 50;
	}
	startUp ();
    } //end of titleGraphics method


    //method for game startup
    public static void startUp ()
    {
	char searchKey; //variable for getting letter from user
	//page 1
	c1.println ("Welcome to TYPE BLASTERS 2\n\n\n\n\n\n\n");
	c1.println ("Click any key for next page...");
	searchKey = c1.getChar ();
	c1.clear ();
	//page 2
	c1.println ("The objective of this game is to memorize the word that\ncrosses the screen\n");
	c1.println ("When the word reaches the other side of the screen, you\nwill be asked to type out the generated word\n\n\n");
	c1.println ("Click any key for next page...");
	searchKey = c1.getChar ();
	c1.clear ();
	//page 3
	c1.println ("If you correctly type out the word you will advance to the next level\nHowever, if you are incorrect a life will be lost\n");
	c1.println ("You are given 3 lives at the start of the game and the length of the word generated increases for each level\ncompleted\n");
	c1.println ("Click any key for next page...");
	searchKey = c1.getChar ();
	c1.clear ();
	//page 4
	c1.println ("Once you lose all your lives the game is over\n\n\n\n\n\n\n");
	c1.println ("Click any key for next page...");
	searchKey = c1.getChar ();
	c1.clear ();

	//page 5
	c1.println ("Before you begin, you may want to move this console\noutside the game :)\n");
	c1.println ("Are you ready to begin [y]es,[n]o ?");
	searchKey = c1.getChar ();

	//error trapping if user does not select "yes"
	while (searchKey != 'y')
	{
	    c1.println ("You must always be ready [y]es,[n]o ?");
	    searchKey = c1.getChar ();
	}
	c1.clear (); //clears screen
    }


    public static void mainGraphics ()
    {
	Font ft = new Font ("Ariel", Font.BOLD, 20);
	c.setFont (ft);

	//draws background with lives and level display
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);
	//level and lives display
	c.setColor (Color.yellow);
	c.drawString ("Level:", 25, 20);
	c.setColor (Color.green);
	c.drawString ("Lives:", 510, 20);

    } //end of titleGraphics


    public static void levelCounter (int gameLevel, int gameLives)
    {

	if (gameLives != 0)
	{
	    if (gameLevel == 3)
	    {
		level3Story ();
	    }
	    else if (gameLevel == 6)
	    {
		level6Story ();
	    }
	    else if (gameLevel == 10)
	    {
		level10Story ();
	    }
	    else if (gameLevel == 15)
	    {
		level15Story ();
	    }
	    else if (gameLevel == 30)
	    {
		level30Story ();
	    }

	}

    } //end of levelCounter method


    public static void level3Story ()
    {
	int ylv3 = -20;
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);


	//stick figure
	c.setColor (Color.yellow);
	//face
	c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	//left arm
	c.fillRect (50, 285, 25, 45);
	//right arm
	c.fillRect (215, 285, 25, 45);
	//left leg
	c.fillRect (80, 335, 45, 25);
	//right leg
	c.fillRect (165, 335, 45, 25);

	c.setColor (Color.black);
	//mouth
	c.drawLine (125, 300, 165, 300);
	//eyes
	c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.setColor (Color.white);
	c.fillOval (105, 253, 7, 7);
	c.fillOval (170, 253, 7, 7);

	c.fillOval (115, 263, 4, 4);
	c.fillOval (180, 263, 4, 4);


	//display message
	Color color4;
	color4 = new Color (232, 116, 28);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color4);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("Nice work! You're almost there!", 260, 150);
	slowDown (2000);
	c.drawString ("You are at level 3", 240, 200);
	slowDown (2000);
	c.drawString ("About 10% of the files have been recovered", 260, 250);
	slowDown (2000);
	c.drawString ("We are counting on you special agent", 240, 300);

	for (int z = 0 ; z < 8 ; z++)
	{
	    for (int x = 620 ; x > -20 ; x--)
	    {
		c.setColor (Color.black);
		c.fillOval (x, ylv3, 50, 50);
		slowDown (2);


	    }
	    ylv3 = ylv3 + 50;
	}
    }


    public static void level6Story ()
    {
	int ylv6 = -20;
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);
	//stick figure
	c.setColor (Color.red);
	c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	//left arm
	c.fillRect (50, 285, 25, 45);
	//right arm
	c.fillRect (215, 285, 25, 45);
	//left leg
	c.fillRect (80, 335, 45, 25);
	//right leg
	c.fillRect (165, 335, 45, 25);

	c.setColor (Color.black);
	//mouth
	c.drawLine (125, 300, 165, 300);
	//eyes
	c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.setColor (Color.white);
	c.fillOval (105, 253, 7, 7);
	c.fillOval (170, 253, 7, 7);

	c.fillOval (115, 263, 4, 4);
	c.fillOval (180, 263, 4, 4);


	//display message
	Color color5;
	color5 = new Color (232, 28, 140);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color5);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("WOW you made it to level 6!", 260, 150);
	slowDown (2000);
	c.drawString ("Around 20% of all files have been found", 240, 200);
	slowDown (2000);
	c.drawString ("The puzzles are getting harder", 260, 250);
	slowDown (2000);
	c.drawString ("Good luck special agent", 240, 300);



	for (int z = 0 ; z < 8 ; z++)
	{
	    for (int x = 620 ; x > -20 ; x--)
	    {
		c.setColor (Color.black);
		c.fillOval (x, ylv6, 50, 50);
		slowDown (2);


	    }
	    ylv6 = ylv6 + 50;
	}
    }


    public static void level10Story ()
    {
	int ylv10 = -20;
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);
	//stick figure
	c.setColor (Color.blue);
	c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	//left arm
	c.fillRect (50, 285, 25, 45);
	//right arm
	c.fillRect (215, 285, 25, 45);
	//left leg
	c.fillRect (80, 335, 45, 25);
	//right leg
	c.fillRect (165, 335, 45, 25);

	c.setColor (Color.black);
	//mouth
	c.drawLine (125, 300, 165, 300);
	//eyes
	c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.setColor (Color.white);
	c.fillOval (105, 253, 7, 7);
	c.fillOval (170, 253, 7, 7);

	c.fillOval (115, 263, 4, 4);
	c.fillOval (180, 263, 4, 4);

	//display message
	Color color6;
	color6 = new Color (28, 198, 232);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color6);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("That is some impressive skill", 260, 150);
	slowDown (2000);
	c.drawString ("Level 10 is pretty hard", 240, 200);
	slowDown (2000);
	c.drawString ("30% of the files have been found", 260, 250);
	slowDown (2000);
	c.drawString ("We believe in you", 240, 300);


	for (int z = 0 ; z < 8 ; z++)
	{
	    for (int x = 620 ; x > -20 ; x--)
	    {
		c.setColor (Color.black);
		c.fillOval (x, ylv10, 50, 50);
		slowDown (2);


	    }
	    ylv10 = ylv10 + 50;
	}
    }


    public static void level15Story ()
    {
	int ylv15 = -20;
	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);
	//stick figure
	c.setColor (Color.white);
	c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	//left arm
	c.fillRect (50, 285, 25, 45);
	//right arm
	c.fillRect (215, 285, 25, 45);
	//left leg
	c.fillRect (80, 335, 45, 25);
	//right leg
	c.fillRect (165, 335, 45, 25);

	c.setColor (Color.black);
	//mouth
	c.drawLine (125, 300, 165, 300);
	//eyes
	c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	c.setColor (Color.white);
	c.fillOval (105, 253, 7, 7);
	c.fillOval (170, 253, 7, 7);

	c.fillOval (115, 263, 4, 4);
	c.fillOval (180, 263, 4, 4);


	//display message
	Color color7;
	color7 = new Color (160, 171, 173);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color7);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("LEVEL 15, Awesome work", 260, 150);
	slowDown (2000);
	c.drawString ("You might just be a full time agent", 240, 200);
	slowDown (2000);
	c.drawString ("You're halfway there!", 260, 250);
	slowDown (2000);
	c.drawString ("Don't stop now", 240, 300);


	for (int z = 0 ; z < 8 ; z++)
	{
	    for (int x = 620 ; x > -20 ; x--)
	    {
		c.setColor (Color.black);
		c.fillOval (x, ylv15, 50, 50);
		slowDown (2);


	    }
	    ylv15 = ylv15 + 50;
	}
    }


    public static void level30Story ()
    {
	// display message
	Color color8;
	color8 = new Color (209, 214, 51);
	Font ft5 = new Font ("Ariel", Font.BOLD, 28);
	c.setFont (ft5);
	c.setColor (color8);
	Font ft6 = new Font ("Ariel", Font.BOLD, 13);
	c.setFont (ft6);
	c.drawString ("We have found all the files", 260, 150);
	slowDown (2000);
	c.drawString ("All the hard work is done", 240, 200);
	slowDown (2000);
	c.drawString ("Thank you special agent", 260, 250);
	slowDown (2000);
	c.drawString ("...uh oh, we didn't save the files", 240, 300);
	slowDown (1000);

	while (true)
	{
	    Color color30;
	    color30 = new Color ((int) (256 * Math.random ()), (int) (256 * Math.random ()), (int) (256 * Math.random ()));


	    //stick figure
	    c.setColor (color30);
	    c.fillRect (80, 230, 130, 100); //x coordinate, y coordinate, x length, y length

	    //left arm
	    c.fillRect (50, 285, 25, 45);
	    //right arm
	    c.fillRect (215, 285, 25, 45);
	    //left leg
	    c.fillRect (80, 335, 45, 25);
	    //right leg
	    c.fillRect (165, 335, 45, 25);

	    c.setColor (Color.black);
	    //mouth
	    c.drawLine (125, 300, 165, 300);
	    //eyes
	    c.fillOval (100, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	    c.fillOval (165, 250, 25, 25); //x coordinate, y coordinate, x length, y length
	    c.setColor (Color.white);
	    c.fillOval (105, 253, 7, 7);
	    c.fillOval (170, 253, 7, 7);

	    c.fillOval (115, 263, 4, 4);
	    c.fillOval (180, 263, 4, 4);
	    slowDown (50);

	}
    }


    public static void wordMovement (String generatedWord)  //method for moving the generated words
    {

	int x = 0, y, xSpeed = 1;
	String userInput = "";
	y = (int) (421 * Math.random () + 40); //randomizes the y coordinate of the generated word
	Color color1;
	color1 = new Color (2, 235, 153);
	while (x < 630)
	{
	    c.setColor (color1);
	    c.drawString (generatedWord, x, y);
	    slowDown (8);

	    c.setColor (Color.black);
	    c.drawString (generatedWord, x, y);
	    x = x + xSpeed;

	}
    } //end of wordMovement







    public static String userWord ()
    {
	String userInput1 = ""; //variable to get user's input
	userInput1 = c1.readString ();

	return userInput1; //returns user input to main method
    } //end of userWord method








    public static void endScreen (int lives2, int level2)
    {

	Color color;
	color = new Color (128, 193, 255);

	c.setColor (Color.black);
	c.fillRect (0, 0, 650, 500);
	c.setColor (color);
	c.fillRect (200, 200, 250, 75);
	c.setColor (Color.white);

	Font ft3 = new Font ("Ariel", Font.BOLD + Font.ITALIC, 50);
	c.setFont (ft3);


	c.setColor (Color.white);
	c.drawString ("Type Blasters", 150, 90);
	c.drawString ("2", 300, 160);

	Font ft1 = new Font ("Ariel", Font.BOLD, 35);
	c.setFont (ft1);
	c.drawString ("GAME OVER!", 205, 250);
	Font ft2 = new Font ("Ariel", Font.BOLD, 25);
	c.setFont (ft2);
	c.drawString ("You made it to level " + level2, 200, 310);
	c.setFont (ft1);
	c.drawString ("CLICK ANY KEY TO PLAY AGAIN!", 25, 380);


    } //end of endScreen method








    public static void slowDown (int time)
    {
	try
	{
	    Thread.sleep (time);
	}


	catch (InterruptedException e)
	{
	}
    } //end of slowDown method



} //end of CPT_FINAL_JLO_JOSHM


