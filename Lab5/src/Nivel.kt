package nivel

import estacionamiento.Estacionamiento
import pared.Pared
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
        val alto:Int,
        val ancho:Int,
        private var paredes: ArrayList<Pared> = ArrayList(),
        var placas: ArrayList<Placa> = ArrayList(),
        var estacionamientos:ArrayList<Estacionamiento> = ArrayList()
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
    fun añadirPared(pared: Pared){
        paredes.add(pared)
    }
    fun añadirEstacionamiento(estacionamiento:Estacionamiento){
        estacionamientos.add(estacionamiento)
    }
    fun hayPared(i:Int,j:Int):Boolean{
        for (a in paredes){
            if (a.x==i && a.y==j){
                return true
            }
        }
        return false
    }
    fun hayEstacionamiento(i:Int,j:Int):Boolean{
        for (a in estacionamientos){
            if (a.x==i && a.y==j){
                return true
            }
        }
        return false
    }
    fun obtenerEstacionamiento(i:Int,j:Int):Estacionamiento?{
        for (a in estacionamientos){
            if (a.x==i && a.y==j){
                return a
            }
        }
        return null
    }


    fun verEspacios():Boolean{
        for (i in 0 until alto){
            for (j in 0 until ancho){
                for (a in estacionamientos) {
                    if (a.caracter != "@") {
                        return true
                    }
                }
            }
        }
        return false
    }
    fun comprobarEstacionamiento(caracter:String):Boolean{
        for (i in estacionamientos){
            if (i.caracter==caracter){
                i.caracter="@"
                return true
            }
        }
        return false
    }


    override fun toString(): String {
        var map =""
        for (i in 0 until alto){
            for (j in 0 until ancho) {
                if (hayPared(i,j)){
                    map+="*"
                }else if (hayEstacionamiento(i,j)){
                    var caracter = obtenerEstacionamiento(i,j)
                    map+= caracter
                }else{
                    map+=" "
                }
            }
            map+="\n"
        }
        return """
            Mapa:
$map
        """.trimIndent()
    }
}
