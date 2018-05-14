package br.com.designpatterns.strategy;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;

public interface Imposto {

  BigDecimal calcular(Orcamento orcamento);
}
