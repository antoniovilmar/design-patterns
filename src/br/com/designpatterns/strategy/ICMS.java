package br.com.designpatterns.strategy;

import java.math.BigDecimal;

public class ICMS implements Imposto {

  private final BigDecimal VALOR_BASE_ICMS = BigDecimal.valueOf(0.3);

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return VALOR_BASE_ICMS.multiply(orcamento.getValor());
  }
}
