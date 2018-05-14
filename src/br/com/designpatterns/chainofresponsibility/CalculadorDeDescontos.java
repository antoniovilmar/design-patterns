package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class CalculadorDeDescontos {

  public BigDecimal calcular(Orcamento orcamento) {
    Desconto primeiroDesconto = new DescontoPorMaisDeCincoItens();
    Desconto segundoDesconto = new DescontoPorMaisDeQuinhentosReais();
    Desconto semDesconto = new SemDesconto();

    primeiroDesconto.setProximo(segundoDesconto);
    segundoDesconto.setProximo(semDesconto);

    return primeiroDesconto.descontar(orcamento);

  }

}
