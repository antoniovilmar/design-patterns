package br.com.designpatterns.templatemethod;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class IKCV extends TemplateDeImpostoCondicional {

  public static final double VALOR_MINIMO_TAXACAO = 0.06;
  public static final double VALOR_MAXIMO_TAXACAO = 0.10;

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
    return orcamento.getValor().doubleValue() > 500 && temItemMaiorQue100ReaisNo(orcamento);
  }

  private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
    return orcamento.getItens().stream().anyMatch(i -> i.getValor().doubleValue() > 100);
  }
}
