import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLContentReadingTesting {
    static URL url;
    static ImageIcon icon;

    static String name;

    static JButton button;
    static JFrame parent;
    static JOptionPane optionPane;

    public static void main(String[] args) throws IOException {
         url = new URL("https://shark.tobot.dev/"); 


        URLConnection connection = new URL(url.toString()).openConnection();
        connection
                .setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();

        BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(),
        Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());
    
        /*BufferedImage c = ImageIO.read(url);
        icon = new ImageIcon(c);

        parent = new JFrame();
        button = new JButton(icon);

        optionPane = new JOptionPane();

        button.setText("Click for Dialog");
        button.setIcon(icon);
        parent.add(button);
        parent.pack();
        parent.setVisible(true);*/
    }
}
