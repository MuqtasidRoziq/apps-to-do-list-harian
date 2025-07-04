package serialization;
import java.io.*;

/**
 *
 * @author muqta
 */
public class serialization {
    public static void serializeToFile(Object obj, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
             new FileOutputStream(filename))) {
            oos.writeObject(obj);
        }
    }

    public static Object deserializeFromFile(String filename) 
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
             new FileInputStream(filename))) {
            return ois.readObject();
        }
    }
}
