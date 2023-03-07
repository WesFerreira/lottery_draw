package com.fivevalidation.lottery_draw.domain.sorteio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorteio {
    public String numeroSorteados (int n) {
        List<Integer> numerosSorteados = sortearNumeros(n);
        System.out.println("Os números sorteados foram:");
        String numeros = "";
        for (int numero : numerosSorteados) {
            numeros = numeros + numero + ",";
        } System.out.println(numeros);
        return numeros.substring(0,numeros.length()-1);
    }

    public static List<Integer> sortearNumeros(int n) {
        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numerosSorteados.add(i);
        }
        Collections.shuffle(numerosSorteados);
        return numerosSorteados.subList(0, n);
    }

    public BigDecimal calcularJurosCompostos(BigDecimal principal, BigDecimal taxaJuros, int periodo) {
        BigDecimal um = new BigDecimal("1.00");

        // Calcula (1 + taxaJuros) elevado ao número de períodos
        BigDecimal base = um.add(taxaJuros);
        BigDecimal potencia = base.pow(periodo);

        // Calcula o montante total
        BigDecimal montante = principal.multiply(potencia);

        return montante;
    }
}