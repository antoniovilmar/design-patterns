package br.com.designpatterns.strategy;

import java.math.BigDecimal;

public class ISS implements Imposto {

  private final BigDecimal VALOR_BASE_ISS = BigDecimal.valueOf(0.2);

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return VALOR_BASE_ISS.multiply(orcamento.getValor());
  }
}
