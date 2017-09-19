package tictactoe;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class View extends JFrame{
    JButton[] button;
    JButton newGame;
    JLabel indicator;


    public View(){
        initComponents();
        setLayout();
        setVisible(true);
        pack();
        setTitle("Tic Tac Toe");
        setResizable(false); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents(){
        this.button = new JButton[9];
        for (int i = 0;i<this.button.length;i++) {
            this.button[i] = new JButton(" ");

        }
        this.indicator = new JLabel("X");
        this.newGame = new JButton("Clear");
        this.newGame.setEnabled(false);

    }

    private void setLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

       layout.setAutoCreateGaps(true);
       layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(newGame, GroupLayout.Alignment.CENTER)
                .addComponent(indicator, GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button[0])
                        .addComponent(button[1])
                        .addComponent(button[2]))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button[3])
                        .addComponent(button[4])
                        .addComponent(button[5]))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button[6])
                        .addComponent(button[7])
                        .addComponent(button[8])
        )));

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(newGame)
            .addComponent(indicator)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addComponent(button[0])
                    .addComponent(button[3])
                    .addComponent(button[6]))
                .addGroup(layout.createParallelGroup()
                    .addComponent(button[1])
                    .addComponent(button[4])
                    .addComponent(button[7]))
                .addGroup(layout.createParallelGroup()
                    .addComponent(button[2])
                    .addComponent(button[5])
                    .addComponent(button[8])
        )));
    }

    public void changePlayer() {
        String newPlayer = reverseValue(getCurrentPlayerString());
        this.indicator.setText(newPlayer);
    }

    public void winGame() {
        this.indicator.setText(getCurrentPlayerString() + " Congratulations!");
        for(JButton button : this.button) {
            button.setEnabled(false);
        }
        endGame();
    }

    public String reverseValue(String value) {
        if("X".equals(value)) {
            return "O";
        } else if("O".equals(value)) {
            return "X";
        }
        return null;
    }

    public Player reverseValue(Player value) {
        if(value == Player.X) {
            return Player.O;
        } else if (value == Player.O) {
            return Player.X;
        }
        return null;
    }

    public Player getCurrentPlayerValue() {
         if("X".equals(this.indicator.getText())) {
            return Player.X;
        } else if("O".equals(this.indicator.getText())) {
            return Player.O;
        }
         return null;
    }

    public String getCurrentPlayerString() {
         if("X".equals(this.indicator.getText())) {
            return "X";
        } else if("O".equals(this.indicator.getText())) {
            return "O";
        }
         return null;
    }

    void resetGame() {
        this.indicator.setEnabled(true);
    }
    void setNoWinner() {
        this.indicator.setText(null);
    }
    void endGame() {
        this.newGame.setEnabled(true);
    }

}
