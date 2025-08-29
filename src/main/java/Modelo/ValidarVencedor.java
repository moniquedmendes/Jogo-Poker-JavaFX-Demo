package Modelo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidarVencedor {

    private static final Map<String, Integer> rankingMao = new HashMap<>();

    static {
        rankingMao.put("Carta Alta", 1);
        rankingMao.put("Um Par", 2);
        rankingMao.put("Dois Pares", 3);
        rankingMao.put("Trinca", 4);
        rankingMao.put("Sequência", 5);
        rankingMao.put("Flush", 6);
        rankingMao.put("Full House", 7);
        rankingMao.put("Quadra", 8);
        rankingMao.put("Straight Flush", 9);
    }

    public static String compararMaos(String maoJogador, List<Carta> cartasJogador,
                                      String maoAdversario, List<Carta> cartasAdversario) {

        int rankJogador = rankingMao.getOrDefault(maoJogador, 0);
        int rankAdversario = rankingMao.getOrDefault(maoAdversario, 0);

        if (rankJogador > rankAdversario) {
            return "Jogador venceu com " + maoJogador;
        } else if (rankAdversario > rankJogador) {
            return "Adversário venceu com " + maoAdversario;
        } else {
            // Ranking igual -> Desempatar por peso
            int resultado = desempatar(cartasJogador, cartasAdversario, maoJogador);

            if (resultado > 0) {
                return "Jogador venceu com " + maoJogador;
            } else if (resultado < 0) {
                return "Adversário venceu com " + maoAdversario;
            } else {
                return "Empate absoluto"; // Raríssimo, mas possível (ex.: mesma mão e mesmos kickers)
            }
        }
    }

    private static int desempatar(List<Carta> jogador, List<Carta> adversario, String mao) {
        // Ordenar por peso decrescente
        List<Integer> pesosJogador = jogador.stream()
                .map(Carta::getPeso)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> pesosAdversario = adversario.stream()
                .map(Carta::getPeso)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Comparar peso a peso
        for (int i = 0; i < Math.min(pesosJogador.size(), pesosAdversario.size()); i++) {
            int pesoJog = pesosJogador.get(i);
            int pesoAdv = pesosAdversario.get(i);

            if (pesoJog > pesoAdv) return 1;
            if (pesoJog < pesoAdv) return -1;
        }

        return 0; // Empate absoluto
    }
}
