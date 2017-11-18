package stackoverflow

class Programador {

    String nombre
    String apellido
    String nombreDeUsuario
    String email
    Long icq

    // grasada mode on
    Double puntaje
    String lenguajes // separados por coma
    // grasada mode off

    Dinero platita

    static embedded = ['platita']

    static constraints = {
      nombre nullable: false, blank: false
      // nombre([nullable: false, blank: false])
      apellido nullable: false, blank: false
      nombreDeUsuario nullable: false, blank: false, unique: true
      email nullable: false, blank: false, email: true
      icq nullable: false
      puntaje nullable: false
      lenguajes nullable: false, validator: { valor ->
        (valor.split(',').grep() as Set).every { lang ->
          lang in ['C', 'Java', 'Python', 'Groovy', 'Swift'] && lang != 'PHP'
        }
      }
    }

    Desafio crearDesafio(String titulo) {
      new Desafio(titulo, this)
    }

    Solucion proponerSolucion(Ejercicio ejercicio, Closure codigo) {
      if (ejercicio.desafio.creador == this) {
        throw new IllegalArgumentException("en tu cara")
      }

      new Solucion(this, ejercicio, codigo)
    }
}
