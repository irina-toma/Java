import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;

public class JSONExample {
    private void writeInFile(Person person, String fileName) {
        try {
            JSONObject json = new JSONObject();
            json.put("name", person.getName());
            json.put("age", person.getAge());
            json.put("pid", person.getPid());

            FileWriter file = new FileWriter(fileName);
            file.write(json.toJSONString());
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Person readFromFile(String fileName) {
        Person person = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject)parser.parse(new FileReader(fileName));
            person = new Person(
                    jsonObj.get("name").toString(),
                    Integer.parseInt(jsonObj.get("age").toString()),
                    jsonObj.get("pid").toString()
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return person;
        }

    }

    public static void main(String[] args) {
        JSONExample ex4 = new JSONExample();
        ex4.writeInFile(new Person("Irina", 12, "abcd"), "irina.json");
        Person irina = ex4.readFromFile("irina.json");

        System.out.println(irina);
    }
}
