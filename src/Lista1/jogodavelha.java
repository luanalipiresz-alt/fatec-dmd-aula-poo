import java.util.Scanner;

public class jogodavelha {

    static Scanner scanner = new Scanner(System.in);

    static char[][] tabuleiro = new char[3][3];

    static String nomeJogadorX;
    static String nomeJogadorO;

    static int vitoriasX = 0;
    static int vitoriasO = 0;
    static int empates = 0;

    public static void main(String[] args) {

        System.out.println("===== JOGO DA VELHA =====");

        System.out.print("Digite o nome do jogador X: ");
        nomeJogadorX = scanner.nextLine();

        System.out.print("Digite o nome do jogador O: ");
        nomeJogadorO = scanner.nextLine();

        boolean jogarNovamente = true;

        while (jogarNovamente) {

            iniciarTabuleiro();

            char jogadorAtual = 'X';
            boolean partidaEncerrada = false;

            while (!partidaEncerrada) {

                exibirTabuleiro();

                String nomeJogador = obterNomeJogador(jogadorAtual);

                System.out.println("\nVez de " + nomeJogador + " (" + jogadorAtual + ")");

                realizarJogada(jogadorAtual);

                if (verificarVitoria(jogadorAtual)) {

                    exibirTabuleiro();

                    System.out.println("\nO jogador " + jogadorAtual
                            + " (" + nomeJogador + ") venceu!");

                    if (jogadorAtual == 'X') {
                        vitoriasX++;
                    } else {
                        vitoriasO++;
                    }

                    partidaEncerrada = true;

                } else if (tabuleiroCompleto()) {

                    exibirTabuleiro();

                    System.out.println("\nA partida terminou empatada!");

                    empates++;

                    partidaEncerrada = true;

                } else {

                    jogadorAtual = trocarJogador(jogadorAtual);
                }
            }

            exibirPlacar();

            jogarNovamente = perguntarNovaPartida();
        }

        System.out.println("\nObrigado por jogar!");
        scanner.close();
    }


    public static void iniciarTabuleiro() {

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }
    }


    public static void exibirTabuleiro() {

        System.out.println();
        System.out.println("    1   2   3");
        System.out.println("  +---+---+---+");

        for (int linha = 0; linha < 3; linha++) {

            System.out.print((linha + 1) + " ");

            for (int coluna = 0; coluna < 3; coluna++) {

                System.out.print("| " + tabuleiro[linha][coluna] + " ");

            }

            System.out.println("|");
            System.out.println("  +---+---+---+");
        }
    }


    public static void realizarJogada(char jogador) {

        boolean jogadaValida = false;

        while (!jogadaValida) {

            int linha = lerNumero("Informe a linha (1 a 3): ");
            int coluna = lerNumero("Informe a coluna (1 a 3): ");

            if (!posicaoValida(linha, coluna)) {

                System.out.println(
                        "Posição inválida. A linha e a coluna devem estar entre 1 e 3."
                );

            } else if (tabuleiro[linha - 1][coluna - 1] != ' ') {

                System.out.println(
                        "Essa posição já está ocupada. Escolha outra posição."
                );

            } else {

                tabuleiro[linha - 1][coluna - 1] = jogador;
                jogadaValida = true;
            }
        }
    }


    public static int lerNumero(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            if (scanner.hasNextInt()) {

                int numero = scanner.nextInt();
                scanner.nextLine();

                return numero;

            } else {

                System.out.println(
                        "Entrada inválida. Digite apenas números."
                );

                scanner.nextLine();
            }
        }
    }


    public static boolean posicaoValida(int linha, int coluna) {

        return linha >= 1 && linha <= 3
                && coluna >= 1 && coluna <= 3;
    }


    public static boolean verificarVitoria(char jogador) {


        for (int linha = 0; linha < 3; linha++) {

            if (tabuleiro[linha][0] == jogador
                    && tabuleiro[linha][1] == jogador
                    && tabuleiro[linha][2] == jogador) {

                return true;
            }
        }


        for (int coluna = 0; coluna < 3; coluna++) {

            if (tabuleiro[0][coluna] == jogador
                    && tabuleiro[1][coluna] == jogador
                    && tabuleiro[2][coluna] == jogador) {

                return true;
            }
        }


        if (tabuleiro[0][0] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][2] == jogador) {

            return true;
        }


        if (tabuleiro[0][2] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][0] == jogador) {

            return true;
        }

        return false;
    }


    public static boolean tabuleiroCompleto() {

        for (int linha = 0; linha < 3; linha++) {

            for (int coluna = 0; coluna < 3; coluna++) {

                if (tabuleiro[linha][coluna] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }


    public static char trocarJogador(char jogadorAtual) {

        if (jogadorAtual == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }


    public static String obterNomeJogador(char jogador) {

        if (jogador == 'X') {
            return nomeJogadorX;
        } else {
            return nomeJogadorO;
        }
    }


    public static void exibirPlacar() {

        System.out.println("\n===== PLACAR =====");
        System.out.println(nomeJogadorX + " (X): " + vitoriasX + " vitória(s)");
        System.out.println(nomeJogadorO + " (O): " + vitoriasO + " vitória(s)");
        System.out.println("Empates: " + empates);
    }

    public static boolean perguntarNovaPartida() {

        while (true) {

            System.out.print("\nDesejam jogar novamente? (S/N): ");

            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("S")) {
                return true;
            }

            if (resposta.equals("N")) {
                return false;
            }

            System.out.println("Resposta inválida. Digite S ou N.");
        }
    }
}