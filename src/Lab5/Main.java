package Lab5;

import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {

//        Jokes jokes = new Jokes();
//        jokes = jokes.loadJason("https://official-joke-api.appspot.com/random_joke");
//        System.out.println(jokes);

        JasonGet jasonGet = new JasonGet();
        JasonGet.url = "https://official-joke-api.appspot.com/random_ten";
        jasonGet.run();

        System.out.println("Waiting for data...");
        String jsonString = jasonGet.jsonIn;
        System.out.println(jsonString);

        // Считываем json
        Object obj = null;
        try
        {
            obj = new JSONParser().parse(jsonString);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray.toJSONString());
        System.out.println();

        Jokes jokes = new Jokes();

        for (Object jsonObject : jsonArray)
        {
            JSONObject object = (JSONObject) jsonObject;
            Joke joke = new Joke((long)object.get("id"), (String) object.get("type"),(String) object.get("setup"),(String) object.get("punchline"));
            jokes.add(joke);
        }

        System.out.println("Imported data after parsing:\n" + jokes);

        jokes.getJokes().sort(Joke.byIdAsc);
        System.out.println("After sorting by ID ascending:\n" + jokes);

    }
}