package stackoverflow

class Tasa {
  final BigDecimal valor
  final Dinero.Moneda origen
  final Dinero.Moneda destino

  Tasa(BigDecimal valor, Dinero.Moneda origen, Dinero.Moneda destino) {
    assert origen != destino
    this.valor = valor
    this.origen = origen
    this.destino = destino
  }
}

@groovy.transform.ToString(includeNames=true)
@groovy.transform.EqualsAndHashCode
class Dinero {

  enum Moneda {
    ARS,
    USS,
  }

  BigDecimal valor
  Moneda moneda

  Dinero(final BigDecimal valor, final Moneda moneda) {
    this.valor = valor
    this.moneda = moneda
  }

  Dinero plus(Dinero otro) {
    assert this.moneda == otro.moneda
    new Dinero(this.valor + otro.valor, this.moneda)
  }

  Dinero minus(Dinero otro) {
    assert this.moneda == otro.moneda
    new Dinero(this.valor - otro.valor, this.moneda)
  }

  // Dinero convertir(Tasa tasa) {
  //   assert this.moneda == tasa.origen
  //   new Dinero(valor * tasa.valor, tasa.destino)
  // }
}
