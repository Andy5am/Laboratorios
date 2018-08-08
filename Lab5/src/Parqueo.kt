package parqueo

import estacionamiento.Estacionamiento
import nivel.Nivel
import pared.Pared
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class Parqueo(
      var niveles: ArrayList<Nivel> = ArrayList()
){
    fun encontrarNivel(nivel: String): Int? {
        val nivelesFiltrados = niveles.filter { it.identificador == nivel }
        if (nivelesFiltrados.count() > 0 ){
            return niveles.indexOf(nivelesFiltrados[0])
        }
        return null
    }

    fun eliminarNIvel(index:Int){
            niveles.removeAt(index)
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
    fun crearNivel(archivo:String,nombre:String, id:String,color:String):Nivel{
        val mapa :ArrayList<Array<String>> = ArrayList()
        try {
            val lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/$archivo"),
                    StandardCharsets.UTF_8
            )
            lines.forEach { a -> mapa.add(a.split("").toTypedArray()) }
        } catch (e: IOException) {
            println("Error!")
        }
        val newNivel = Nivel(nombre,id,color,archivo,mapa.size, mapa[0].size)
        for (i in 0 until newNivel.alto){
            for (j in 0 until newNivel.ancho){
                val caracter= mapa[i][j]
                when (caracter){
                    " "-> {

                    }
                    "*"->{
                        val nuevaPared = Pared(i,j)
                        newNivel.añadirPared(nuevaPared)
                    }
                    else->{
                        val simbolo = caracter
                        val nuevoEstacionamiento = Estacionamiento(i,j,simbolo)
                        newNivel.añadirEstacionamiento(nuevoEstacionamiento)
                    }
                }
            }
        }

        return newNivel


    }



}