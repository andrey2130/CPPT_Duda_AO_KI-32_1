package ki32.duda.Lab2;

import java.io.*;

/**
 * Примітивний логер: кожен виклик відкриває файл, пише рядок і закриває.
 * Це забезпечує коректне завершення без залежності від finalize().
 */
public class LoggerInFile {

    /**
     * Друк повідомлення у файл журналу.
     *
     * @param data текст повідомлення
     */
    public static void printLogToFile(String data) {
        try(FileWriter fileWriter = new FileWriter("Lab2Logger.txt", true)){
            fileWriter.write(data + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


