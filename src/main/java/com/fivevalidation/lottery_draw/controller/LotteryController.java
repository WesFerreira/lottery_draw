package com.fivevalidation.lottery_draw.controller;

import com.fivevalidation.lottery_draw.domain.sorteio.HistoricoSorteio;
import com.fivevalidation.lottery_draw.domain.sorteio.Sorteio;
import com.fivevalidation.lottery_draw.domain.ticket.Ticket;
import com.fivevalidation.lottery_draw.domain.ticket.TicketRecord;
import com.fivevalidation.lottery_draw.domain.usuario.Usuario;
import com.fivevalidation.lottery_draw.domain.usuario.UsuarioRecord;
import com.fivevalidation.lottery_draw.repository.HistoricoGanhadoresRepository;
import com.fivevalidation.lottery_draw.repository.HistoricoSorteioRepository;
import com.fivevalidation.lottery_draw.repository.TicketRepository;
import com.fivevalidation.lottery_draw.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("lottery")
public class LotteryController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HistoricoSorteioRepository historicoSorteioRepository;
    @Autowired
    private HistoricoGanhadoresRepository historicoGanhadoresRepository;

    @PostMapping("ticket/cadastrar")
    public String cadastrarTicket(@RequestBody @Valid TicketRecord dadosTicket) {

        var ticket = new Ticket(dadosTicket);
        BigDecimal valor = new BigDecimal("5.0");
        BigDecimal valorAcrescimo = new BigDecimal("0.10");
        BigDecimal valorTaxado = new BigDecimal("0.15");

        String [] numerosTicket = ticket.getNumero().split(",");
        Sorteio sorteio = new Sorteio();

        if (numerosTicket.length == 1) {
            ticket.setNumero(sorteio.numeroSorteados(Integer.parseInt(ticket.getNumero())));
            numerosTicket = ticket.getNumero().split(",");
        }

        int n =numerosTicket.length -5;

        if (numerosTicket.length == 5) {
            ticket.setPreçoLiquido(valor);
            ticket.setPreçoBruto(valor.add(valor.multiply(valorTaxado)));
        } else {
            BigDecimal valorTotal = new BigDecimal(String.valueOf(sorteio.calcularJurosCompostos(valor, valorAcrescimo, n)));
            ticket.setPreçoLiquido(valorTotal);
            ticket.setPreçoBruto(valorTotal.add(valorTotal.multiply(valorTaxado)));
        }
        ticketRepository.save(ticket);
        return "200";
    }

    @PostMapping("usuario/cadastrar")
    public String cadastrar(@RequestBody @Valid UsuarioRecord dadosUsuario) {
        var usuario = new Usuario(dadosUsuario);
        usuarioRepository.save(usuario);
        return "200";
    }

    @GetMapping("ticket/listar")
    public List<Ticket> listarTicket(@RequestParam ("email") String email) {
        return ticketRepository.findByEmail(email);
    }

    @GetMapping("usuario/listar")
    public List<Usuario> listarUsuario(@RequestParam ("email") String email, @RequestParam("senha") String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

    @GetMapping("ticket/listarVencedor")
    public List<Ticket> listarTicketVencedor(@RequestParam ("numero") String numero) {
        return ticketRepository.findByNumero(numero);
    }

    @GetMapping("sorteio")
    public List<Ticket> informarSorteado() {
        HistoricoSorteio historicoSorteio = new HistoricoSorteio();
        Sorteio sorteio = new Sorteio();

        String [] numerosSorteados = sorteio.numeroSorteados(5).split(",");
        String numeros = "";

        for (int i = 0; i < numerosSorteados.length; i++) {
            numeros = numeros + "," + numerosSorteados[i];
        }

        historicoSorteio.setNumerosSorteados(numeros.substring(1));
        historicoSorteioRepository.save(historicoSorteio);

        return ticketRepository.findTicketsByNumerosSorteados(
                "%" + numerosSorteados[0] + "%",
                "%" + numerosSorteados[1] + "%",
                "%" + numerosSorteados[2] + "%",
                "%" + numerosSorteados[3] + "%",
                "%" + numerosSorteados[4] + "%");
    }

}
