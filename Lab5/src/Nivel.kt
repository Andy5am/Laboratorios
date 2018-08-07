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
        var mapa: ArrayList<Array<String>> = ArrayList()
){
    fun encontrarPlaca(placa: String): Boolean{
        val placasFiltradas = placas.filter { it.placa == placa }
        if (placasFiltradas.count() > 0 ){
            return true
        }
        return false
    }

    fun añadirPlaca(placa: Placa):Boolean{
        if(!encontrarPlaca(placa.placa)){
            placas.add(placa)
            return true
        }
        return false
    }

    fun hacerMapa(estructura: String): ArrayList<Array<String>> {
        try {
            val lines = Files.lines(
                    Paths.get("C:/Users/Andy Castillo/Documents/POO/$estructura"),
                    StandardCharsets.UTF_8
            )
            lines.forEach { a -> mapa.add(a.split("").toTypedArray()) }
        } catch (e: IOException) {
            println("Error!")
        }
        return mapa
    }

    fun verEspacios():Boolean{
        for (i in 0 until mapa.size){
            for (j in 0 until mapa[0].size){
                if (mapa[i][j]!= " "&& mapa[i][j]!= "*"&&mapa[i][j]!="@"){
                    return true
                }
            }
        }
        return false
    }
    fun actualizarMapa(lugar:String):Boolean{
        for (i in 0 until mapa.size){
            for (j in 0 until mapa[0].size){
                if (lugar == mapa[i][j]){
                    mapa[i][j] = "@"
                    return true
                }
            }
        }
        return false
    }

    override fun toString(): String {
        var map =""
        for (i in 0 until mapa.size){
            for (j in 0 until mapa[0].size) {
                var lugar:String=mapa[i][j]
                if (placas.forEach { a->a.lugar }.equals(mapa[i][j])){
                    mapa[i][j].replace(lugar,"@")
                }
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
