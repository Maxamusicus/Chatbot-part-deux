// Chatbot 1.00
// Max Geiger 2014


package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;

public class ChatbotView
{
	private ChatbotAppController baseController;

	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}

	public String displayChatbotConversations(String input)
	{
		String output = "";
		output = JOptionPane.showInputDialog(null, input);
		return output;
	}

	public void displayInformation(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}
