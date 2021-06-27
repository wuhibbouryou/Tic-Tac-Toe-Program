
package tictactoe;

/**
 *
 * @author wuhib
 */


import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class gameBoard extends javax.swing.JFrame {

    /**
     * Creates new form gameBoard
     */
    
    
    static int userChoice;
    static String userInput;
    static String userName;
    static String[] board = {"1","2","3","4","5","6","7","8","9"};
    static CountDownLatch startSignal = new CountDownLatch(1);
    
    //initiates the popup window and all of its components
    public gameBoard() {
        initComponents();
    }
    
    //prints the tic tac toe board onto the popup window
    static void printBoard()
    {
        
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        
    }
    
    
    //function to check whether or not a player has won the game
    public static String isWinner(){
        for (int a = 0; a < 8; a++) {
            String line = null;
            
            //iterate through every possible win condition (i.e. verticle, horazontal, diagonal)
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
              
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        return null;
    }
    
    public static void excecute() throws InterruptedException{
        
            System.out.println("Welcome to the Tic Tac Toe Program! Please enter your name: ");
            
            //This makes the program wait until the "Enter" button is pressed by the player
            startSignal.await();
            //Reset the button press countdown timer
            startSignal = new CountDownLatch(1);
            
            System.out.println("Alright " + userName + ", you'll be facing a computer as your opponent. Good luck!\n");
            printBoard();
            
            //keeps track of how many spots remain on the board
            int spotsLeft = 9;
            
            //Runs as long as no winner is found and more spaces remain
            while(!(isWinner()=="X" || isWinner()=="O" || spotsLeft == 0)){
                
                //random num generator so that the computer can make a selection
                Random num = new Random();
                int x = num.nextInt(9);
                
                
                System.out.println("It's your turn!!!");
                System.out.println("Please enter your choice:");
                
                //wait for button press
                startSignal.await();
                startSignal = new CountDownLatch(1);
                
                //Makes the user redo their selection if it was already chosen
                while(board[userChoice-1]== "X" || board[userChoice-1]== "O"){
                    
                System.out.println("Invalid choice. Please try again:");
                startSignal.await();
                startSignal = new CountDownLatch(1);
                
                }
                startSignal = new CountDownLatch(1);
                board[userChoice-1] = "X";
                spotsLeft -= 1;
                
                
                //clears the screen and reprints the board
                screen.setText("");
                printBoard();
                //ends the game if X has won
                if (isWinner()=="X"){
                System.out.println("Congratulations "+userName+"! You Won!");
                return;
                }
                
                
                //checks to see if any spots remain before computer makes a selection
                if(spotsLeft!=0){
                System.out.print("The computer is choosing...3");
                sleep(700);
                System.out.print("...2");
                sleep(700);
                System.out.print("...1");
                sleep(700);
                
                //checks to see if computer selection was already chosen, then reselects
                while((board[x]== "O") || (board[x] == "X")){
                    x= num.nextInt(9);
                
                }
                board[x] = "O";
                spotsLeft -= 1;
                screen.setText("");
                printBoard();
                }
                
            
            }
            
            
            if (isWinner()=="O"){
                System.out.println("Uhoh. Seems like the computer beat you to it.");
            }
            else
            {
                System.out.println("HAHA, its a draw!");
            }
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        input = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        screen = new javax.swing.JTextArea();
        enter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        screen.setEditable(false);
        screen.setBackground(new java.awt.Color(204, 204, 204));
        screen.setColumns(20);
        screen.setRows(5);
        screen.setFocusable(false);
        jScrollPane1.setViewportView(screen);

        enter.setText("Enter");
        enter.setActionCommand("");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });
        enter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enterKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(input)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input)
                    .addComponent(enter, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        
        //checks to see if the user left the text field blank
        userInput = input.getText();
        if(userInput.isBlank()){return;}

        //If the user hasnt input their name yet, retrieve their name and end function
        if(userName == null){
        userName = input.getText();
        
        //makes the timer count down and allows the program to run if it is waiting
        startSignal.countDown();
        //clears the text in the input box
        input.setText("");
        return;
        }
        
        //converts string to int
        userChoice = Integer.parseInt(userInput);
        //makes sure that the user is not inputting numbers out of the range of 1-9
        if(userChoice > 9 || userChoice < 1 ){
            System.out.println("That is not a valid choice. Please try again!");
            input.setText("");
            return;
        
        }
        
        startSignal.countDown();
        input.setText("");
    }//GEN-LAST:event_enterActionPerformed

    private void enterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameBoard().setVisible(true);
            }
        });
        //wait for the JFrame window to pop up
        sleep(1000);
        
        //this is used to print everything onto the popup window instead of the default console
        PrintStream printStream = new PrintStream(new CustomOutputStream(screen)); 

        // re-assigns standard output stream and error output stream 
        System.setOut(printStream); 
        System.setErr(printStream);
        
        
        //start the tic tac toe program
        excecute();
        
        System.out.println("Thanks for playing! Bye");
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enter;
    private static javax.swing.JTextField input;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea screen;
    // End of variables declaration//GEN-END:variables
}
