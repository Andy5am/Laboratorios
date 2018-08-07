package placa

class Placa (
        val placa: String,
        val lugar: String
){
    override fun toString():String{
        return """
            placa: $placa
            lugar: $lugar
        """.trimIndent()
    }
}