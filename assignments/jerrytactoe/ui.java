import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ui extends JFrame {
	public final int NONE;
	public final int COMPUTER;
	public final int USER;
	
	public static void main(String[] args) {
		ui UI = new ui();
	}
	
	public ui() {
		JButton[] spots = new JButton[9];
		setTitle("Jerry Tac Toe";)
		setSize(500,500);
	}
	
	public bool changeText(JButton button, String text) {
		if(button.getText().equals(null))
			button.setText(text);
		else
			JOptionPane.showMessageDialog(ui,"Cannot select this space.");
	}
}