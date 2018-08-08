package main

import parqueo.Parqueo
import placa.Placa

fun getMenuInicial(nada:Boolean, administrador:Boolean):String{
    if (nada){
        return """
            MENU:
                1. Administrador
                2. Usuario
                3. Salir
        """.trimIndent()
    }
    if (administrador){
        return """
            MENU:
                1. Crear nivel
                2. Eliminar nivel
                3. Ver todos los niveles
                4. Salir
        """.trimIndent()
    }
    return """
        MENU:
            1.Ingresar placa
            2. Salir
    """.trimIndent()
}

fun main (args: Array<String>) {

    val miparqueo = Parqueo()
    var continuar = true
    var nousuario = true
    var administrador = false
    do {
        println(getMenuInicial(nousuario,administrador))

        println("Ingrese una opcion: ")
        val strOpcion = readLine()!!
        val opcion = strOpcion.toInt()
        if (nousuario){
            when (opcion){
                1-> {
                    nousuario = false
                    administrador= true
                }
                2-> {
                    nousuario= false
                }
                3-> {
                    continuar = false
                }
            }
        } else if (administrador){
            when (opcion){
                1-> {
                    println("Ingrese el nombre del nivel: ")
                    val nombre = readLine()!!
                    println("Ingrese el identificador del nivel: ")
                    val id = readLine()!!
                    println("Ingrese el color del nivel: ")
                    val color = readLine()!!
                    println("Ingrese el nombre del archivo de la estructura: ")
                    val estructura = readLine()!!
                    val newNivel =miparqueo.crearNivel(estructura,nombre,id,color)
                    if(miparqueo.añadirNivel(newNivel)){
                        println("Se añadio el nivel")
                    }else{
                        println("El nivel ya existe")
                    }
                }
                2-> {
                    println("Ingrese el identificador del nivel a borrar: ")
                    val id = readLine()!!
                    if (miparqueo.encontrarNivel(id)!= null){
                        miparqueo.eliminarNIvel(miparqueo.encontrarNivel(id)!!)
                        println("Se ha borrado el nivel")
                    }else{
                        println("El nivel no existe")
                    }
                }
                3-> {
                    miparqueo.niveles.forEach { a-> println("""
                        Nombre: ${a.nombre}
                        Identificador:${a.identificador}
                        Color:${a.color}
                        Archivo de estructura:${a.estructura}
                        Placas registradas:${a.placas}
                        $a
                    """.trimIndent()) }
                }
                4-> {
                    administrador = false
                    nousuario = true
                }
            }
        }else {
            when (opcion){
                1-> {
                    var placa = ""
                    println("Ingrese su placa: ")
                    placa = readLine()!!
                    var existePlaca = false
                    for (i in miparqueo.niveles){
                        if (i.encontrarPlaca(placa)){
                            existePlaca=true
                        }
                    }
                    if (existePlaca){
                        println("La placa ya esta registrada")
                        for (i in miparqueo.niveles){
                            if (i.encontrarPlaca(placa)){
                                val nivelDePlaca = miparqueo.niveles.indexOf(i)
                                println("La placa tiene los siguientes datos: ")
                                println(miparqueo.niveles[nivelDePlaca])
                            }
                        }
                    }else {
                        var hayEspacios = false
                        var nivelesDisponibles = "Niveles disponibles:\n"
                        for (i in miparqueo.niveles){
                            i.verEspacios()
                            if (i.verEspacios()){
                                nivelesDisponibles+=i.identificador+"\n"
                                hayEspacios = true
                            }
                        }
                        if (hayEspacios) {
                            println(nivelesDisponibles)
                            println("Ingrese el identificador del nivel en el que desea parquearse: ")
                            val nivel = readLine()!!
                            if (nivel in nivelesDisponibles) {
                                println(miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!])
                                println("Elija el lugar para estacionarse: ")
                                val lugar = readLine()!!
                                if (lugar!="@") {
                                    if(miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!].comprobarEstacionamiento(lugar)) {
                                        val newPlaca = Placa(placa)
                                        miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!].añadirPlaca(newPlaca)
                                    }else{
                                        println("No existe ese estacionamiento")
                                    }
                                }else{
                                    println("Ese lugar esta ocupado")
                                }
                            } else {
                                println("Ese nivel no esta en las opciones")
                            }
                        }else {
                            println("No hay espacio para parquearse")
                        }
                    }
                }
                2-> {
                    nousuario = true
                }
            }
        }
    }while (continuar)


    

}