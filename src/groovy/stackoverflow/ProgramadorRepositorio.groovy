package stackoverflow

class ProgramadorRepositorio {

  String archivoDeLog

  Programador getPorId() {
    println(new File(archivoDeLog).text)

    Programador p = Programador.get(1000)
    if (!p) throw new IllegalArgumentException("no existe programador")
    p
  }

  List getSuperProgramadores() {
    //
  }
}
