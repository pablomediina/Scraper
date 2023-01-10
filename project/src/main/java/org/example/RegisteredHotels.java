package org.example;

public class RegisteredHotels {
    public static String checkName(String realName) {
        if (realName.equals("Lopesan Costa Meloneras Resort & Spa")) return "lopesan";
        if (realName.equals("Hotel Riu Gran Canaria")) return "riu";
        if (realName.equals("Caybeach Meloneras")) return "caybeach";
        if (realName.equals("Seaside Palm Beach")) return "seaside";
        if (realName.equals("Sol Mogan Suites")) return "solmogan";
        return "Hotel not registered";
    }
}