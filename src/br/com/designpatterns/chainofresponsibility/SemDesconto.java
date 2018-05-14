package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public class SemDesconto implements Desconto {

  @Override
  public BigDecimal descontar(Orcamento orcamento) {
    return BigDecimal.ZERO;
  }
}
