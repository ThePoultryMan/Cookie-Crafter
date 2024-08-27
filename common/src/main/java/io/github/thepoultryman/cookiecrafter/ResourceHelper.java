package io.github.thepoultryman.cookiecrafter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class ResourceHelper {
    public static Optional<BufferedReader> loadResource(String id) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("data/cookiecrafter/" + id);
        if (inputStream != null) {
            return Optional.of(new BufferedReader(new InputStreamReader(inputStream)));
        } else {
            return Optional.empty();
        }
    }
}
