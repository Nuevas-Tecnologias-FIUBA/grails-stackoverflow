package stackoverflow

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestMixin(GrailsUnitTestMixin)
class SolucionTests {

    Programador programador

    void setUp() {
      programador = new Programador(nombre: 'pablo cosso')
    }

    void tearDown() {
    }

    void 'test programador crea un desafio y quedo asociado como que soy el creador'() {

      Desafio desafio = programador.crearDesafio('un programa re copado')
      assert desafio.creador == programador
    }

    void 'test crear programador e intentar subir solucion siendo yo mismo no me deja'() {

      Desafio desafio = programador.crearDesafio('un programa re copado')
      Ejercicio ejercicio = desafio.crearEjercicio("escribi un programa")

      assert shouldFail(IllegalArgumentException) {
        programador.proponerSolucion(ejercicio, {"codigo"})
      } == "en tu cara"
    }

    void 'test un programador intentar subir solucion me deja xq no soy yo quien la creo'() {
      Programador programador1 = new Programador(nombre: 'pablo cosso')
      Programador programador2 = new Programador(nombre: 'marcos')
      Desafio desafio = programador1.crearDesafio('un programa re copado')
      Ejercicio ejercicio = desafio.crearEjercicio("escribi un programa")

      Solucion solucion = programador2.proponerSolucion(ejercicio, {"codigo"})
      assert solucion.participante == programador2
    }

    void 'test progamador sube una solucion que no anda entonces el resultado de la solucion es no pasa'() {
      Programador programador2 = new Programador(nombre: 'marcos')

      Desafio desafio = programador.crearDesafio('un programa re copado')
      Ejercicio ejercicio = desafio.crearEjercicio("escribi un programa")
      Prueba prueba = ejercicio.agregarPrueba('input', 'output')

      Closure codigo = {
        "gato"
      }

      Solucion solucion = programador2.proponerSolucion(ejercicio, codigo)
      ejercicio.validarSolucion(solucion)
      assert solucion.resultado == Solucion.Resultado.NO_PASA
    }



    void 'test progamador sube una solucion que anda bie  entonces el resultado de la solucion es pasa'() {
      Programador programador2 = new Programador(nombre: 'marcos')

      Desafio desafio = programador.crearDesafio('un programa re copado')
      Ejercicio ejercicio = desafio.crearEjercicio("escribi un programa")
      Prueba prueba = ejercicio.agregarPrueba('input', 'output')

      Closure codigo = {
        "output"
      }

      Solucion solucion = programador2.proponerSolucion(ejercicio, codigo)
      ejercicio.validarSolucion(solucion)
      assert solucion.resultado == Solucion.Resultado.PASA
    }
}
