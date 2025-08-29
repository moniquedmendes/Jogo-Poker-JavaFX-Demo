package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho()
    {
        cartas = new ArrayList<>();
        String[] naipes = {"♠ESPADAS", "♥COPAS", "♦OUROS", "♣PAUS"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String naipe : naipes)
        {
            for (String valor : valores)
            {
                cartas.add(new Carta(valor, naipe));
            }
        }
        Collections.shuffle(cartas);
    }

    public void embaralhar()
    {
        Collections.shuffle(cartas);
    }



    public List<Carta> tirarCartas(int quantidade)
    {
        List<Carta> cartasSelecionadas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++)
        {
            cartasSelecionadas.add(cartas.remove(0)); // pega a Carta inteira
        }
        return cartasSelecionadas;
    }

    public List<Carta> tirarCartasAdversario(int quantidade)
    {
        List<Carta> cartasAdversario = new ArrayList<>();
        for (int i = 0; i < quantidade; i++)
        {
            cartasAdversario.add(cartas.remove(0)); // pega a Carta inteira
        }
        return cartasAdversario;
    }



}



