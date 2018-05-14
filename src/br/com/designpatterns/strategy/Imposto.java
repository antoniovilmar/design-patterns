package br.com.designpatterns.strategy;

import java.math.BigDecimal;

public interface Imposto {

  BigDecimal calcular(Orcamento orcamento);
}
