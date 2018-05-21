package br.com.designpatterns.templatemethod;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class ICPP extends TemplateDeImpostoCondicional {

  private final double VALOR_MINIMO_TAXACAO = 0.05;
  private final double VALOR_MAXIMO_TAXACAO = 0.07;

  @Override
  protected BigDecimal minimaTaxacao(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(VALOR_MINIMO_TAXACAO));
  }

  @Override
  protected BigDecimal maximaTaxacao(Orcamento orcamento) {
    return orcamento.getValor().multiply(BigDecimal.valueOf(VALOR_MAXIMO_TAXACAO));
  }

  @Override
  protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
    return orcamento.getValor().doubleValue() > 500;
  }
}
