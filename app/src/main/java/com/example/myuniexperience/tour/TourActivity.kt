package com.example.myuniexperience.tour

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myuniexperience.R
import com.example.myuniexperience.databinding.ActivityTourBinding
import com.example.myuniexperience.model.Landmark

class TourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var landmarks: List<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        landmarks = listOf(
            Landmark(
                "Entrada Principal",
                R.drawable.tour_entrada_principal,
                "¡Bienvenido a la Universidad Católica de Honduras, Campus Santa Rosa de Lima! Al llegar a la entrada principal, te recibe un ambiente acogedor y lleno de identidad institucional  Aquí encontrarás seguridad universitaria, señalización clara hacia los distintos bloques (Santa Rosa de Lima, San Juan Bosco, Santa María y San José)."
            ),
            Landmark(
                "Monumento a la virgen",
                R.drawable.tour_monumento_virgen,
                "Con más de 500,000 volúmenes, la biblioteca central es el corazón académico del campus."
            ),
            Landmark(
                "Edificio Santa Rosa de Lima",
                R.drawable.tour_edificio_srl,
                "Bienvenido al corazón académico del campus. Este edificio, funcional y bien distribuido, está diseñado para facilitar tanto el aprendizaje teórico como práctico."
            ),
            Landmark(
                "Edificio Santa Maria",
                R.drawable.tour_edificio_sm,
                "Continuamos con el edificio Santa María. Este espacio alberga una amplia variedad de laboratorios y talleres especializados, utilizados por diversas carreras técnicas y científicas. Es un lugar dinámico y fundamental para las actividades prácticas del estudiantado. "
            ),
            Landmark(
                "Edificio San Juan Bosco",
                R.drawable.tour_edificio_sjb,
                "Este es el segundo edificio más importante del campus. Es un punto activo durante todo el día, ya que se imparten numerosas clases en sus aulas."
            ),
            Landmark(
                "Edificio San José",
                R.drawable.tour_edificio_sj,
                "Este es el segundo edificio más importante del campus. Es un punto activo durante todo el día, ya que se imparten numerosas clases en sus aulas."
            ),
            Landmark(
                "Caseta",
                R.drawable.tour_caseta,
                "Describir la caseta"
            ),
            Landmark(
                "Biblioteca",
                R.drawable.tour_biblioteca,
                "Describir la biblioteca"
            ),
            Landmark(
                "Cancha de Futbol",
                R.drawable.tour_cancha,
                "Describir la cancha de futbol"
            ),
            Landmark(
                "Capilla",
                R.drawable.tour_capilla,
                "Describir la capilla"
            ),
            Landmark(
                "Laboratorio de MAC",
                R.drawable.tour_lab_mac,
                "Describir el laboratorio de MAC"
            ),
            Landmark(
                "Laboratorio de Robótica",
                R.drawable.tour_lab_robotica,
                "Describir el laboratorio de robótica"
            ),
            Landmark(
                "Consultorio Jurídico",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorios de Industrial",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorios de Medicina",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorios de Civil",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorios de Redes",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorio de Disección UNICAH (Necroteca)",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Laboratorios de Computación",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Cámara Gesell",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Bienestar Estudiantil (Pastoral)",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Registro",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Tesorería",
                R.drawable.tour_lab_robotica,
                "Descripción"
            ),
            Landmark(
                "Coordinación Académica",
                R.drawable.tour_lab_robotica,
                "Descripción"
            )
        )

        // Configurar ViewPager2
        viewPager = binding.viewPager
        viewPager.adapter = LandmarkPagerAdapter(landmarks)

        // Mejorar rendimiento manteniendo páginas adyacentes en memoria
        (viewPager.getChildAt(0) as RecyclerView).apply {
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        viewPager.offscreenPageLimit = 1

        // Configurar indicador de progreso
        updateProgress(0)

        // Listeners para botones
        binding.btnPrev.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

        binding.btnNext.setOnClickListener {
            if (viewPager.currentItem < landmarks.size - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                finishTour()
            }
        }

        // Listener para cambios de página
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateProgress(position)
            }
        })
    }

    private fun updateProgress(position: Int) {
        // Actualizar barra de progreso y texto
        val progress = ((position + 1).toFloat() / landmarks.size) * 100
        binding.progressBar.progress = progress.toInt()
        binding.tvProgress.text = "${position + 1}/${landmarks.size}"

        // Actualizar botones
        binding.btnPrev.visibility = if (position > 0) View.VISIBLE else View.INVISIBLE
        binding.btnNext.text = if (position == landmarks.size - 1) "Finalizar" else "Siguiente"
    }

    private fun finishTour() {
        startActivity(Intent(this, EndTourActivity::class.java))
        finish()
    }
}