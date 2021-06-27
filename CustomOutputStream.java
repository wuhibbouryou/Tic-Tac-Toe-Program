
package tictactoe;

/**
 *
 * @author wuhib
 * This program is used to change the default output screen from the console
 * to the JFrame pop up window
 */
import java.io.IOException;
import java.io.OutputStream;
 
import javax.swing.JTextArea;
 

public class CustomOutputStream extends OutputStream {
    private JTextArea jTextArea1;
     
    public CustomOutputStream(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        jTextArea1.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }
}