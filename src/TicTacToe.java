import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    // determine who turn it is first
    Random random = new Random();
    JFrame frame = new JFrame ();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    //create constructor for class
    TicTacToe() throws InterruptedException {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800,800);
    frame.getContentPane().setBackground(new Color(50,50,50));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);

    textfield.setBackground(Color.DARK_GRAY);
    textfield.setForeground(Color.green);
    textfield.setFont(new Font("Ink Free",Font.BOLD,75));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Tic-Tac-Toe");
    textfield.setOpaque(true);

    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0,0,800,100);


    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color(150,150,150));

    //since we're dealing with an array of buttons we can create a for loop to take care of buttons 1-9
        for (int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }


        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
// create a for loop that runs 9 times everytime a button is clicked
        for(int i = 0; i <9; i++) {
            if(e.getSource()==buttons[i]){
                if(player1_turn) {
                    if(Objects.equals(buttons[i].getText(), "")){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else{
                    if(Objects.equals(buttons[i].getText(), "")){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }

                }
            }
        }
    }
    //create a method to determine who turn is first
    public void firstTurn() throws InterruptedException {

        Thread.sleep(2000);
        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    // check to see if any player has currently won
    public void check() {
//check x winning conditions
        if (
                        (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[2].getText(), "X")) )
                    {
                        xWins(0,1,2);

        }

        if (
                        (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X")) )
        {
            xWins(3,4,5);

        }
        if (
                        (Objects.equals(buttons[6].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X")) )
        {
            xWins(6,7,8);

        }
        if (
                        (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X")) )
        {
            xWins(0,3,6);

        }
        if (
                        (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X")) )
        {
            xWins(1,4,7);

        }
        if (
                        (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X")) )
        {
            xWins(2,5,8);

        }
        if (
                        (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X")) )
        {
            xWins(0,4,8);

        }
        if (
                        (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X")) )
        {
            xWins(2,4,6);

        }

        //check O winning conditions
        if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[2].getText(), "O")) )
        {
            oWins(0,1,2);

        }

        if (
                (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O")) )
        {
            oWins(3,4,5);

        }
        if (
                (Objects.equals(buttons[6].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O")) )
        {
            oWins(6,7,8);

        }
        if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O")) )
        {
            oWins(0,3,6);

        }
        if (
                (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O")) )
        {
            oWins(1,4,7);

        }
        if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O")) )
        {
            oWins(2,5,8);

        }
        if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O")) )
        {
            oWins(0,4,8);

        }
        if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O")) )
        {
            oWins(2,4,6);

        }
    }

    //set parameters what buttons did users press to win games
    public void xWins(int a, int b, int c){
// passed in as an argument
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        //disable all buttons so people cant keep playing
        for(int i = 0; i<9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Winner");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        //disable all buttons so people cant keep playing
        for(int i = 0; i<9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Winner");
    }
}
