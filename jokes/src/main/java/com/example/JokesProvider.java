package com.example;

import java.util.ArrayList;
import java.util.List;

public class JokesProvider {
    private List<String> jokes = new ArrayList<>();

    public String getJoke() {
        prepareJokes();
        int index = (int) Math.floor(Math.random()*6);
        return jokes.get(index);
    }

    private void prepareJokes() {
        jokes.add("Q: Can a kangaroo jump higher than the Empire State Building? \n" +
                "A: Of course. The Empire State Building can't jump.");
        jokes.add("Q: how many programmers does it take to change a light bulb? \n" +
                "A: none, that's a hardware problem");
        jokes.add("Q: \"Whats the object-oriented way to become wealthy? \n" +
                "A: Inheritance");
        jokes.add("When a woman says \"what?\" \n" +
                "Its not because she didn't hear you. She's just giving you a chance to change what you said.");
        jokes.add("updated google cloud backend test 1");
        jokes.add("updated google cloud backend test 2");
    }
}


