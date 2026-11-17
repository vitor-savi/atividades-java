package questao08;

/**
 * Classe com métodos estáticos para converter temperaturas entre as escalas
 * Celsius, Fahrenheit e Kelvin.
 *
 * Relações utilizadas: F = 9*C/5 + 32 e K = C + 273
 */
public class ConversorTemperatura {

    /** Construtor privado: a classe possui apenas métodos estáticos. */
    private ConversorTemperatura() {
    }

    public static double celsiusParaFahrenheit(double celsius) {
        return 9 * celsius / 5 + 32;
    }

    public static double celsiusParaKelvin(double celsius) {
        return celsius + 273;
    }

    public static double fahrenheitParaCelsius(double fahrenheit) {
        return 5 * (fahrenheit - 32) / 9;
    }

    public static double fahrenheitParaKelvin(double fahrenheit) {
        return celsiusParaKelvin(fahrenheitParaCelsius(fahrenheit));
    }

    public static double kelvinParaCelsius(double kelvin) {
        return kelvin - 273;
    }

    public static double kelvinParaFahrenheit(double kelvin) {
        return celsiusParaFahrenheit(kelvinParaCelsius(kelvin));
    }
}
