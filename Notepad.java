import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class Notepad extends JFrame {
    /* Text Editor */
    private JTextArea editor = new JTextArea(100, 100);
    private JFileChooser dialog = 
	new JFileChooser(System.getProperty("user.dir"));
    private String fileName = "";

    /* constructor */
    public Notepad() {
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(new JMenu("File"));
	setJMenuBar(menuBar);
	setVisible(true);
    }
}