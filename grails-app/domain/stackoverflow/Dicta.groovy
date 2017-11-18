package stackoverflow

class Dicta {

    Profesor profesor
    Materia materia
    String cargo

    static mapping = {
      table 'dictadas'
      version false
    }

    static constraints = {
      profesor nullable: false
      materia nullable: false
      cargo nullable: false
    }
}
