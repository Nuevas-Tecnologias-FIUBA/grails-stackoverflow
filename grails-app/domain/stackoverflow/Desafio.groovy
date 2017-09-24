package stackoverflow

class Desafio {

    String titulo
    Programador creador

    static constraints = {
      titulo nullable: false
      creador nullable: false
    }

    Desafio(String titulo, Programador programador) {
      this.titulo = titulo
      this.creador = programador
    }

    Ejercicio crearEjercicio(String descripcion) {
      new Ejercicio(descripcion, this)
    }
}
