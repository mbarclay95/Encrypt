package ecrypt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{
	private JPanel p;
	private JTextArea textArea;
	private JTextField textField;
	private JScrollPane scroll;
	String string;
	private Font font = new Font("Courier", Font.BOLD,19);
	public MainFrame()
	{
		super("Encryption");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setLayout(new BorderLayout(0,0));
		setContentPane(p);
		
		textField = new JTextField();
		p.add(textField, BorderLayout.SOUTH);
		textField.setFont(font);
		textField.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       string = (textField.getText());
		       LetterEncryption e1 = new LetterEncryption();
				MatrixEncryption m = new MatrixEncryption();
				LetterBreaker lb = new LetterBreaker();
				print("The message is: " + string);
				string = e1.Encrypt(string, 13);
				print("\n" + string + "\n");
				print(lb.breakString(string));
				print("\nThe message with letter encryption is: " + string);
				//string = e1.Decrypt(string);
				print("The decrypted message is: " + string);
				string = m.Encrypt(string);
				print("\nThe message with matrix encryption is: " + string);
				string = m.Decrpyt(string);
				print("The decrypted message is: " + string + "\n\n");
		    }
		}); 
		
		scroll = new JScrollPane();
		p.add(scroll,BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(font);
		scroll.setViewportView(textArea);
		print("Enter a message.\n");
		setVisible(true);
	}
	
	
	public void print(String text1)
	{
		textArea.append(text1+"\n");
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
		LetterEncryption e1 = new LetterEncryption();
		MatrixEncryption m = new MatrixEncryption();
		LetterBreaker l = new LetterBreaker();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a message: ");
		String string = input.nextLine();
		System.out.println("Enter your Key: ");
		int key = input.nextInt();
		System.out.println("The message is: " + string);
		string = e1.Encrypt(string, key);
		System.out.println("\nThe message with letter encryption is: " + string);
		System.out.println("\nThe broken hash code is:\n");
		l.breakString(string);
		string = e1.Decrypt(string, key);
		System.out.println("The decrypted message is: " + string);
//		
//		string = m.Encrypt(string);
//		System.out.println("\nThe message with matrix encryption is: " + string);
//		string = m.Decrpyt(string);
//		System.out.println("The decrypted message is: " + string);
	}
}
