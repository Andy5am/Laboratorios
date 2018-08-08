package placa

class Placa (
        val placa: String
){
    override fun toString():String{
        return """
            placa: $placa
        """.trimIndent()
    }
}