import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class OptionFrameTesting {
	
	enum Option{
		ASK,
		CONFIRM,
		END,
		INSULT
	}
	
	static String[] negatives = {"no", "cancel", "stop", "cease", "quit", "leave"};

	static JFrame parent;
	static JButton button;
	
	static URL url;
	
	static Icon icon = new ImageIcon("./Testing/GameThing/Images/player.png");
	static Option state;
	static String name;
	
	public static void main(String[] args) throws IOException {
        url = new URL("https://www.lopoterracotta.com/wp-content/uploads/2013/10/WX6341-188x180.jpg");

        URLConnection connection = new URL(url.toString()).openConnection();
        connection
                .setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();
    
        BufferedImage c = ImageIO.read(url);
        icon = new ImageIcon(c);
		
		parent = new JFrame();
		button = new JButton();
		
		state = Option.ASK;

		button.setText("click the brick");
		button.setIcon(icon);
		parent.add(button);
		parent.pack();
		parent.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainLoop();
			}
		});
	}
	
	public static void ask() {
		boolean match = false;
		name = JOptionPane.showInputDialog(parent,"What is your name?", null);
		if(name!=null) {
			for(String t:negatives){
				if(name.contains(t)) {
					match = true;
					break;
				}
			}
			if(!match){
				state = Option.CONFIRM;
				mainLoop();
			}
		}
		parent.setVisible(false);
	}
	
	public static void confirm() {
		int choice = JOptionPane.showConfirmDialog(parent, "So your name is "+name+"?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(choice==0) {
			state = Option.END;
			mainLoop();
		}else {
			state = Option.ASK;
			mainLoop();
		}
	}
	
	public static void end() {
		JOptionPane.showMessageDialog(parent, "Hello "+name+"!");
		state = Option.ASK;
	}
	
	public static void insult() {
		JOptionPane.showMessageDialog(parent, "That's a dumb name.");
		state = Option.ASK;
	}
	
	public static void mainLoop() {
		switch(state) {
		case ASK:
			ask();
			break;
		case CONFIRM:
			confirm();
			break;
		case END:
			end();
			break;
		case INSULT:
			insult();
			break;
		}
	}
}
