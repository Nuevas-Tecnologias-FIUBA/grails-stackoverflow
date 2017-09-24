package stackoverflow

class Solucion {

    enum Resultado {
      PASA,
      NO_PASA,

      Resultado and(Resultado otro) {
        this == PASA && otro == PASA ? PASA : NO_PASA
      }
    }

    Double puntaje
    Resultado resultado
    Closure codigo
    Programador participante

    static constraints = {
      puntaje nullable: false
      resultado nullable: false
    }

    Solucion(Programador p, Ejercicio ejercicio, Closure codigo) {
      this.participante = p
      this.codigo = codigo
    }
}
