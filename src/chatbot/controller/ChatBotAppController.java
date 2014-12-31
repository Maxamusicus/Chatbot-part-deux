// Chatbot 1.00
// Max Geiger 2014

package chatbot.controller;

import java.util.Random;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{

	private ChatbotView appView;
	private Chatbot myBot;
	private String startMessage;
	private ChatbotFrame baseFrame;
	private boolean random = new Random().nextInt(100) == 0;

	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);

		myBot = new Chatbot("Max's Chatbot");
		if (random)
		{
			startMessage = "[ Chatbot ]: That was pretty lucky.";
		}
		else
		{
			startMessage = "[ Chatbot ]: My name is " + myBot.getName() + " What's up?";
		}
	}

	public ChatbotFrame getBaseFrame()
	{
		return baseFrame;
	}

	public Chatbot getBot()
	{
		return myBot;
	}

	public String sendTextToChatBot(String userInput)
	{
		String respondText;
		respondText = myBot.processText(userInput);
		return respondText;
	}


	public void start()
	{
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
	}
}