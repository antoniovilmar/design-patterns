package br.com.designpatterns.strategydecorator;

import static java.util.Objects.isNull;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public abstract class Imposto {

  protected Imposto outroImposto;

  public Imposto(Imposto outroImposto) {
    this.outroImposto = outroImposto;
  }

  public Imposto() {
  }

  public abstract BigDecimal calcular(Orcamento orcamento);

  protected BigDecimal calcularOutroImposto(Orcamento orcamento) {

    if (isNull(outroImposto)) {
      return BigDecimal.ZERO;
    }

    return outroImposto.calcular(orcamento);
  }

}
