import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StudentQuiz {
    public void attendQuiz(String username) throws IOException, ParseException {

        String quizFile = "./src/main/resources/quiz.json";
        Boolean flag = true;


        System.out.print("\nWelcome "+username+" to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative " +
                "marking. \nAre you ready? Press 's' for start: ");
        Scanner input = new Scanner(System.in);
        String response = input.next();


        int[] randIndex = new int[10];
        int temp;
        Random rand = new Random();


        while (true) {



            temp = rand.nextInt(29);
            randIndex[0] = temp;


            for (int i = 1; i < 10; i++) {

                temp = rand.nextInt(29);


                for (int j = i - 1; j >= 0; j--) {
                    if (randIndex[j] == temp) {
                        i--;
                        break;
                    } else if (j == 0) {
                        randIndex[i] = temp;

                    }
                }

            }


            int score = 0;


            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(quizFile));


            if (response.equals("s")) {
                for (int p = 0; p < 10; p++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(randIndex[p]);
                    String question = jsonObject.get("question").toString();
                    String op_1 = jsonObject.get("option 01").toString();
                    String op_2 = jsonObject.get("option 02").toString();
                    String op_3 = jsonObject.get("option 03").toString();
                    String op_4 = jsonObject.get("option 04").toString();
                    String answerKey = jsonObject.get("answerKey").toString();

                    int actualAns = Integer.parseInt(answerKey);

                    System.out.println("\nQuestion " + (p + 1) + ": " + question);
                    System.out.println("Option 1: " + op_1);
                    System.out.println("Option 2: " + op_2);
                    System.out.println("Option 3: " + op_3);
                    System.out.println("Option 4: " + op_4);

                    System.out.print("Enter your answer: ");
                    int ansStudent = input.nextInt();

                    if (ansStudent == actualAns) {
                        score++;
                    }
                }
            }


            if (score >= 8) {
                System.out.println("\nExcellent! You have got " + score + " out of 10");
            } else if (score >= 5) {
                System.out.println("\nGood. You have got " + score + " out of 10");
            } else if (score >= 2) {
                System.out.println("\nVery poor! You have got " + score + " out of 10");
            } else {
                System.out.println("\nVery sorry you are failed. You have got " + score + " out of 10");
            }

            System.out.print("\nWould you like to start again? press 's' for start or 'q' for quit: " );
            response = input.next();
            if (response.equals("q")) {
                break;
            }
        }
    }
}
