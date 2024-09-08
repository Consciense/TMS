import javax.swing.*;

/**
 * @implNote This is a MUST task for everyone on TMS
 * <ol>
 *     <li>
 *         Task 1. Make it possible to add numbers, not replace (123, 567)
 *     </li>
 *     <li>
 *         Task 2. Make it possible to calculate the string 4*4, 4/1, 4%3 by working with the string
 *     </li>
 *     <li>
 *         Task 3. Activate button equals that will trigger calculation process
 *     </li>
 * </ol>
 */

public class TestCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
