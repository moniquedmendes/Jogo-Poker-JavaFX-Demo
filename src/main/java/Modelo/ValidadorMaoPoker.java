package Modelo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidadorMaoPoker {

    public static String validarMao(List<Carta> cartas) {
        Map<String, Integer> contagemValores = new HashMap<>();
        Map<String, Integer> contagemNaipes = new HashMap<>();

        // Contar valores e naipes
        for (Carta carta : cartas) {
            contagemValores.put(carta.getValor(), contagemValores.getOrDefault(carta.getValor(), 0) + 1);
            contagemNaipes.put(carta.getNaipe(), contagemNaipes.getOrDefault(carta.getNaipe(), 0) + 1);
        }

        // Verificar combinações
        boolean temTrinca = contagemValores.containsValue(3);
        boolean temQuadra = contagemValores.containsValue(4);

        int pares = 0;
        for (int qtd : contagemValores.values()) {
            if (qtd == 2) {
                pares++;
            }
        }

        boolean flush = contagemNaipes.containsValue(5);
        boolean straight = verificarStraight(cartas);

        // Verificar mãos na ordem do ranking
        if (straight && flush) return "Straight Flush";
        if (temQuadra) return "Quadra";
        if (temTrinca && pares == 1) return "Full House";
        if (flush) return "Flush";
        if (straight) return "Sequência";
        if (temTrinca) return "Trinca";
        if (pares == 2) return "Dois Pares";
        if (pares == 1) return "Um Par";

        return "Carta Alta";
    }

    private static boolean verificarStraight(List<Carta> cartas) {
        int[] valores = new int[cartas.size()];

        // Pega os pesos das cartas
        for (int i = 0; i < cartas.size(); i++) {
            valores[i] = cartas.get(i).getPeso();
        }

        Arrays.sort(valores);

        // Verificar sequência normal (ex: 10, J, Q, K, A)
        boolean sequenciaNormal = true;
        for (int i = 0; i < valores.length - 1; i++) {
            if (valores[i] + 1 != valores[i + 1]) {
                sequenciaNormal = false;
                break;
            }
        }

        // Verificar sequência especial A, 2, 3, 4, 5
        boolean sequenciaBaixa = valores[0] == 2 &&
                valores[1] == 3 &&
                valores[2] == 4 &&
                valores[3] == 5 &&
                valores[4] == 14; // Ás sendo usado como 1 nessa sequência

        return sequenciaNormal || sequenciaBaixa;
    }
}

