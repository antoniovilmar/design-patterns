package br.com.designpatterns.strategy;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class ISS implements Imposto {

  private final BigDecimal ALIQUOTA_ISS = BigDecimal.valueOf(0.2);

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return ALIQUOTA_ISS.multiply(orcamento.getValor());
  }
}
