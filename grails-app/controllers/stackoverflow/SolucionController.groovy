package stackoverflow

class SolucionController {

    def solucionService

    def prueba() {
      def l = [1,2,3,4,5,6].collect { it * 2 }
      def m = [1,2,3,4,5,6].collectMany {
        [it, it * 2]
      }

      render "${l} ${m}"
    }

    def buscar2() {
      render Rol.get(2).nombre
      return

      def busqueda = [[Rol.get(2)]].collectEntries { cosso ->
        [
          cosso,
          cosso.list().collect {
            it.nombre
          },
        ]
      }
      render busqueda.toString()
    }

    def crearRol() {
      new Rol(algo: 'si').save()
      render "si"
    }

    def crearAlumno() {
      new Alumno(algo: 'si', padron: '2313123123').save()
      render "si"
    }

    def crearProfesor() {
      new Profesor(algo: 'si', nombre: '2313123123', apellido: '2313123123').save()
      render "si"
    }

    def buscar(Long id) {
      def profesor = Profesor.get(id)
      render profesor?.dictados*.materia ?: 'no hay'
    }

    def index() {
    }

    def crearGustos() {
      // def filtrados = params.findAll { k, v -> k.startsWith('gusto_') }
      // render filtrados.toString()
      def f = [params['gusto_']].flatten().grep()
      render f.toString()

    }


    // solucionService.crearDesafio("dasdasdad")
    // [fallo: request.fallo]

    def crearProgramador() {
      if (params.nombreDeUsuario) {
        def p = new Programador(
          nombre:  'aaaa',
          apellido:  'aaaa',
          // nombreDeUsuario:  params.nombreDeUsuario + new Random().nextInt(),
          nombreDeUsuario:  params.nombreDeUsuario,
          email:  'aaaa@aaa.com',
          icq  :  10000,
           puntaje: 10,
           lenguajes: 'Groovy',
        ).save(failOnError: true)

        redirect action: "verProgramador", id: p.id
      } else {
        forward action: 'index', model: [fallo: 1]
      }
    }

    def verProgramador(Long id) {
      def programador = Programador.get(id)
      [
        programador: programador,
      ]
    }
}
