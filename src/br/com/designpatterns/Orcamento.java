package br.com.designpatterns;

import br.com.designpatterns.chainofresponsibility.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

  private final List<Item> itens;

  public Orcamento() {
    this.itens = new ArrayList<>();
  }

  public void adicionar(Item item) {
    this.itens.add(item);
  }

  public List<Item> getItens() {
    return Collections.unmodifiableList(itens);
  }

  public BigDecimal getValor() {
    return this.itens.stream().map(Item::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
