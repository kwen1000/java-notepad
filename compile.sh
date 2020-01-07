if [ -e JavNote.java ]; then
    if [ -e Notepad.java ]; then
	javac JavNote.java Notepad.java && echo "Compiled."
    else
	echo "Notepad.java not found."
    fi
else
    echo "JavNote.java not found."
fi