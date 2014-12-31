// Chatbot 1.00
// Max Geiger 2014

package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private int numberOfChats;
	private ChatbotUser myUser;

	private ArrayList<String> memeList;
	private ArrayList<String> userInputList;

	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();

		fillTheMemeList();


		myUser = new ChatbotUser();
	}

	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation = "This is what you typed after my name: ";
		nameConversation.concat(currentInput.substring(currentInput.indexOf(this.getName()) + this.getName().length(), currentInput.length() - 1));
		return nameConversation;
	}

	private boolean contentChecker(String input)
	{
		boolean containsWord = false;
		if (input.contains("may-mays"))
		{
			containsWord = true;
		}
		return containsWord;
	}

	private void fillTheMemeList()
	{
		memeList.add("ayy lmao");
		memeList.add("that time when");
		memeList.add("Wowza Wow");
		memeList.add("eyy bb");
		memeList.add("mkay");
		memeList.add("cats");
	}

	public String getName()
	{
		return name;
	}

	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	private String introduceUser(String input)
	{
		String userQuestion = "";

		if (numberOfChats == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Hello, " + myUser.getUserName() + ".\n[ ChatBot ]: How old are you?";
		}
		else if (numberOfChats == 1)
		{
			try
			{
				int userAge = Integer.parseInt(input);
				myUser.setAge(userAge);
				userQuestion = "Wow " + myUser.getUserName() + ", " myUser.getAge() + " is pretty old!\n" + "[ ChatBot ]: How much do you weigh?";
			}
			catch (NumberFormatException e)
			{
				userQuestion = "Can you repeat that?";
				numberOfChats--;
			}
		}
		else if (numberOfChats == 2)
		{
			try
			{
				double userWeight = Double.parseDouble(input);
				myUser.setWeight(userWeight);
				userQuestion = "Fantastic " + myUser.getUserName() + ".\n[ ChatBot ]: Do you like music?";
			}
			catch (NumberFormatException e)
			{
				userQuestion = "Can you say that again?";
				numberOfChats--;
			}
		}
		else if (numberOfChats == 3)
		{
			input = input.toLowerCase();
			boolean lovesMusic = Boolean.parseBoolean(input);
			boolean playsPiano = Boolean.parseBoolean(input);
			input = input.toLowerCase();
			if (input.toLowercase.contains("yes"))
			{
				lovesMusic = true;
				myUser.setPlaysPiano(true);
			}
			else if (input.toLowercase.contains("no"))
			{
				lovesMusic = false;
				myUser.setPlaysPiano(false);
			}
			else
			{
				userQuestion = "What was that?";
				numberOfChats--;
				return userQuestion;
			}

			if (lovesMusic)
			{
				userQuestion = "I like music, too, " + myUser.getUserName() + "!\n[ ChatBot ]: Do you play any music?";
			}
			else
			{
				userQuestion = "That is too bad" + "!\n[ ChatBot ]: Do you play any music?";
				;
			}
			myUser.setLovesMusic(lovesMusic);
		}
		else
		{
			boolean playsPiano = Boolean.parseBoolean(input);
			input = input.toLowerCase();
			if (input.contains("yes"))
			{
				playsPiano = true;
				myUser.setPlaysPiano(true);
			}
			else if (input.contains("no"))
			{
				playsPiano = false;
				myUser.setPlaysPiano(false);
			}
			else
			{
				userQuestion = "You didn't answer the question.";
				numberOfChats--;
				return userQuestion;
			}
			if (playsPiano)
			{
				userQuestion = "That's cool, what instrument do you play?";
			}
			else
			{
				userQuestion = "That's too bad, what instrument is your favorite?";
			}
		}
		return userQuestion;
	}

	private boolean memeChecker(String currentText)
	{
		boolean foundAMeme = false;
		for (String currentMeme : memeList)
		{
			if (currentText.contains(currentMeme) || currentText.equalsIgnoreCase(currentMeme))
			{
				foundAMeme = true;
			}
		}
		return foundAMeme;
	}

	private boolean nameChecker(String currentText)
	{
		boolean nameMentioned = false;
		if (currentText.contains("Max's Chatbot"))
		{
			nameMentioned = true;
		}
		return nameMentioned;
	}

	private String noNameConversation(String currentInput)
	{
		String notNamed = "";
		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) (smallRandom + (Math.random() * currentInput.length() / 2)) + 1;
		notNamed = "Here, have some stuff: " + currentInput.substring(smallRandom, largerRandom);
		return notNamed;
	}

	public String processText(String currentInput)
	{
		String result = "";

		if (numberOfChats < 5)
		{
			result = introduceUser(currentInput);
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = randomChatConversation(currentInput);
		}
		else
		{
			result = "Hey! You didn't say anything!";
		}
		numberOfChats++;
		return result;
	}

	public String randomChatConversation(String userText)
	{
		System.out.println("\n[Input]: " + userText);

		String processedText = null;
		numberOfChats++;

		int randomChoice = (int) (Math.random() * 4);


		if (userText != "" && userText != null)
		{

			if (userText.equalsIgnoreCase("Quit"))
			{
				System.out.println("Quitting");
				System.exit(0);
			}


			else if (userText.equalsIgnoreCase("help"))
			{

				System.out.println("Opened Help");
				processedText = "Chatbot help:\n";
				processedText += "help - Display this message.\n";
				processedText += "Quit: End the Chatbot\n";
			}

			else if (randomChoice == 0)
			{
				System.out.println("Ran Check: String");
				if (stringChecker(userText))
				{
					numberOfChats++;
					processedText = "Woah! Write a little less next time.";
				}
				else
				{
					numberOfChats++;
					processedText = "You're a real conversation killer. Write a little more next time.";
				}
			}

			else if (randomChoice == 1)
			{
				
				if (contentChecker(userText))
				{
					numberOfChats++;
					processedText = "I see you like memes...";
				}
				else
				{
					numberOfChats++;
					processedText = "Do you like memes?";
				}
			}

			else if (randomChoice == 2)
			{
				if (memeChecker(userText))
				{
					numberOfChats++;
					processedText = "Hey " + userText + " is a meme!";
				}

				else
				{
					numberOfChats++;
					processedText = "y u no meme?";
				}
			}

			else if (randomChoice == 3)
			{
				if (nameChecker(userText))
				{
					processedText = "That's my name.";
				}
				else
				{
					processedText = "They call me " + userText + ". That's not my name!";
				}
			}
		}
		return processedText;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private boolean stringChecker(String input)
	{
		boolean longText = false;
		int textLength = input.length();
		if (textLength >= 50)
		{
			longText = true;
		}
		return longText;
	}
}