package aula.fib.br.apionkotlin.models

data class MovieData(val totalResults: String = "",
                     val Response: String = "True",
                     val Search: List<Movie>? = null )
