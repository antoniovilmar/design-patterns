package br.com.designpatterns.strategy;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class ICMS implements Imposto {

  private final BigDecimal ALIQUOTA_ICMS = BigDecimal.valueOf(0.3);

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return ALIQUOTA_ICMS.multiply(orcamento.getValor());
  }
}
