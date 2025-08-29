package Modelo;

import java.util.List;

public class Controle {

    private Baralho baralho = new Baralho();

    private List<Carta> cartasJogador;
    private List<Carta> cartasAdversario;

    public String validarMaoJogador(List<Carta> cartas) {
        this.cartasJogador = cartas;
        return ValidadorMaoPoker.validarMao(cartas);
    }

    public String validarMaoAdversario(List<Carta> cartas) {
        this.cartasAdversario = cartas;
        return ValidadorMaoPoker.validarMao(cartas);
    }

    public String verificarVencedor()
    {
        String maoJogador = ValidadorMaoPoker.validarMao(cartasJogador);
        String maoAdversario = ValidadorMaoPoker.validarMao(cartasAdversario);

        return ValidarVencedor.compararMaos(maoJogador, cartasJogador, maoAdversario, cartasAdversario);
    }

    public List<Carta> pegarCartas(int quantidade)
    {
        baralho = new Baralho();
        baralho.embaralhar();
        return baralho.tirarCartas(quantidade);

    }

    public List<Carta> pegarCartasAdversario(int quantidade)
    {
        baralho.embaralhar();
        return baralho.tirarCartasAdversario(quantidade);

    }


}
