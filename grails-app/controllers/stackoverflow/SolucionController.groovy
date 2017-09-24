package stackoverflow

class SolucionController {

    def index() {
      [:]
    }

    def verProgramadores() {
      // [programadores: Programador.list(offset: 20, max: 10)]
      [programadores: Programador.list().grep { programador ->
        programador.lenguajes == 'Groovy'
       }]
    }

    def crearProgramador() {
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
    }

    def verProgramador(Long id) {
      def programador = Programador.get(id)
      [
        programador: programador,
      ]
    }
}
