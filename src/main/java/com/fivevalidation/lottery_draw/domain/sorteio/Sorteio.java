package com.fivevalidation.lottery_draw.domain.sorteio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorteio {
    public String numeroSorteados () {
        List<Integer> numerosSorteados = sortearNumeros();
        System.out.println("Os números sorteados foram:");
        String numeros = "";
        for (int numero : numerosSorteados) {
            numeros = numeros + numero + ",";
        } System.out.println(numeros);
        return numeros.substring(0,numeros.length());

    }

    public static List<Integer> sortearNumeros() {
        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numerosSorteados.add(i);
        }
        Collections.shuffle(numerosSorteados);
        return numerosSorteados.subList(0, 5);
    }
}