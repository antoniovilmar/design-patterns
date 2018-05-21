package br.com.designpatterns.templatemethod;

import br.com.designpatterns.Orcamento;
import br.com.designpatterns.strategy.Imposto;
import java.math.BigDecimal;

public abstract class TemplateDeImpostoCondicional implements Imposto {

  @Override
  public BigDecimal calcular(Orcamento orcamento) {
    if (deveUsarMaximaTaxacao(orcamento)) {
      return maximaTaxacao(orcamento);
    } else {
      return minimaTaxacao(orcamento);
    }
  }

  protected abstract BigDecimal minimaTaxacao(Orcamento orcamento);

  protected abstract BigDecimal maximaTaxacao(Orcamento orcamento);

  protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
}
