package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {

  private final BigDecimal DESCONTO_BASE = BigDecimal.valueOf(0.2);
  private Desconto proximo;

  @Override
  public BigDecimal descontar(Orcamento orcamento) {
    if (orcamento.getValor().doubleValue() > 500) {
      return orcamento.getValor().multiply(DESCONTO_BASE);
    }

    return proximo.descontar(orcamento);
  }

  @Override
  public void setProximo(Desconto proximo) {
    this.proximo = proximo;
  }

}
