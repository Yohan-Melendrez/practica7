package mx.edu.itson.practica6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class catalogo : AppCompatActivity() {
        var adapter:PeliculaAdapter?=null
        var seriesAdapter:PeliculaAdapter?=null
        var peliculas=ArrayList<Pelicula>()
        var series=ArrayList<Pelicula>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_catalogo)
            cargarPeliculas()
            adapter=PeliculaAdapter(this,peliculas)
            seriesAdapter=PeliculaAdapter(this,series)
            var gridPelis: GridView = findViewById(R.id.movies_catalogo)
            var gridSeries: GridView = findViewById(R.id.series_catalogo)
            gridPelis.adapter=adapter
            gridSeries.adapter=seriesAdapter

        }
    fun cargarPeliculas(){
        peliculas.add(Pelicula(  "Demon Slayer To the Hashira Training",R.drawable.demon, R.drawable.demo, "Tanjiro se enfrenta al demonio Hantengu, mientras los hashira se preparan para la gran batalla contra Muzan Kibutsuji. ",arrayListOf<Cliente>()))
        peliculas.add(Pelicula( "Dune", R.drawable.dune, R.drawable.dune2, "Duna: Parte Dos explorará el viaje mítico de Paul Atreides.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula(  "Ghostbusters Apocalipsis", R.drawable.ghostbusters, R.drawable.ghostbusters, "Los Cazafantasmas deben salvar al mundo de un apocalipsis paranormal.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula( "Héroe Por Encargo", R.drawable.heroexencargo,R.drawable.heroeencargo, "Un hombre común recibe un misterioso traje con superpoderes.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula( "Madame Web", R.drawable.madameweb, R.drawable.madame, "Mientras tanto, en el universo de Spider-Man...",arrayListOf<Cliente>() ))
        peliculas.add(Pelicula(  "Vidas Pasadas", R.drawable.vidaspasadas,R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia, se reencuentran después de muchos años.",arrayListOf<Cliente>()))

        series.add(Pelicula(  "Avatar: La Leyenda de Aang", R.drawable.ant, R.drawable.ant, "La serie sigue a Aang, el último Maestro Aire, en su lucha contra la Nación del Fuego.",arrayListOf<Cliente>()))
        series.add(Pelicula( "Halo", R.drawable.halo, R.drawable.halos, "Una evacuación mortal cambia la vida del Jefe Maestro.",arrayListOf<Cliente>()))
        series.add(Pelicula(  "Leveling", R.drawable.sololeveling, R.drawable.sololevelings, "En un mundo donde los cazadores luchan contra monstruos, un joven adquiere un misterioso poder.",arrayListOf<Cliente>()))
        series.add(Pelicula(  "Mi adorable demonio", R.drawable.adorabledemonio, R.drawable.adorabledemonios,  "Una historia de amor inesperada entre un humano y un demonio.",arrayListOf<Cliente>()))
        series.add(Pelicula(  "El Monstruo de la Vieja Seúl", R.drawable.elmonstruo, R.drawable.elmonstruovieja, "En una Seúl apocalíptica, un grupo de sobrevivientes lucha contra criaturas terroríficas.",arrayListOf<Cliente>()))
        series.add(Pelicula( "Witcher", R.drawable.thewitcher, R.drawable.thewitchers, "Geralt de Rivia, un cazador de monstruos, enfrenta nuevas amenazas en su viaje.",arrayListOf<Cliente>()))
    }
}

    class PeliculaAdapter: BaseAdapter {
        var peliculas=ArrayList<Pelicula>()
        var context: Context?=null
        constructor(context: Context, peliculas:ArrayList<Pelicula>):super(){
            this.peliculas=peliculas
            this.context=context
        }
        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula = peliculas[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.pelicula,  null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell)
            var title: TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener() {
                val intento = Intent(context, detalle_pelicula::class.java)
                intento.putExtra("titulo", pelicula.titulo)
                intento.putExtra("imagen", pelicula.image)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                intento.putExtra("numberSeats",(20-pelicula.seats.size))
                context!!.startActivity(intento)
            }

            return vista    }


    }