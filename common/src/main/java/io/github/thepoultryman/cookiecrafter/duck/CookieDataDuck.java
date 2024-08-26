package io.github.thepoultryman.cookiecrafter.duck;

import io.github.thepoultryman.cookiecrafter.PlayerCookieData;

public interface CookieDataDuck {
    PlayerCookieData cookieData = new PlayerCookieData();

    default void addCookies(int amount) {
        cookieData.addCookies(amount);
    }
}
