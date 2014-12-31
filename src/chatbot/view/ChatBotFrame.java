// Chatbot 1.00
// Max Geiger 2014

package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotAppController;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;

	public ChatbotFrame(ChatbotAppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(360, 300);
		this.setResizable(false);
		this.setVisible(true);
	}

}
