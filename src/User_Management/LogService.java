/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User_Management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogService {
    // Convert LocalDateTime → epoch milliseconds → binary
    public static String toBinary(LocalDateTime time) {
        long epochMilli = time.atZone(java.time.ZoneId.systemDefault())
                              .toInstant()
                              .toEpochMilli();
        return Long.toBinaryString(epochMilli);
    }

    // Auto-increment logID (L001, L002, ...)
    public static String getNextLogId() {

        File file = new File("C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\data\\LogDB.txt");
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {   // <-- IGNORE EMPTY LINES
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.format("L%03d", count + 1);
    }

    // Main log writing function
    public static void writeLog(String userId, LocalDateTime loginTime, LocalDateTime logoutTime) {
        String logID = getNextLogId();
        String loginBinary = toBinary(loginTime);
        String logoutBinary = toBinary(logoutTime);

        try (FileWriter fw = new FileWriter("C:\\Users\\yu en\\OneDrive\\Documents\\Y2S1\\OODJ\\Assignment\\data\\LogDB.txt", true)) {
            fw.write("\n" + logID + "," + userId + "," + loginBinary + "," + logoutBinary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
