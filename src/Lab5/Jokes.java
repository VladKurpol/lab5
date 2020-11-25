package Lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.net.URL;
import java.nio.charset.Charset;

public class Jokes implements Serializable {
    private ArrayList<Joke> jokes;

    public Jokes(ArrayList<Joke> jokes) {
        this.jokes = jokes;
    }

    public Jokes(){
        jokes = new ArrayList<>();
    }

    public ArrayList<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(ArrayList<Joke> jokes) {
        this.jokes = jokes;
    }

//    public Jokes loadJason(String url) throws IOException
//    {
//        StringBuilder jsonIn = new StringBuilder();
//        InputStream is = null;
//        is = new URL(url).openStream();
//        try {
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            int cp;
//            while ((cp = rd.read()) != -1) {
//                jsonIn.append((char) cp);
//            }
//        }
//        finally {
//            is.close();
//        }
//
//        return new ObjectMapper().readValue(jsonIn.toString(), Jokes.class);
//    }

    public void add(Joke joke) {
        this.jokes.add(joke);
    }

    @Override
    public String toString(){
        //return "Jokes:\n" + jokes;
        String result = "";
        for (Joke j : jokes) {
            result += j + System.lineSeparator();
        }
        return result;
    }

}
