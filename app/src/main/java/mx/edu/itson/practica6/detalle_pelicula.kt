package mx.edu.itson.practica6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)
        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val iv_nombre_pelicula :TextView = findViewById(R.id.tv_nombre_pelicula)
        val iv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)

        val bundle=intent.extras
        if (bundle != null){
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            iv_nombre_pelicula.setText(bundle.getString("titulo"))
            iv_pelicula_desc.setText(bundle.getString("sinopsis"))

            val button: Button = findViewById(R.id.buyTickets)

            button.setOnClickListener(){
                var intent: Intent =Intent(this,SeatSelection::class.java)
                startActivity(intent)
            }
        }
    }
}