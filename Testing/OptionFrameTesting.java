import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OptionFrameTesting{
    static String name;

    static JButton button;
    static JFrame parent;

    static JOptionPane optionPane;
    static Icon icon = new ImageIcon("C:\\Users\\Owner\\Pictures\\Smug little bastard.jpg");

    enum State{
        ASK,
        CONFIRM,
        END
    }

    static State currentState = State.ASK;
    public static void main(String[] args){
        parent = new JFrame();
        button = new JButton(icon);

        optionPane = new JOptionPane();

        button.setText("Click for Dialog");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);
        //parent.setSize(1000, 750);

        button.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                mainLoop();
            }
        });
    }

    public static void mainLoop(){
        switch(currentState){
            case ASK:
                ask();
                break;
            case CONFIRM:
                confirm();
                break;
            case END:
                end();
                break;
        }
    }

    public static void ask(){
        optionPane.setIcon(icon);
        name = JOptionPane.showInputDialog(parent, "What is your name?", null);
        if(name!=null){
            currentState = State.CONFIRM;
            mainLoop();
        }
        parent.setVisible(false);
    }

    public static void confirm(){
        int choice = JOptionPane.showConfirmDialog(parent, "So your name is "+name+"?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if(choice==0){
            currentState = State.END;
        }else{
            currentState = State.ASK;
        }
        mainLoop();
    }

    public static void end(){
        JOptionPane.showMessageDialog(parent, "Hello "+name, "Welcome", JOptionPane.INFORMATION_MESSAGE, null);
        parent.setVisible(false);
    }
}