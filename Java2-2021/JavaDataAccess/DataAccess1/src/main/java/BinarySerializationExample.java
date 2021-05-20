import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinarySerializationExample {
    private Person readFromFile(String fileName) {
        Person person = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            person = (Person)ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return person;
        }
    }

    private void writeInFile(Person person, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream ob = new ObjectOutputStream(fos);
            ob.writeObject(person);
            ob.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BinarySerializationExample ex2 = new BinarySerializationExample();
        ex2.writeInFile(new Person("Irina", 12, "abcd"), "irina.txt");
        Person irina = ex2.readFromFile("irina.txt");

        System.out.println(irina);

    }
}
