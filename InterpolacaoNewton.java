public class InterpolacaoNewton {
    public static void main(String[] args) {
        double[] x = {0.0, 0.5, 0.8, 1.0, 1.4, 2.0, 2.7};
        double[] y = {1.6, 3.0, 3.7, 4.8, 4.7, 3.0, 2.6};
        double valor = 1.3;

        double resultado = interpolarNewton(x, y, valor);
        System.out.printf("Altura estimada para t = %.1f s é %.4f m\n", valor, resultado);
    }

    public static double interpolarNewton(double[] x, double[] y, double valor) {
        int n = x.length;
        double[][] tabela = new double[n][n];

        // Preenche a primeira coluna com os valores de y
        for (int i = 0; i < n; i++) {
            tabela[i][0] = y[i];
        }

        // Calcula as diferenças divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabela[i][j] = (tabela[i + 1][j - 1] - tabela[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Calcula o valor interpolado
        double resultado = tabela[0][0];
        for (int i = 1; i < n; i++) {
            double termo = tabela[0][i];
            for (int j = 0; j < i; j++) {
                termo *= (valor - x[j]);
            }
            resultado += termo;
        }

        return resultado;
    }
}
