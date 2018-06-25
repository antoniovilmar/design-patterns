package br.com.designpatterns.strategydecorator;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class ISS extends Imposto {

  private final BigDecimal ALIQUOTA_ISS = BigDecimal.valueOf(0.2);

  public ISS(Imposto outroImposto) {
    super(outroImposto);
  }

  public ISS() {
  }

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return ALIQUOTA_ISS.multiply(orcamento.getValor()).add(calcularOutroImposto(orcamento));
  }
}
