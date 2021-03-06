import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class Notepad extends JFrame {
    private JTextArea editor = new JTextArea(20, 50);
    private String fileName = "";
    private Font font = new Font("Arial", Font.PLAIN, 12);

    Action openAction = new AbstractAction("Open") {
	    public void actionPerformed(ActionEvent event) {
		openFile();
	    }
	};
    
    Action saveActionInstant = new AbstractAction("Save") {
	    public void actionPerformed(ActionEvent event) {
	        saveInstant(fileName);
	    }
	};

    Action saveActionNewFile = new AbstractAction("Save file as...") {
	    public void actionPerformed(ActionEvent event) {
	        saveNewFile();
	    }
	};

    Action exitAction = new AbstractAction("Close all") {
	    public void actionPerformed(ActionEvent event) {
		exitApp();
	    }
	};

    // constructor
    public Notepad(String openFile) {
	changeTitle(fileName);
	if (openFile.length() > 0)
	    overwrite(openFile);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(new JScrollPane(
	    editor,
	    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
	    ), BorderLayout.CENTER);
	JMenu fileMenu = new JMenu("File");
	fileMenu.add(openAction);
	fileMenu.add(saveActionInstant);
	fileMenu.add(saveActionNewFile);
	fileMenu.add(exitAction);
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(fileMenu);
	setJMenuBar(menuBar);
	setVisible(true);
	pack();
    }

    private void changeTitle(String title) {
	if (title.length() < 1)
	    setTitle("Untitled");
	else
	    setTitle(title);
    }

    private void exitApp() {
	int status = 
   	    JOptionPane.showConfirmDialog
       	    (null, 
	     "Close all opened files? Files won't be saved.", 
       	     "Warning", 
       	     JOptionPane.YES_NO_OPTION);
       	if (status == JOptionPane.YES_OPTION)
       	    System.exit(0);
    }

    // overwrite text area with new file
    private void overwrite(String openFile) {
	try {
	    FileReader fileReader = new FileReader(openFile);
	    editor.read(fileReader, null);
	    fileReader.close();
	    fileName = openFile;
	    changeTitle(openFile);
	}
	catch (IOException exception) {
	    JOptionPane.showMessageDialog(this, "File not found.");
	}
    }

    private void openFile() {
        JFileChooser fileChooser = 
	    new JFileChooser(System.getProperty("user.dir"));
	int status = fileChooser.showOpenDialog(null);
	if (status == JFileChooser.APPROVE_OPTION) {
	    new Notepad(fileChooser.getSelectedFile().getAbsolutePath());
	}
    }

    // save file as...
    private void saveNewFile() {
        JFileChooser fileChooser = 
	    new JFileChooser(System.getProperty("user.dir"));
	int status = fileChooser.showSaveDialog(null);
	if (status == JFileChooser.APPROVE_OPTION) {
	    String saveName = fileChooser.getSelectedFile().getAbsolutePath();
	    fileName = saveName;
	    changeTitle(fileName);
	    saveInstant(saveName);
	}
    }

    // save
    private void saveInstant(String saveName) {
	// if invalid file name
	if (fileName.length() < 1) {
	    saveNewFile();
	}
	else {
	    try {
		FileWriter fileWriter = new FileWriter(fileName);
		editor.write(fileWriter);
		fileWriter.close();
	    }
	    catch (IOException exception) {}
	}
    }

    public String getFileName() {
	return fileName;
    }
}