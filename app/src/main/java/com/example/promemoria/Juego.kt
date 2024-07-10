package com.example.promemoria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Juego : AppCompatActivity() {

    //<editor-fold desc="IMAGENES">
    lateinit var iv_11: ImageView
    lateinit var iv_12: ImageView
    lateinit var iv_13: ImageView

    lateinit var iv_21: ImageView
    lateinit var iv_22: ImageView
    lateinit var iv_23: ImageView

    lateinit var iv_31: ImageView
    lateinit var iv_32: ImageView
    lateinit var iv_33: ImageView

    lateinit var iv_41: ImageView
    lateinit var iv_42: ImageView
    lateinit var iv_43: ImageView
    //</editor-fold>

    //<editor-fold desc="OTROS">
    lateinit var tv_tiempo: TextView

    lateinit var imagen1: ImageView
    lateinit var imagen2: ImageView
    //</editor-fold>

    //<editor-fold desc="VARIABLES">
    var imagenesArray = arrayOf(11,12,13,14,15,16,21,22,23,24,25,26)
    var img1 = 0
    var img2 = 0
    var img3 = 0
    var img4 = 0
    var img5 = 0
    var img6 = 0
    var clickImg = 1
    var tiempo = 25

    //</editor-fold>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        enlazarGUI()
        cuentaAtras()
    }

    private fun cuentaAtras() {
        object : CountDownTimer(26000,1000){
            override fun onTick(millisUntilFinished: Long) {
                tiempo = (millisUntilFinished/1000).toInt()
                tv_tiempo.setText("" + tiempo + "s" )
            }

            override fun onFinish() {
                if (tiempo == 0 && !iv_11.tag.toString().isEmpty() ||
                    !iv_12.tag.toString().isEmpty() ||
                    !iv_13.tag.toString().isEmpty() ||
                    !iv_21.tag.toString().isEmpty() ||
                    !iv_22.tag.toString().isEmpty() ||
                    !iv_23.tag.toString().isEmpty() ||
                    !iv_31.tag.toString().isEmpty() ||
                    !iv_32.tag.toString().isEmpty() ||
                    !iv_33.tag.toString().isEmpty() ||
                    !iv_41.tag.toString().isEmpty() ||
                    !iv_42.tag.toString().isEmpty() ||
                    !iv_43.tag.toString().isEmpty()){
                    validarDerrota()
                }

            }
        }.start()
    }

    private fun validarDerrota(){
        val intent = Intent(this, Derrota::class.java)
        startActivity(intent)
        finish()
    }

    private fun enlazarGUI() {
        iv_11 = findViewById(R.id.iv_11)
        iv_12 = findViewById(R.id.iv_12)
        iv_13 = findViewById(R.id.iv_13)
        iv_21 = findViewById(R.id.iv_21)
        iv_22 = findViewById(R.id.iv_22)
        iv_23 = findViewById(R.id.iv_23)
        iv_31 = findViewById(R.id.iv_31)
        iv_32 = findViewById(R.id.iv_32)
        iv_33 = findViewById(R.id.iv_33)
        iv_41 = findViewById(R.id.iv_41)
        iv_42 = findViewById(R.id.iv_42)
        iv_43 = findViewById(R.id.iv_43)

        tv_tiempo=findViewById(R.id.tv_tiempo)

        iv_11.tag = "0"
        iv_12.tag = "1"
        iv_13.tag = "2"
        iv_21.tag = "3"
        iv_22.tag = "4"
        iv_23.tag = "5"
        iv_31.tag = "6"
        iv_32.tag = "7"
        iv_33.tag = "8"
        iv_41.tag = "9"
        iv_42.tag = "10"
        iv_43.tag = "11"

        img1 = R.drawable.calabaza1
        img2 = R.drawable.chilosos2
        img3 = R.drawable.chiswis1
        img4 = R.drawable.crunch1
        img5 = R.drawable.gato1
        img6 = R.drawable.sombrero1

        imagenesArray.shuffle()
        cuentaAtras()
    }

    fun seleccionar(imagen: View){
        verificar(imagen)
    }

    private fun verificar(imagen: View) {
        var iv=(imagen as ImageView)
        var tag = imagen.tag.toString().toInt()
        if(imagenesArray[tag]==11){
            iv.setImageResource(img1)
        } else if(imagenesArray[tag]==12){
            iv.setImageResource(img2)
        } else if(imagenesArray[tag]==13){
            iv.setImageResource(img3)
        } else if(imagenesArray[tag]==14){
            iv.setImageResource(img4)
        } else if(imagenesArray[tag]==15){
            iv.setImageResource(img5)
        } else if(imagenesArray[tag]==16){
            iv.setImageResource(img6)
        } else if(imagenesArray[tag]==21){
            iv.setImageResource(img1)
        } else if(imagenesArray[tag]==22){
            iv.setImageResource(img2)
        } else if(imagenesArray[tag]==23){
            iv.setImageResource(img3)
        } else if(imagenesArray[tag]==24){
            iv.setImageResource(img4)
        } else if(imagenesArray[tag]==25){
            iv.setImageResource(img5)
        } else if(imagenesArray[tag]==26){
            iv.setImageResource(img6)
        }

        if(clickImg==1){
            imagen1 = iv
            clickImg = 2
            iv.isEnabled = false
        } else if(clickImg==2) {
            imagen2 = iv
            clickImg = 1
            iv.isEnabled = false

            deshabilitarImagenes()
            val h = Handler(Looper.getMainLooper())
            h.postDelayed({sonIguales()},1000)
        }
    }

    private fun sonIguales() {
        if (imagen1.drawable.constantState == imagen2.drawable.constantState){

            imagen1.isEnabled = false
            imagen2.isEnabled = false
            imagen1.tag = ""
            imagen2.tag = ""

        } else {
            imagen1.setImageResource(R.drawable.oculta)
            imagen2.setImageResource(R.drawable.oculta)
        }

        iv_11.isEnabled = !iv_11.tag.toString().isEmpty()
        iv_12.isEnabled = !iv_12.tag.toString().isEmpty()
        iv_13.isEnabled = !iv_13.tag.toString().isEmpty()
        iv_21.isEnabled = !iv_21.tag.toString().isEmpty()
        iv_22.isEnabled = !iv_22.tag.toString().isEmpty()
        iv_23.isEnabled = !iv_23.tag.toString().isEmpty()
        iv_31.isEnabled = !iv_31.tag.toString().isEmpty()
        iv_32.isEnabled = !iv_32.tag.toString().isEmpty()
        iv_33.isEnabled = !iv_33.tag.toString().isEmpty()
        iv_41.isEnabled = !iv_41.tag.toString().isEmpty()
        iv_42.isEnabled = !iv_42.tag.toString().isEmpty()
        iv_43.isEnabled = !iv_43.tag.toString().isEmpty()

        verificarFinJuego()
    }

    private fun verificarFinJuego() {
        if (iv_11.tag.toString().isEmpty() &&
            iv_12.tag.toString().isEmpty() &&
            iv_13.tag.toString().isEmpty() &&
            iv_21.tag.toString().isEmpty() &&
            iv_22.tag.toString().isEmpty() &&
            iv_23.tag.toString().isEmpty() &&
            iv_31.tag.toString().isEmpty() &&
            iv_32.tag.toString().isEmpty() &&
            iv_33.tag.toString().isEmpty() &&
            iv_41.tag.toString().isEmpty() &&
            iv_42.tag.toString().isEmpty() &&
            iv_43.tag.toString().isEmpty() &&
            tiempo >= 0
        ){
            val intent = Intent(this, Victoria::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun deshabilitarImagenes() {
        iv_11.isEnabled = false
        iv_12.isEnabled = false
        iv_13.isEnabled = false
        iv_21.isEnabled = false
        iv_22.isEnabled = false
        iv_23.isEnabled = false
        iv_31.isEnabled = false
        iv_32.isEnabled = false
        iv_33.isEnabled = false
        iv_41.isEnabled = false
        iv_42.isEnabled = false
        iv_43.isEnabled = false
    }
}