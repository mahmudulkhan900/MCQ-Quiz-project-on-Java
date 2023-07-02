import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class CreatingQuizAdmin {
    public void createQuiz() throws IOException, ParseException {
        String quizFile = "./src/main/resources/quiz.json";
        Boolean flag = true;



        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(quizFile));
        int count = jsonArray.size();



        while (flag) {
            JSONObject jsonObject = new JSONObject();


            Scanner input = new Scanner(System.in);


            System.out.print("\nEnter question: ");
            String question = input.nextLine();
            jsonObject.put("question", question);

            System.out.print("Enter option 01: ");
            String option = input.nextLine();
            jsonObject.put("option 01", option);

            System.out.print("Enter option 02: ");
            option = input.nextLine();
            jsonObject.put("option 02", option);

            System.out.print("Enter option 03: ");
            option = input.nextLine();
            jsonObject.put("option 03", option);

            System.out.print("Enter option 04: ");
            option = input.nextLine();
            jsonObject.put("option 04", option);

            System.out.print("What is the answer key? ");
            String answerKey = input.nextLine();
            jsonObject.put("answerKey", answerKey);

            jsonArray.add(jsonObject);

            System.out.print("Press 's' for adding another question, 'q' to quit: ");
            String quit = input.next();
            if (quit.equals("q")) {
                flag = false;
            }
            System.out.println("\nYou have total "+ ++count +" question(s) till now.");

        }

        FileWriter fw = new FileWriter(quizFile);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();

    }
}

