package stackoverflow

class CapoTagLib {

  def grailsApplication

  def reCopado = { attrs, body ->
    out << "hola desde el taglib ${attrs}"
    out << body()
    out << body()
    out << body()
    out << body()
    out << body()
  }
}
