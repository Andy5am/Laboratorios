package main

import nivel.Nivel
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
                    val newNivel = Nivel(nombre,id,color,estructura)
                    if(miparqueo.añadirNivel(newNivel)){
                        newNivel.hacerMapa(estructura)
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
                    miparqueo.niveles.forEach { a-> println(a) }
                }
                4-> {
                    administrador = false
                    nousuario = true
                }
            }
        }else {
            when (opcion){
                1-> {
                    println("Ingrese su placa: ")
                    val placa = readLine()!!
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
                                var nivelDePlaca = miparqueo.niveles.indexOf(i)
                                println("La placa tiene los siguientes datos: ")
                                println(miparqueo.niveles[nivelDePlaca])
                            }
                        }
                    }else {
                        var hayEspacios = false
                        var nivelesDisponibles: String = "Niveles disponibles:\n"
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
                            var nivel = readLine()!!
                            if (nivel in nivelesDisponibles) {
                                var mapa = miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!].mapa
                                var estacionamiento :String=""
                                for (i in 0 until mapa.size){
                                    for (j in 0 until mapa[0].size){
                                        estacionamiento+= mapa[i][j]
                                    }
                                    estacionamiento+="\n"
                                }
                                println(estacionamiento)
                                println("Elija el lugar para estacionarse: ")
                                var lugar = readLine()!!
                                if (lugar!="@") {
                                    miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!].actualizarMapa(lugar)
                                    val newPlaca = Placa(placa, lugar)
                                    miparqueo.niveles[miparqueo.encontrarNivel(nivel)!!].añadirPlaca(newPlaca)
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