package com.joke.backend;

import com.example.JokesProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeBeanApi",
        version = "v1",
        resource = "jokeBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joke.com",
                ownerName = "backend.joke.com",
                packagePath = ""
        )
)
public class JokeBeanEndpoint {

    @ApiMethod(name = "getJokeBean")
    public JokeBean getJokeBean() {
        JokeBean response = new JokeBean();
        JokesProvider provider = new JokesProvider();
        response.setJoke(provider.getJoke());
        return response;
    }

}