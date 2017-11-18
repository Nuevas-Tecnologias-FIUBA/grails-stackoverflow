package stackoverflow

class Profesor extends Rol {

    String nombre
    String apellido
    Set<Dicta> dictados = []

    static hasMany = [
      dictados: Dicta,
    ]

    static constraints = {
      nombre nullable: false
      apellido nullable: false
    }

    Dicta dictar(Materia materia, String cargo) {
      def d = new Dicta(materia: materia, profesor: this, cargo: cargo)
      this.dictados << d
      materia.dictados << d
      d
    }
}
