package com.learning.copilot;

// class that convert celcius to fahrenheit, fahrenheit to celcius, celcius to kelvin, kelvin to celcius, fahrenheit to kelvin, kelvin to fahrenheit
public class Temperature {
    public static double celciusToFahrenheit(double celcius) {
        return celcius * 9 / 5 + 32;
    }
    
    public static double fahrenheitToCelcius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double celciusToKelvin(double celcius) {
        return celcius + 273.15;
    }
    
    public static double kelvinToCelcius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static double fahrenheitToKelvin(double fahrenheit) {
        return celciusToKelvin(fahrenheitToCelcius(fahrenheit));
    }
    
    public static double kelvinToFahrenheit(double kelvin) {
        return celciusToFahrenheit(kelvinToCelcius(kelvin));
    }
}
