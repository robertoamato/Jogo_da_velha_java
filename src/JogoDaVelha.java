import java.util.Scanner;

public class JogoDaVelha {
    private static char[][] tabuleiro = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;

        while (true) {
            exibirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", escolha uma posição (1-9): ");
            int posicao = scanner.nextInt();

            if (posicao < 1 || posicao > 9 || !marcarPosicao(posicao)) {
                System.out.println("Posição inválida! Tente novamente.");
                continue;
            }

            jogadas++;

            if (verificarVitoria()) {
                exibirTabuleiro();
                System.out.println("Parabéns! Jogador " + jogadorAtual + " venceu!");
                break;
            } else if (jogadas == 9) {
                exibirTabuleiro();
                System.out.println("Empate! Nenhum jogador venceu.");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    private static void exibirTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    private static boolean marcarPosicao(int posicao) {
        int linha = (posicao - 1) / 3;
        int coluna = (posicao - 1) % 3;
        if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        return false;
    }

    private static boolean verificarVitoria() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) return true;
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) return true;
        }
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) return true;
        return tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual;
    }
}
