package stackoverflow

class Ejercicio {

    String descripcion
    Desafio desafio
    Set<Prueba> pruebas = []

    static constraints = {
      descripcion nullable: false
    }


    Ejercicio(String descripcion, Desafio desafio) {
      this.descripcion = descripcion
      this.desafio = desafio
    }

    Prueba agregarPrueba(String input, String output) {
      Prueba p = new Prueba(input, output)
      this.pruebas << p
      p
    }

    def validarSolucion(Solucion solucion) {
      // def (pasa, no_pasa) = this.pruebas.split { it.correr(solucion) }
      solucion.resultado = this.pruebas.inject(Solucion.Resultado.PASA) { acumulado, Prueba actual ->
        acumulado.and(actual.correr(solucion))
      }


      // Prueba laPrimeraQuefalla = this.pruebas.find { !it.correr(solucion) }
      // solucion.resultado = laPrimeraQuefalla ? Solucion.Resultado.NO_PASA : Solucion.Resultado.PASA
      //
      // this.pruebas.every { it.correr(solucion) }
    }

}
