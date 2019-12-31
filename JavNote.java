import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

class JavNote extends JFrame {
    /* Text Editor */
    private JTextArea editor = new JTextArea(100, 100);
    private JFileChooser dialog = 
	new JFileChooser(System.getProperty("user.dir"));
    private String fileName = "";

    /* constructor */
    public JavNote() {
	
    }
}

