import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class Notepad extends JFrame {
    private JTextArea editor = new JTextArea(20, 50);
    private JFileChooser fileChooser = 
	new JFileChooser(System.getProperty("user.dir"));
    private String fileName = "";
    private Font font = new Font("Arial", Font.PLAIN, 12);

    // constructor
    public Notepad() {
	setTitle(fileName);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(new JScrollPane(
	    editor,
	    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
	    ), BorderLayout.CENTER);
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(new JMenu("File"));
	setJMenuBar(menuBar);
	setVisible(true);
	pack();
    }

    // save file as...
    private void saveNewFile() {
    }

    // save
    private void saveInstant() {
	FileWriter fileWriter = new FileWriter();
	editor.write(filewriter);
	filewriter.close();
    }
}