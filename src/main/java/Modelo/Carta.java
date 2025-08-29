package Modelo;

public class Carta {

    private String valor;
    private String naipe;
    private int peso;
    private String imagem;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
        this.peso = definirPeso(valor);
        this.imagem = gerarCaminhoImagem(valor, naipe);
    }

    private int definirPeso(String valor) {
        switch (valor) {
            case "A": return 14;
            case "K": return 13;
            case "Q": return 12;
            case "J": return 11;
            default: return Integer.parseInt(valor); // converter a string para int associa o valor etc...
        }
    }

    private String gerarCaminhoImagem(String valor, String naipe) {
        // Remover símbolos e padronizar o nome i tals
        String naipeFormatado = switch (naipe) {
            case "♠ESPADAS" -> "ESPADAS";
            case "♥COPAS" -> "COPAS";
            case "♦OUROS" -> "OUROS";
            case "♣PAUS" -> "PAUS";
            default -> "";
        };

        return "/cartas/" + valor + "_" + naipeFormatado + ".png";
    }

    public String getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return valor + " " + naipe;
    }

    public String getImagem() {
        return "/cartas/" + valor + "_" + naipe.replace("♠", "ESPADAS")
                .replace("♥", "COPAS")
                .replace("♦", "OUROS")
                .replace("♣", "PAUS") + ".png";
    }
}
