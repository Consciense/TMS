import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements CalculateFromString {
    private JTextField textField;

    public Calculator(){
        super("Calculator");
        setLayout(new BorderLayout());
        add(setTopPanel(), BorderLayout.NORTH);
        add(setBodyPanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setVisible(true);
    }
    JPanel setTopPanel (){
        JPanel topPanel = new JPanel();
        textField = new JTextField("0");
        textField.setEditable(false);
        topPanel.setPreferredSize(new Dimension(400,70));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(textField, BorderLayout.CENTER);
        return topPanel;
    }

    JPanel setBodyPanel (){
        String[] buttonText = new String[]{ "C", "(", ")", "×", "7", "8", "9", "/", "4", "5", "6", "+", "1", "2", "3", "-", "0", ",", "←", "="};
        JPanel body = new JPanel();
        ActionListener onClick = new ActionListenerClass(textField);
        body.setLayout(new GridLayout(5,4));
        for (String text : buttonText) {
            JButton button = new JButton(String.valueOf(text));
            button.addActionListener(onClick);
            body.add(button);
        }

        return body;
    }
}
