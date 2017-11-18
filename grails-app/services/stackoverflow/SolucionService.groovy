package stackoverflow

class SolucionService {

    def programadorRepositorio

    // @Transactional
    def crearDesafio(String nombre) {
      // println("creando solucion con nombre=${nombre}")
        // Programador.get(id del programador).crearDesafio(nombre).save()
        Programador p = programadorRepositorio.getPorId()
        p.delete()



        // Programador.list()
        // Programador.findByICQ(333333)
        // Programador.findAllByICQ(333333)
        // Programador.findAllByICQAndNombre(333333, 'juasdsda')
        //
        // Programador p = Programador.get(3)
        // p.delete()
    }
}
