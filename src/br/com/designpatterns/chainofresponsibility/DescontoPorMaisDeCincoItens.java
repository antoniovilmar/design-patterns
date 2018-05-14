package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class DescontoPorMaisDeCincoItens implements Desconto {

  private final BigDecimal DESCONTO_BASE = BigDecimal.valueOf(0.1);
  private Desconto proximo;

  @Override
  public BigDecimal descontar(Orcamento orcamento) {
    if (orcamento.getItens().size() > 5) {
      return orcamento.getValor().multiply(DESCONTO_BASE);
    }

    return proximo.descontar(orcamento);
  }

  @Override
  public void setProximo(Desconto proximo) {
    this.proximo = proximo;
  }

}
