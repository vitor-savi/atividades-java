package questao14;

public class CalculadoraAreas {

    public static double somaAreas(Superficie[] figuras) {
        double soma = 0;
        for (int i = 0; i < figuras.length; i++) {
            soma += figuras[i].area();
        }
        return soma;
    }
}
