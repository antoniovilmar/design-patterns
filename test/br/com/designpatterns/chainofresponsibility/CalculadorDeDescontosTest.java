package br.com.designpatterns.chainofresponsibility;

import br.com.designpatterns.Orcamento;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadorDeDescontosTest {

  private CalculadorDeDescontos calculadorDeDescontos;
  private Orcamento orcamento;

  @Before
  public void setUp() throws Exception {
    calculadorDeDescontos = new CalculadorDeDescontos();
    orcamento = new Orcamento();
  }

  @Test
  public void naoDeveRetornarDesconto() throws Exception {
    orcamento.adicionar(new Item("Mamão", BigDecimal.TEN));
    orcamento.adicionar(new Item("Mação", BigDecimal.ONE));

    final BigDecimal valorOrcamento = calculadorDeDescontos.calcular(orcamento);

    Assert.assertEquals(BigDecimal.ZERO, valorOrcamento);

  }

  @Test
  public void deveRetornarDescontoMaiorDeQuinhentosReais() throws Exception {
    orcamento.adicionar(new Item("Relógio", BigDecimal.valueOf(600)));

    final BigDecimal valorOrcamento = calculadorDeDescontos.calcular(orcamento);

    Assert.assertEquals(BigDecimal.valueOf(120.0), valorOrcamento);

  }

  @Test
  public void deveRetornarSomenteDescontoMaisDeCincoItens() throws Exception {
    orcamento.adicionar(new Item("Relógio", BigDecimal.valueOf(600)));
    orcamento.adicionar(new Item("Lapis", BigDecimal.valueOf(10)));
    orcamento.adicionar(new Item("Caneta", BigDecimal.valueOf(20)));
    orcamento.adicionar(new Item("Clips", BigDecimal.valueOf(20)));
    orcamento.adicionar(new Item("Apontador", BigDecimal.valueOf(40)));
    orcamento.adicionar(new Item("Borracha", BigDecimal.valueOf(10)));

    final BigDecimal valorOrcamento = calculadorDeDescontos.calcular(orcamento);

    Assert.assertEquals(BigDecimal.valueOf(70.0), valorOrcamento);

  }

}