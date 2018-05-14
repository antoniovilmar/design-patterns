package br.com.designpatterns.strategy;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class CalculadorDeImpostosTest {

  private CalculadorDeImpostos calculadorDeImpostos;
  private Orcamento orcamento;

  @Before
  public void setUp() throws Exception {
    calculadorDeImpostos = new CalculadorDeImpostos();
    orcamento = new Orcamento(BigDecimal.valueOf(800));
  }

  @Test
  public void deveCalcularImpostoICMSDoValorDoOrcamento() throws Exception {
    final ICMS icms = new ICMS();
    final BigDecimal icmsDoOrcamento = calculadorDeImpostos.calcular(orcamento, icms);

    final BigDecimal valorImpostoEsperado = BigDecimal.valueOf(240.0);

    assertEquals(valorImpostoEsperado, icmsDoOrcamento);
  }

  @Test
  public void deveCalcularImpostoISSDoValorDoOrcamento() throws Exception {
    final ISS iss = new ISS();
    final BigDecimal issDoOrcamento = calculadorDeImpostos.calcular(orcamento, iss);

    final BigDecimal valorImpostoEsperado = BigDecimal.valueOf(160.0);

    assertEquals(valorImpostoEsperado, issDoOrcamento);
  }

}