package aula.fib.br.apionkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import aula.fib.br.apionkotlin.R

class MovieAdapter(context: Context, lista: List<String>) : BaseAdapter() {

    private var listaMovies: List<String>
    private var inflator: LayoutInflater

    init {
        this.listaMovies = lista
        this.inflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return this.listaMovies.size
    }

    override fun getItem(position: Int): Any? {
        return this.listaMovies.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong() //this.listaMovies.get(position).Id;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val movie = this.listaMovies.get(position)
        //val bitmapImage = this.getBitmapFromAsset(contato.id)

        var holder: ViewHolder
        var retView: View

        if(convertView == null){
            retView = this.inflator.inflate(R.layout.linha, parent, false)
            holder = ViewHolder()
            holder.titulo = retView.findViewById<TextView>(R.id.title)
            //holder.foto = retView.findViewById<ImageView>(R.id.foto)
            retView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            retView = convertView
        }

        holder.titulo?.setText(movie)
        //holder.foto?.setImageBitmap(bitmapImage)

        return retView
    }

    /*private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = this.assetManager
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.jpg")
        }
        return BitmapFactory.decodeStream(istr)
    }*/

    internal class ViewHolder {
        var titulo: TextView? = null
        var foto: ImageView? = null
    }
}