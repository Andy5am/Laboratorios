package nivel

import placa.Placa

class Nivel (
        val nombre: String,
        val identificador: String,
        val color: String,
        val estructura: String,
        var placas: ArrayList<Placa> = ArrayList()
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
    fun Nivel(nombre: String,identificador: String,color: String,estructura: String) {

    }

}
