package aula.fib.br.apionkotlin.utils

import com.beust.klaxon.Klaxon
import aula.fib.br.apionkotlin.models.MovieData
import java.net.URL

object Util {
    fun parse(path: String?): List<String>?{
        val contents = URL(path).readText()
        val movieData = contents?.let { Klaxon().parse<MovieData>(it) }
        return movieData?.Search?.map{it.Title}
    }
}