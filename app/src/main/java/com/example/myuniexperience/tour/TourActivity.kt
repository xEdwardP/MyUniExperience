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
                "La caseta tiene un diseño sencillo pero funcional, con espacios cercanos donde puedes sentarte a comer y socializar. Es común ver grupos de estudiantes compartiendo mientras disfrutan de sus alimentos. "
            ),
            Landmark(
                "Biblioteca",
                R.drawable.tour_biblioteca,
                "Centro de consulta y estudio equipado con libros físicos, acceso a recursos digitales y espacios de lectura silenciosa. Un lugar perfecto para la investigación y el aprendizaje autónomo. "
            ),
            Landmark(
                "Cancha de Futbol",
                R.drawable.tour_cancha,
                "Un espacio ideal para actividades deportivas y recreativas. Aquí se realizan partidos, torneos internos y momentos de convivencia estudiantil. También es usada para eventos y ferias."
            ),
            Landmark(
                "Capilla",
                R.drawable.tour_capilla,
                "Espacio dedicado a la oración y celebraciones religiosas. También se utiliza para momentos de reflexión personal o actividades pastorales."
            ),
            Landmark(
                "Laboratorio de MAC",
                R.drawable.tour_lab_mac,
                "Laboratorio de computación equipado con computadoras Apple. Ideal para diseño gráfico, edición de video, producción audiovisual y otras tareas creativas."
            ),
            Landmark(
                "Laboratorio de Robótica",
                R.drawable.tour_lab_robotica,
                "En el laboratorio de robotica los alumnos ponen en practica sus conocimientos, programando robots lego para que realicen lo que se les solicita"
            ),
            Landmark(
                "Consultorio Jurídico",
                R.drawable.tour_consultorio,
                "Espacio donde estudiantes de Derecho brindan atención legal supervisada. Sirve tanto como centro de práctica como servicio a la comunidad"
            ),
            Landmark(
                "Laboratorios de Industrial",
                R.drawable.tour_lab_industrial,
                "Laboratorios especializados para la carrera de Ingeniería Industrial. Equipados con herramientas y maquinaria para realizar prácticas relacionadas con procesos de producción, calidad y simulación."
            ),
            Landmark(
                "Laboratorios de Medicina",
                R.drawable.tour_lab_medicina,
                "Ambientes controlados para la enseñanza práctica de la medicina. Incluyen áreas para anatomía, microbiología y simulación clínica."
            ),
            Landmark(
                "Laboratorios de Civil",
                R.drawable.tour_lab_civil,
                "Espacios donde los estudiantes de Ingeniería Civil realizan pruebas de materiales, topografía, estructuras y diseño técnico."
            ),
            Landmark(
                "Laboratorios de Redes",
                R.drawable.tour_redes,
                "Laboratorios especializados para la carrera de Ingeniería Industrial. Equipados con herramientas y maquinaria para realizar prácticas relacionadas con procesos de producción, calidad y simulación."
            ),
            Landmark(
                "Laboratorio de Disección UNICAH (Necroteca)",
                R.drawable.tour_necroteca,
                "Sala de estudio anatómico con cuerpos o partes humanas conservadas para el aprendizaje en medicina. De uso exclusivo para prácticas clínicas."
            ),
            Landmark(
                "Laboratorios de Computación",
                R.drawable.tour_lab_computo,
                "Laboratorio de computación se usa para clases prácticas según el plan académico además de servir como otro método de búsquedas rápidas para otras carreras"
            ),
            Landmark(
                "Cámara Gesell",
                R.drawable.tour_lab_robotica,
                "Sala especializada para observación e investigación psicológica. Permite la evaluación de conductas a través de un espejo unidireccional, muy útil en prácticas clínicas y entrevistas."
            ),
            Landmark(
                "Bienestar Estudiantil (Pastoral)",
                R.drawable.tour_pastoral,
                "Departamento encargado de promover los valores cristianos en el campus. Organiza actividades espirituales, retiros, misas y acompañamiento personal."
            ),
            Landmark(
                "Registro",
                R.drawable.tour_registro,
                "Área administrativa donde se gestionan procesos académicos como matrículas, certificados, historial académico y otros trámites estudiantiles."
            ),
            Landmark(
                "Tesorería",
                R.drawable.tour_registro,
                "Punto donde los estudiantes realizan pagos relacionados con matrículas, mensualidades, constancias y otros servicios financieros de la universidad."
            ),
            Landmark(
                "Coordinación Académica",
                R.drawable.tour_coordinacion,
                "Espacio donde se planifican y coordinan las actividades académicas. Aquí se resuelven temas relacionados con horarios, clases, docentes y planes de estudio."
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

        val fullName = intent.getStringExtra("FULL_NAME") ?: "Visitante"

        val intent = Intent(this, EndTourActivity::class.java)
        intent.putExtra("FULL_NAME", fullName)
        startActivity(intent)
        finish()
    }
}