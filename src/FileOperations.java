import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public interface FileOperations {

    static StringBuilder readTextFromFile(String filePathname) throws Exception {

        File textFile = new File(filePathname);
        if (!textFile.isFile() || !textFile.canRead())
            throw new Exception("Is not a file or file is unavailable for reading... ");

        try (FileInputStream input = new FileInputStream(textFile)) {
            StringBuilder stringFromFile = new StringBuilder();
            stringFromFile.append(convertToString(input.readAllBytes()));
            return stringFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void addTextToFile(String text, String filePathname) {
        File longestWordTXT = new File(filePathname);
        try (FileOutputStream output = new FileOutputStream(longestWordTXT)) {
            byte[] buffer = text.getBytes();
            output.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static String convertToString(byte[] array){
       return new String(array);
    }
}
