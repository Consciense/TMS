
//        Номером документа является строка, состоящая из букв и цифр(без служебных символов).
//        Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
//        Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum(далее любая последовательность букв/цифр)
//        или contract(далее любая последовательность букв/цифр).
//        Написать программу для чтения информации из входного файла - путь к входному файлу должен задаваться через консоль.

//        Программа должна проверять номера документов на валидность.
//        Валидные номера документов следует записать в один файл-отчет.

//        Невалидные номера документов следует записать в другой файл-отчет, но после номеров документов следует добавить
//        информацию о том, почему этот документ не валиден

import java.util.Scanner;

public class DocumentValidation implements FileOperations {
    public static void solveTask() {
        String pathname = getUserInput().nextLine();
        //String pathname = "C:\\Users\\mrjj9\\IdeaProjects\\TMS\\src\\documents.txt";
        String text = null;
        try {
            text = FileOperations.readTextFromFile(pathname).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        splitInfo(text);
    }

    public static void splitInfo(String text) {
        if (text.isEmpty() || text.trim().isEmpty()) {
            System.out.println("Your file is empty!");
            return;
        }
        String[] documents = text.split("\r\n");
        StringBuilder correctDocNames = new StringBuilder();
        StringBuilder incorrectDocNames = new StringBuilder();
        ValidationInfo document;

        for (String string : documents) {
            document = checkInfo(string);
            if (document.isCorrect())
                correctDocNames.append(string).append("\n");
            else
                incorrectDocNames.append(string).append(" (").append(document.getMessage()).append(")").append("\n");

            FileOperations.addTextToFile(incorrectDocNames.toString(), "incorrect.txt");
            FileOperations.addTextToFile(correctDocNames.toString(), "correct.txt");
        }
        System.out.println("Validation completed. Check you files for more info.");
    }

    static Scanner getUserInput() {
        System.out.println("Input path to your file...");
        return new Scanner(System.in);
    }

    public static ValidationInfo checkInfo(String string) {
        ValidationInfo info = new ValidationInfo();
        if (string.length() != 15) {
            info.setCorrect(false);
            info.setMessage("Incorrect document name length...");
            return info;
        } else if (!(string.startsWith("docnum") || string.startsWith("contract"))) {
            info.setCorrect(false);
            info.setMessage("Document name must start with either docnum or contract...");
            return info;
        } else if (!string.matches("[A-Za-z0-9]{15}")) {
            info.setCorrect(false);
            info.setMessage("Document name contains unwanted symbols...");
        }
        return info;
    }
}
