import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




public class CreateUserLogin {
    public static void main(String[] args) throws IOException, ParseException {
        String filePath = "./src/main/resources/users.json";


        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));


        JSONObject adminObject = new JSONObject();
        adminObject.put("username", "admin");
        adminObject.put("password", "1234");
        adminObject.put("role", "admin");

        JSONObject studentObject = new JSONObject();
        studentObject.put("username", "salman");
        studentObject.put("password", "1234");
        studentObject.put("role", "student");

        jsonArray.add(adminObject);
        jsonArray.add(studentObject);


        FileWriter fw = new FileWriter(filePath);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();

    }
}


















