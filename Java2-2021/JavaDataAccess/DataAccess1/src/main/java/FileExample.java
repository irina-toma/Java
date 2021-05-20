import java.io.*;

public class FileExample {
    private void writeInFile(Person person, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(person.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Person readFromFile(String fileName) {
        Person person = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String personStr = br.readLine();
            br.close();
            String[] splitStr = personStr.split(";");
            person = new Person(splitStr[0], Integer.parseInt(splitStr[1]), splitStr[2]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return person;
        }

    }

    public static void main(String[] args) {
        FileExample ex1 = new FileExample();
        ex1.writeInFile(new Person("Irina", 12, "abcd"), "irina.txt");
        Person irina = ex1.readFromFile("irina.txt");

        System.out.println(irina);
    }
}
