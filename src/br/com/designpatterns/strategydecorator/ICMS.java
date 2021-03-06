package br.com.designpatterns.strategydecorator;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class ICMS extends Imposto {

  public ICMS(Imposto outroImposto) {
    super(outroImposto);
  }

  public ICMS() {
  }

  private final BigDecimal ALIQUOTA_ICMS = BigDecimal.valueOf(0.3);

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    return ALIQUOTA_ICMS.multiply(orcamento.getValor()).add(calcularOutroImposto(orcamento));
  }
}
