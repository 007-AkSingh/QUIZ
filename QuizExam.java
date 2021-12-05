import java.awt.event.*;  // Import all necessary gui packages for the project
import java.awt.*;
import javax.swing.*;

public class QuizExam implements ActionListener{  // We'll need ActionListener interface for project
	
	String[] questions =   {  // Initialize the array of string to store all the questiions
			                    "Which Company created Java?",
			                    "Which yar was Java created?",
			                    "What was Java originally called?",
			                    "Who is credited with creating Java?"
	                        };
	
	String[][] options = {  // Initialize the 2D array of string to store all the options
		                     {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
		                     {"1989", "1996", "1972", "1492"},
		                     {"Apple", "Latte", "Oak", "koffing"},
		                     {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerberg"}
	                     };
	
	char[] answers = {  // Initialize the array of Character of string to store option initials as A,B,C,D
			              'A',
			              'B',
			              'C',
			              'D'
			              
	                 };
	
	// Define all the variables required of data type like char, int 
	char guess;
	char answer;
	int index; 
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 10;
	
	JFrame frame = new JFrame();  // Initialize the j frame 
	JTextField textfield = new JTextField();  //Initialize the text field
	JTextArea textarea = new JTextArea();  // Initialize the text area
	JButton buttonA = new JButton();// Initialize all the buttons required
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JLabel answer_labelA = new JLabel(); // Initialize all the labels required
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();

    JLabel time_label = new JLabel();  // create two labels for timer
    JLabel seconds_left = new JLabel();
    
    JTextField number_right = new JTextField();//Initialize the text fields
    JTextField percentage = new JTextField();
    
    
    Timer timer = new Timer(1000, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
				
			}
		}
	});
	
	public QuizExam() {   // create a constructor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50,50,50));  // To color the panel or backgroud with dark we use 50,50,50 as the parameter
		frame.setLayout(null);
		frame.setResizable(false);  // as we don't want the user o adjust the size of the frame so resizable is false 
		
		textfield.setBounds(0,0,650,50);  //set bound will place the text field where we want in our case parameter is given w.r.t rectangle 
		textfield.setBackground(new Color(25,25,25));  // to set color of the bg 
		textfield.setForeground(new Color(25, 255, 0));  //to set the fg color
		textfield.setFont(new Font("Ink Free", Font.BOLD, 30)); // set the font as per our convinience
		textfield.setBorder(BorderFactory.createBevelBorder(1));  // set the border 
		textfield.setHorizontalAlignment(JTextField.CENTER);  // to align the text field in the center horizontally
	    textfield.setEditable(false);
	    //textfield.setText("testing text");
	    
	    textarea.setBounds(0,50,650,50);  //to set all the rquirements of text area 
	    textarea.setLineWrap(true);  // in case text reaches the end of the line it will wrap and move to next line
	    textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25, 255, 0));
		textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
	    textarea.setEditable(false);
	    
	    buttonA.setBounds(0,100,100,100);  // set the bound of button a and position it w.r.t. rectangle 
	    buttonA.setFont(new Font("MV Boli", Font.BOLD,25));  // set the font u want
	    buttonA.setFocusable(false); // sometimes on clicking the button it gets highlighted so set focusable will prevent it
	    buttonA.addActionListener(this); // add action listener interface 
	    buttonA.setText("A"); // set the text as A for the first button and change further for B,C,D
	    
	    buttonB.setBounds(0,200,100,100);
	    buttonB.setFont(new Font("MV Boli", Font.BOLD,25));
	    buttonB.setFocusable(false);
	    buttonB.addActionListener(this);
	    buttonB.setText("B");
	    
	    buttonC.setBounds(0,300,100,100);
	    buttonC.setFont(new Font("MV Boli", Font.BOLD,25));
	    buttonC.setFocusable(false);
	    buttonC.addActionListener(this);
	    buttonC.setText("C");
	    
	    buttonD.setBounds(0,400,100,100);
	    buttonD.setFont(new Font("MV Boli", Font.BOLD,25));
	    buttonD.setFocusable(false);
	    buttonD.addActionListener(this);
	    buttonD.setText("D");
	    
	    
	    answer_labelA.setBounds(125,100,500,100);  // set the bounds for answer label w.r.t. rectangle
	    answer_labelA.setBackground(new Color(50,50,50));  // set the bg color for answer label
	    answer_labelA.setForeground(new Color (25,255,0));  // set the fg color 
	    answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));// set the font anwer label
	    //answer_labelA.setText("Testing label 1");
	    
	    answer_labelB.setBounds(125,200,500,100);
	    answer_labelB.setBackground(new Color(50,50,50));
	    answer_labelB.setForeground(new Color (25,255,0));
	    answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
	    //answer_labelB.setText("Testing label 2");
	    
	    answer_labelC.setBounds(125,300,500,100);
	    answer_labelC.setBackground(new Color(50,50,50));
	    answer_labelC.setForeground(new Color (25,255,0));
	    answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
	    //answer_labelC.setText("Testing label 3");
	    
	    answer_labelD.setBounds(125,400,500,100);
	    answer_labelD.setBackground(new Color(50,50,50));
	    answer_labelD.setForeground(new Color (25,255,0));
	    answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
	    //answer_labelD.setText("Testing label 4");
	    
	    seconds_left.setBounds(535,510,100,100);  // set the bounds of seconds 
	    seconds_left.setBackground(new Color(25,25,25));  // set bg color
	    seconds_left.setForeground(new Color(255,0,0)); // set fg color
	    seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60)); // set the font as we want
	    seconds_left.setBorder(BorderFactory.createBevelBorder(1));  // set the border 
	    seconds_left.setOpaque(true);
	    seconds_left.setHorizontalAlignment(JTextField.CENTER);  // set the text field in horizontal in center
	    seconds_left.setText(String.valueOf(seconds)); // set the seconds text 
	    
	    
	    time_label.setBounds(535,475,100,25);
	    time_label.setBackground(new Color(50,50,50));
	    time_label.setForeground(new Color(255,0,0));
	    time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
	    time_label.setHorizontalAlignment(JTextField.CENTER);
	    time_label.setText("timer >:D");  // set text of the timer
	    
	    number_right.setBounds(225,225,200,100);
	    number_right.setBackground(new Color(25,25,25));
	    number_right.setForeground(new Color(25,255,0));
	    number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
	    number_right.setBorder(BorderFactory.createBevelBorder(1));
	    number_right.setHorizontalAlignment(JTextField.CENTER);
	    number_right.setEditable(false);
	    
	    percentage.setBounds(225,325,200,100);
	    percentage.setBackground(new Color(25,25,25));
	    percentage.setForeground(new Color(25,255,0));
	    percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
	    percentage.setBorder(BorderFactory.createBevelBorder(1));
	    percentage.setHorizontalAlignment(JTextField.CENTER);
	    percentage.setEditable(false);
	    
	      // Add everything initialized above in the frame
	    
	    frame.add(time_label);
	    frame.add(seconds_left);
	    frame.add(answer_labelA);
	    frame.add(answer_labelB);
	    frame.add(answer_labelC);
	    frame.add(answer_labelD);
	    frame.add(buttonA);
	    frame.add(buttonB);
	    frame.add(buttonC);
	    frame.add(buttonD);
	    frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {  // As we need a method to move to next question 
		if(index>=total_questions) {  // use if condition to call result once questions are over
			results();
		}
		else {  // else keep on incrementing the next questions with options 
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]); // place the question
			answer_labelA.setText(options[index][0]);  // place all the options 
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {  // Anything related to button clicking is going to go within this actionperformed method
		
		buttonA.setEnabled(false);  // if someone clicks the button it must work like submitting
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {  // To match the clicked button using if condition
			answer='A';
			if(answer ==answers[index]) {  // To check the answer if right or not using condition 
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonB) {
			answer='B';
			if(answer ==answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonC) {
			answer='C';
			if(answer ==answers[index]) {
				correct_guesses++;
			}
		}
		
		if(e.getSource()==buttonD) {
			answer='D';
			if(answer ==answers[index]) {
				correct_guesses++;
			}
		}
		
		displayAnswer();
		
	}
	public void displayAnswer() {  // We'll want to display the correct answer so create a displayanswer method
		
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')   // To print red color for wrong answer
			answer_labelA.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'B') 
			answer_labelB.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'C') 
			answer_labelC.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'D') 
			answer_labelD.setForeground(new Color(255, 0, 0));
		
		
		Timer pause = new Timer(1000, new ActionListener(){  // timer will execute after every 2 seconds
			@Override
			public void actionPerformed(ActionEvent e) {
				answer_labelA.setForeground(new Color(25, 255, 0));
				answer_labelB.setForeground(new Color(25, 255, 0));
				answer_labelC.setForeground(new Color(25, 255, 0));
				answer_labelD.setForeground(new Color(25, 255, 0));
				
				answer = ' ';
				seconds = 10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);//enable all the buttons
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				
				index++;
				nextQuestion();
			}
		});
		
		pause.setRepeats(false);
		pause.start();
	}
	
	public void results() {  // We also want to display the final results so define result method
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);  // logic to print the value of answer 
		
		textfield.setText("Results!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
		
	}
}
