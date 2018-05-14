package br.com.designpatterns.chainofresponsibility;

import java.math.BigDecimal;

public class Item {

  private String nome;
  private BigDecimal valor;

  public Item(String nome, BigDecimal valor) {
    this.nome = nome;
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public BigDecimal getValor() {
    return valor;
  }
}
