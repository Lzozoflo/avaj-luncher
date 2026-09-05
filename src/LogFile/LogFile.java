package src.LogFile;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile {

    private static LogFile INSTANCE = null;
    private FileWriter fw;

    private LogFile(){
        try {
            fw = new FileWriter("simulation.txt");
        } catch (IOException e) {
            System.out.print("Catch an error: ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public final static LogFile getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LogFile();
        return INSTANCE;
    }

    public final void writeLog(String str) {
        try {
            INSTANCE.fw.write(str);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public final void close() throws IOException {
        try {
            INSTANCE.fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}

