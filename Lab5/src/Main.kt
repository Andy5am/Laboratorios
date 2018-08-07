package main

import nivel.Nivel
import parqueo.Parqueo
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

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
    var ejemplo:ArrayList<List<String>> = ArrayList()
    try {
        val lines = Files.lines(
                Paths.get("C:/Users/Andy Castillo/Documents/POO/parqueo.txt"),
                StandardCharsets.UTF_8
        )
        lines.forEach { a -> ejemplo.add(a.split("")) }
    } catch (e: IOException) {
        println("Error!")
    }

    var mapa: String =""
    for (i in 0 until  ejemplo.size){
        for (j in 0 until ejemplo.get(0).size){
            mapa+= ejemplo[i][j]
        }
        mapa+="\n"
    }
    println(mapa)

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

                }
            }
        }



    }while (continuar)


    

}