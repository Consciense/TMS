import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerClass implements ActionListener {
    private final JTextField textField;
    private StringBuilder equation;
    private boolean isEmpty = true;
    private int parenthesisCounter = 0;

    public ActionListenerClass(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String letter;
        JButton button = (JButton) e.getSource();
        letter = button.getText();
        if (!letter.equals("C") && !letter.equals("←") && !letter.equals("=") && !letter.equals("(") && !letter.equals(")") ) {
            addToTextField(button);
        }
        if (letter.equals("C")) {
            clearTopPanel();
        }
        if (letter.equals("←")) {
            pressBackspace();
        }
        if (letter.equals("=")) {
            pressEquals();
        }
        if (letter.equals("(") || letter.equals(")")){
            addParenthesis(button);
        }
    }

    void addToTextField(JButton button) {
        if (equation == null) {
            equation = new StringBuilder();
        }
        String textFromButton = button.getText();
        if (isEmpty && !isMathSymbolPressed(textFromButton) && !textFromButton.equals(",")) {
            addToEquation(textFromButton);
            return;
        } else if (isEmpty && textFromButton.equals(",")) {
            addToEquation("0,");
            return;
        } else if (isEmpty && textFromButton.equals("-")) {
            addToEquation(textFromButton);
            return;
        } else if (isEmpty && isMathSymbolPressed(textFromButton)) {
            return;
        }

        if (!isEmpty && !isMathSymbolPressed(textFromButton) && !textFromButton.equals(",")) {
            addToEquation(textFromButton);
        } else if (!isEmpty && textFromButton.equals(",") && !isLastSymbolInLineIsMathSymbol()) {
            addToEquation(textFromButton);
        } else if (!isEmpty && textFromButton.equals(",") && isLastSymbolInLineIsMathSymbol()) {
            addToEquation("0,");
        } else if (!isEmpty && isMathSymbolPressed(textFromButton) && !isLastSymbolInLineIsMathSymbol() && equation.charAt(equation.length() - 1) != '(') {
            addToEquation(textFromButton);
        } else if (!isEmpty && isMathSymbolPressed(textFromButton) && (isLastSymbolInLineIsMathSymbol())) {
            equation.deleteCharAt(equation.length() - 1);
            addToEquation(textFromButton);
        } else if (!isEmpty && isMathSymbolPressed(textFromButton) && equation.charAt(equation.length() - 1) == '(') {
            equation.deleteCharAt(equation.length() - 1);
            equation.deleteCharAt(equation.length() - 1);
            addToEquation(textFromButton);
        }
    }

    void addToEquation(String textFromButton) {
        isEmpty = false;
        equation.append(textFromButton);
        textField.setText(equation.toString());
    }

    void clearTopPanel() {
        equation = null;
        isEmpty = true;
        textField.setText("0");
    }

    void pressBackspace() {
        if (isEmpty) {
            return;
        }
        equation.deleteCharAt(equation.length() - 1);
        textField.setText(equation.toString());
    }

    boolean isMathSymbolPressed(String textFromButton) {
        return textFromButton.equals("^") || textFromButton.equals("+") || textFromButton.equals("-")
                || textFromButton.equals("×") || textFromButton.equals("/") || textFromButton.equals(",");
    }

    boolean isLastSymbolInLineIsMathSymbol() {
        return (equation.charAt(equation.length() - 1) == '^') || (equation.charAt(equation.length() - 1) == '+') ||
                (equation.charAt(equation.length() - 1) == '-') || (equation.charAt(equation.length() - 1) == '×') ||
                (equation.charAt(equation.length() - 1) == '/');
    }

    void pressEquals() {
        if (isEmpty) {
            return;
        }
        while (isLastSymbolInLineIsMathSymbol() || equation.charAt(equation.length() - 1) == ',' || equation.charAt(equation.length() - 1) == '(')
            pressBackspace();
        while (parenthesisCounter != 0){
            addToEquation(")");
            parenthesisCounter--;
        }

        addToEquation("=" + CalculateFromString.calculateEquation(equation));
        textField.setText(String.valueOf(equation));
        equation = null;
        isEmpty = true;
    }
    void addParenthesis(JButton button){
        if (isEmpty && button.getText().equals("(")) {
            equation = new StringBuilder();
            addToEquation("(");
            parenthesisCounter++;
            return;
        } else if (isEmpty && button.getText().equals(")")) {
            return;
        }
        if (!isEmpty && button.getText().equals("(") && isLastSymbolInLineIsMathSymbol()){
            addToEquation("(");
            parenthesisCounter++;
        } else if (!isEmpty && button.getText().equals("(") && !isLastSymbolInLineIsMathSymbol() && equation.charAt(equation.length() - 1) != '(') {
            return;
        } else if (!isEmpty && button.getText().equals("(") ) {
            addToEquation("(");
            parenthesisCounter++;
        }
        if (!isEmpty && button.getText().equals(")") && !isLastSymbolInLineIsMathSymbol() && parenthesisCounter != 0 && equation.charAt(equation.length() - 1) != '(') {
            addToEquation(")");
            parenthesisCounter--;
        }
    }
}
