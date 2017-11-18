package stackoverflow

class Materia {

    String nombre
    Set<Dicta> dictados = []

    static hasMany = [
      dictados: Dicta,
    ]

    Materia(String nombre) {
      this.nombre = nombre
    }

    static constraints = {
      nombre blank: false, nullable: false
    }
}
