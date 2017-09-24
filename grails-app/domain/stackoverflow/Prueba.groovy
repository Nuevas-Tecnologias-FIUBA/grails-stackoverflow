package stackoverflow

class Prueba {

    String input
    String output

    static constraints = {
    }

    Prueba(String input, String output) {
      this.input = input
      this.output = output
    }

    Solucion.Resultado correr(Solucion solucion) {
      solucion.codigo(input) == output ?
        Solucion.Resultado.PASA :
        Solucion.Resultado.NO_PASA
    }
}
