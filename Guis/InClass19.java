import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
public class InClass19 extends JFrame {
	

//a lot of code I barrowed from the in class example 
		
		private JButton Button;
		private JLabel infoLabel;
		private JTextField textField;
		private JTextArea textArea; 
		private FlowLayout layout = new FlowLayout();
		private JTextField kilometers;
		// constructor
		/*public GUIDemo() {
			
		}*/
		public void addComponentsToPane(Container pane) {

	        JPanel panel1 = new JPanel();
	        
	        panel1.setLayout( layout );
	        layout.setAlignment(FlowLayout.LEADING);
	        panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			
	        textField = new JTextField(10);
			panel1.add(textField);
			
		
			class ButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("click")) {
					infoLabel.setText("Button clicked");
					kilometers /= 1.609344;
					infoLabel.setText(kilometers);
					}
				}
				//im extremly confused please help I thought this would work but it is not 
			}
			
			
			// button
			Button = new JButton("Action");
			Button.setActionCommand("click");
			Button.addActionListener(new ButtonListener());
			panel1.add(Button);
			
			// label
			infoLabel = new JLabel("nothing has happened");
			panel1.add(infoLabel);
			
			
			// label for displaying result
			JPanel panel2 = new JPanel();
			panel2.setLayout( layout );
			textArea = new JTextArea(5, 80);
			panel2.add(textArea);
		
			 
		}
		//window
		 private static void createAndShowGUI() {
		        //Create and set up the window.
		        
		       InClass19 frame = new InClass19();
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        //Set up the content pane.
		        frame.addComponentsToPane(frame.getContentPane());
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
		    }
		
		public static void main(String[] args) {
			 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            public void run() {     
		               createAndShowGUI();
		            }
		        });
			
		}
		 //Process the Apply gaps button press
       
            }
		
	

