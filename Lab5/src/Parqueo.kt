package parqueo

import nivel.Nivel
import placa.Placa

class Parqueo(
      var niveles: ArrayList<Nivel> = ArrayList()
){
    fun encontrarNivel(nivel: String): Nivel?{
        val nivelesFiltrados = niveles.filter { it.identificador == nivel }
        if (nivelesFiltrados.count() > 0 ){
            return nivelesFiltrados[0]
        }
        return null
    }

    fun eliminarNIvel(nivel: Nivel):Boolean{
        if(encontrarNivel(nivel.identificador)==null){
            niveles.remove(nivel)
            return true
        }
        return false
    }
    fun añadirNivel(nivel: Nivel):Boolean{
        val idFiltrados = niveles.filter { it.identificador == nivel.identificador }
        val nombresFiltrados = niveles.filter { it.nombre == nivel.nombre }
        val coloresFiltrados = niveles.filter { it.color == nivel.color }
        if (idFiltrados.count() == 0 && nombresFiltrados.count()==0 && coloresFiltrados.count()==0){
            niveles.add(nivel)
            return true
        }
        return false
    }

}