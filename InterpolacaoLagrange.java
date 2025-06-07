public class InterpolacaoLagrange {
    public static void main(String[] args) {
        // double x[] = {-1.0, 0.0, 2.0}; // Teste de conta feita a mão
        // double y[] = {4.0, 1.0, -1.0}; // Teste de conta feita a mão
        // double valor = 1.8; // Teste de conta feita a mão
        double[] x = {0.0, 0.5, 0.8, 1.0, 1.4, 2.0, 2.7};
        double[] y = {1.6, 3.0, 3.7, 4.8, 4.7, 3.0, 2.6};
        double valor = 1.3;

        double resultado = interpolarLagrange(x, y, valor);
        System.out.printf("Altura estimada para t = %.1f s é %.4f m\n", valor, resultado);
    }

    public static double interpolarLagrange(double[] x, double[] y, double valor) {
        int n = x.length;
        double resultado = 0.0;

        // Soma os termos de Lagrange
        for (int i = 0; i < n; i++) {
            double termo = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    termo *= (valor - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termo;
        }

        return resultado;
    }
}
