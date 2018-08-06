package main

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

fun main (args: Array<String>) {
    var ejemplo:ArrayList<String> = ArrayList()
    try {
        val lines = Files.lines(
                Paths.get("C:/Users/Andy Castillo/Documents/POO/parqueo.txt"),
                StandardCharsets.UTF_8
        )
        lines.forEach { a -> ejemplo.add(a) }
    } catch (e: IOException) {
        println("Error!")
    }
    println(ejemplo)

    

}