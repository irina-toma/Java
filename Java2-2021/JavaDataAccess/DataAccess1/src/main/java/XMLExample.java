import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLExample {

    private void writeInFile(Person person, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(person);
            encoder.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Person readFromFile(String fileName) {
        Person person = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XMLDecoder decoder = new XMLDecoder(fis);
            person = (Person)decoder.readObject();
            decoder.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return person;
        }

    }

    public static void main(String[] args) {
        XMLExample ex3 = new XMLExample();
        ex3.writeInFile(new Person("Irina", 12, "abcd"), "irina.xml");
        Person irina = ex3.readFromFile("irina.xml");

        System.out.println(irina);
    }

}
