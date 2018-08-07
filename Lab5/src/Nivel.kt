package nivel

import placa.Placa
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class Nivel (
        val nombre: String,
        val identificador: String,
        val color: String,
        val estructura: String,
        var placas: ArrayList<Placa> = ArrayList(),
        var mapa: ArrayList<List<String>> = ArrayList()
){
    fun encontrarPlaca(placa: String): Placa?{
        val placasFiltradas = placas.filter { it.placa == placa }
        if (placasFiltradas.count() > 0 ){
            return placasFiltradas[0]
        }
        return null
    }

    fun añadirPlaca(placa: Placa):Boolean{
        if(encontrarPlaca(placa.placa)==null){
            placas.add(placa)
            return true
        }
        return false
    }

    fun hacerMapa(estructura: String):ArrayList<List<String>>{
        try {
            val lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/$estructura"),
                    StandardCharsets.UTF_8
            )
            lines.forEach { a -> mapa.add(a.split("")) }
        } catch (e: IOException) {
            println("Error!")
        }
        return mapa
    }

    override fun toString(): String {
        var map =""
        for (i in 0 until mapa.size){
            for (j in 0 until mapa[0].size) {
                map += mapa[i][j]
            }
            map+="\n"
        }
        return """
            Nombre: $nombre
            Identificador: $identificador
            Color: $color
            Mapa:
$map
        """.trimIndent()
    }
}
