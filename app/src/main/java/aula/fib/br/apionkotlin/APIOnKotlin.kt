package aula.fib.br.apionkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.ListView
import aula.fib.br.apionkotlin.adapters.MovieAdapter
import aula.fib.br.apionkotlin.utils.Constants.API_KEY
import aula.fib.br.apionkotlin.utils.Constants.URL_SERVIDOR
import aula.fib.br.apionkotlin.utils.Util
import org.jetbrains.anko.*


class APIOnKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apion_kotlin)
    }

    override fun onResume() {
        super.onResume()
        getMovies()
    }

    private fun getMovies() {
        var displayMessage = indeterminateProgressDialog("Aguarde") //Cria uma distração para o usuário, uma bolinha carregando com a mensagem Aguarde
        displayMessage.show() //Mostra a distração

        doAsync{ //Faz a busca asycronamente
            var movies = Util.parse(" http://www.omdbapi.com/?i=tt3896198&apikey=7e231a5e&type=movie&r=json&s=brazil&page=1") // Consulta os filmes e retorna uma lista com os títulos

            uiThread{ //
                movies.let { // só continuará se o let verificar que o movies não esta nullo, se não estiver, entra no bloco abaixo
                    //val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, movies) //Cria um Adapter para a lista]
                    val adapter = MovieAdapter(baseContext, movies!!) //Cria um Adapter para a lista
                    var lista = findViewById<ListView>(R.id.movies)
                    lista.adapter = adapter //Seta o adapter na lista
                }
            }
            displayMessage.dismiss() //Tira a distração
        }
    }
}