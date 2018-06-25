package br.com.designpatterns.strategydecorator;

import static org.junit.Assert.assertEquals;

import br.com.designpatterns.Orcamento;
import br.com.designpatterns.chainofresponsibility.Item;
import br.com.designpatterns.templatemethod.ICPP;
import br.com.designpatterns.templatemethod.IKCV;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class CalculadorDeImpostosTest {

  private CalculadorDeImpostos calculadorDeImpostos;
  private Orcamento orcamento;

  @Before
  public void setUp() throws Exception {
    calculadorDeImpostos = new CalculadorDeImpostos();
    orcamento = new Orcamento();
  }

  @Test
  public void deveCalcularImpostoICMSDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(800)));

    final ICMS icms = new ICMS();
    final BigDecimal icmsDoOrcamento = calculadorDeImpostos.calcular(orcamento, icms);

    final BigDecimal valorImpostoEsperado = BigDecimal.valueOf(240.0);

    assertEquals(valorImpostoEsperado, icmsDoOrcamento);
  }

  @Test
  public void deveCalcularImpostoISSDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(800)));

    final ISS iss = new ISS();
    final BigDecimal issDoOrcamento = calculadorDeImpostos.calcular(orcamento, iss);

    final BigDecimal valorImpostoEsperado = BigDecimal.valueOf(160.0);

    assertEquals(valorImpostoEsperado, issDoOrcamento);
  }

  @Test
  public void deveCalcularImpostoISS_E_ICMSDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(800)));

    final ICMS icms = new ICMS();
    final ISS iss = new ISS(icms);
    final BigDecimal issDoOrcamento = calculadorDeImpostos.calcular(orcamento, iss);

    final BigDecimal valorImpostoEsperado = BigDecimal.valueOf(400.0);

    assertEquals(valorImpostoEsperado, issDoOrcamento);
  }

  @Test
  public void deveCalcularImpostoICPPComTaxacaoMaximaDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(800)));

    final ICPP icpp = new ICPP();
    final BigDecimal icppDoOrcamento = calculadorDeImpostos.calcular(orcamento, icpp);

    assertEquals("56.00", icppDoOrcamento.toString());
  }

  @Test
  public void deveCalcularImpostoICPPComTaxacaoMinimaDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(450)));

    final ICPP icpp = new ICPP();
    final BigDecimal icppDoOrcamento = calculadorDeImpostos.calcular(orcamento, icpp);

    assertEquals("22.50", icppDoOrcamento.toString());
  }

  @Test
  public void deveCalcularImpostoIKCVComTaxacaoMaximaDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som", BigDecimal.valueOf(300)));
    orcamento.adicionar(new Item("TV", BigDecimal.valueOf(300)));

    final IKCV ikcv = new IKCV();
    final BigDecimal ikcvDoOrcamento = calculadorDeImpostos.calcular(orcamento, ikcv);

    assertEquals("60.0", ikcvDoOrcamento.toString());
  }

  @Test
  public void deveCalcularImpostoIKCVComTaxacaoMinimaDoValorDoOrcamento() throws Exception {
    orcamento.adicionar(new Item("Som 01", BigDecimal.valueOf(80)));
    orcamento.adicionar(new Item("Som 02", BigDecimal.valueOf(80)));
    orcamento.adicionar(new Item("Som 03", BigDecimal.valueOf(70)));
    orcamento.adicionar(new Item("Som 04", BigDecimal.valueOf(60)));
    orcamento.adicionar(new Item("Som 05", BigDecimal.valueOf(50)));
    orcamento.adicionar(new Item("Som 06", BigDecimal.valueOf(50)));
    orcamento.adicionar(new Item("Som 07", BigDecimal.valueOf(90)));
    orcamento.adicionar(new Item("Som 08", BigDecimal.valueOf(80)));
    orcamento.adicionar(new Item("Som 09", BigDecimal.valueOf(70)));
    orcamento.adicionar(new Item("Som 10", BigDecimal.valueOf(80)));

    final IKCV ikcv = new IKCV();
    final BigDecimal ikcvDoOrcamento = calculadorDeImpostos.calcular(orcamento, ikcv);

    assertEquals("42.60", ikcvDoOrcamento.toString());
  }

}