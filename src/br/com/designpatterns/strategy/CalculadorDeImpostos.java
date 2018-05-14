package br.com.designpatterns.strategy;

import java.math.BigDecimal;

public class CalculadorDeImpostos {

  public BigDecimal calcular(final Orcamento orcamento, final Imposto imposto) {
    final BigDecimal valorDoImposto = imposto.calcular(orcamento);
    return valorDoImposto;
  }


}
