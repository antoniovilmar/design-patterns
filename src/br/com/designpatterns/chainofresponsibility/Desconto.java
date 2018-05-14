package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public interface Desconto {

  BigDecimal descontar(Orcamento orcamento);
  default void setProximo(Desconto desconto) {};

}
