package estacionamiento

class Estacionamiento(
        val x:Int,
        val y:Int,
        var caracter:String
) {
    override fun toString(): String {
        return "$caracter"
    }
}