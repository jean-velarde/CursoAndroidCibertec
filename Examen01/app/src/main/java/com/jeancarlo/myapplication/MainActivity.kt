package com.jeancarlo.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeancarlo.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    var costoServicio: Double = 0.0
    var instalacion: Double = 0.0
    var descuento: Double = 0.0
    var total: Double = 0.0
    var tipoServicio = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lyConstraint)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnImprimir.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            val data = "Resumen de servicio\nnombres del cliente:${binding.etNombre.text}\nServicio:$tipoServicio\nTotal:$total"
            intent.putExtra("data",data)
            startActivity(intent)
        }

        binding.btnCal.setOnClickListener {
            if (binding.rbDuo.isChecked){
                costoServicio = 109.0
                instalacion = 35.0
                descuento = costoServicio * 0.05
                total = (costoServicio + instalacion) - descuento
                binding.etCostoServicio.text = "$costoServicio".toEditable()
                binding.etInstalacion.text = "$instalacion".toEditable()
                binding.etDescuento.text = "$descuento".toEditable()
                tipoServicio = "Duo"
                binding.etTotal.text = "$total".toEditable()
            }else if (binding.rbTrio.isChecked){
                costoServicio = 159.0
                instalacion = 60.0
                descuento = costoServicio * 0.10
                total = (costoServicio + instalacion) - descuento
                binding.etCostoServicio.text = "$costoServicio".toEditable()
                binding.etInstalacion.text = "$instalacion".toEditable()
                binding.etDescuento.text = "$descuento".toEditable()
                tipoServicio = "Trio"
                binding.etTotal.text = "$total".toEditable()
            }else if (binding.rbInternet.isChecked){
                costoServicio = 89.0
                instalacion = 15.0
                descuento = costoServicio * 0.02
                total = (costoServicio + instalacion) - descuento
                binding.etCostoServicio.text = "$costoServicio".toEditable()
                binding.etInstalacion.text = "$instalacion".toEditable()
                binding.etDescuento.text = "$descuento".toEditable()
                tipoServicio = "internet"
                binding.etTotal.text = "$total".toEditable()
            }else if (binding.rbTelefono.isChecked){
                costoServicio = 59.0
                instalacion = 12.0
                descuento = costoServicio * 0.01
                total = (costoServicio + instalacion) - descuento
                binding.etCostoServicio.text = "$costoServicio".toEditable()
                binding.etInstalacion.text = "$instalacion".toEditable()
                binding.etDescuento.text = "$descuento".toEditable()
                tipoServicio = "Trio"
                binding.etTotal.text = "$total".toEditable()
            }else if (binding.rbCable.isChecked){
                costoServicio = 79.0
                instalacion = 15.0
                descuento = costoServicio * 0.01
                total = (costoServicio + instalacion) - descuento
                binding.etCostoServicio.text = "$costoServicio".toEditable()
                binding.etInstalacion.text = "$instalacion".toEditable()
                binding.etDescuento.text = "$descuento".toEditable()
                tipoServicio = "cable"
                binding.etTotal.text = "$total".toEditable()
            }else{
                Toast.makeText(this,"Seleccione servicio",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}