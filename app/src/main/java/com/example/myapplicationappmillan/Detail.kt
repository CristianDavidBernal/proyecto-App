package com.example.myapplicationappmillan

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val linearLayoutDetail = findViewById<LinearLayout>(R.id.layoutview)

        val userClient = intent.getStringExtra("user_client")
        val userId = intent.getIntExtra("user_id", 0)
        val userNameItem = intent.getStringExtra("user_nameItem")
        val userop = intent.getStringExtra("user_orderProcess")
        val userpayment_name = intent.getStringExtra("user_payment")
        val userphone_numberCli = intent.getIntExtra("user_phoneNC", 0)
        val useremailC = intent.getStringExtra("user_emailC")
        val useraddreC = intent.getStringExtra("user_addresC")
        val userniC = intent.getIntExtra("user_nitC", 0)
        val usersurfa = intent.getStringExtra("user_surfaceI")
        val userTI = intent.getIntExtra("user_toleranceI", 0)
        val usernLI = intent.getIntExtra("user_linearI", 0)
        val userAngu = intent.getIntExtra("user_angularI", 0)
        val userSize = intent.getIntExtra("user_sizeI", 0)
        val userVolume = intent.getIntExtra("user_volumeI", 0)
        val userQN = intent.getIntExtra("user_quoteN", 0)
        val userSubT = intent.getIntExtra("user_subtotal", 0)
        val userFre = intent.getIntExtra("user_freigth", 0)
        val userVari = intent.getIntExtra("user_varius", 0)

        val useramountW = intent.getIntExtra("user_amount_whitout_vat", 0)
        val userTA = intent.getIntExtra("user_totalAmo", 0)
        val userDA = intent.getStringExtra("user_deliverA")

        val Descripcion = TextView(this)
        Descripcion.text = "DESCRIPCIÓN DE LA ORDEN"
        Descripcion.setTypeface(null, Typeface.BOLD)
        Descripcion.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        Descripcion.gravity = Gravity.CENTER
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, resources.getDimensionPixelSize(R.dimen.space_height))
        Descripcion.layoutParams = layoutParams
        linearLayoutDetail.addView(Descripcion)


        val textViewClientName = TextView(this)
        textViewClientName.text = "Nombre del cliente: $userClient"
        textViewClientName.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewClientName)

        val separatorView = View(this)
        separatorView.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params.setMargins(0, 16, 0, 16)
        separatorView.layoutParams = params
        linearLayoutDetail.addView(separatorView)

        val textViewClientEmail = TextView(this)
        textViewClientEmail.text = "Correo del cliente: $useremailC"
        textViewClientEmail.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewClientEmail)


        val separatorView2 = View(this)
        separatorView2.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params2.setMargins(0, 16, 0, 16)
        separatorView2.layoutParams = params2
        linearLayoutDetail.addView(separatorView2)

        val textViewOrderProcess = TextView(this)
        textViewOrderProcess.text = "Proceso de la orden: $userop"
        textViewOrderProcess.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewOrderProcess)

        val separatorView3 = View(this)
        separatorView3.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params3.setMargins(0, 16, 0, 16)
        separatorView3.layoutParams = params3
        linearLayoutDetail.addView(separatorView3)

        val textViewItemName = TextView(this)
        textViewItemName.text = "Nombre del item: $userNameItem"
        textViewItemName.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemName)

        val separatorView4 = View(this)
        separatorView4.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params4 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params4.setMargins(0, 16, 0, 16)
        separatorView4.layoutParams = params4
        linearLayoutDetail.addView(separatorView4)

        val textViewItemsufa = TextView(this)
        textViewItemsufa.text = "Acabado superficial: $usersurfa"
        textViewItemsufa.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemsufa)

        val separatorView5 = View(this)
        separatorView5.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params5 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params5.setMargins(0, 16, 0, 16)
        separatorView5.layoutParams = params5
        linearLayoutDetail.addView(separatorView5)

        val textViewItemTolerance = TextView(this)
        textViewItemTolerance.text = "Tolerancia: $userTI"
        textViewItemTolerance.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemTolerance)

        val separatorView6 = View(this)
        separatorView6.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params6 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params6.setMargins(0, 16, 0, 16)
        separatorView6.layoutParams = params6
        linearLayoutDetail.addView(separatorView6)

        val textViewItemLineal = TextView(this)
        textViewItemLineal.text = "Lineal: $usernLI"
        textViewItemLineal.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemLineal)

        val separatorView7 = View(this)
        separatorView7.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params7 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params7.setMargins(0, 16, 0, 16)
        separatorView7.layoutParams = params7
        linearLayoutDetail.addView(separatorView7)

        val textViewItemAngular = TextView(this)
        textViewItemAngular.text = "Angular: $userAngu"
        textViewItemAngular.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemAngular)

        val separatorView8 = View(this)
        separatorView8.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params8 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params8.setMargins(0, 16, 0, 16)
        separatorView8.layoutParams = params8
        linearLayoutDetail.addView(separatorView8)

        val textViewItemTamaño = TextView(this)
        textViewItemTamaño.text = "Tamaño: $userSize"
        textViewItemTamaño.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemTamaño)

        val separatorView9 = View(this)
        separatorView9.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params9 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params9.setMargins(0, 16, 0, 16)
        separatorView9.layoutParams = params9
        linearLayoutDetail.addView(separatorView9)

        val textViewItemVolumen = TextView(this)
        textViewItemVolumen.text = "Volumen: $userVolume"
        textViewItemVolumen.setTypeface(null, Typeface.BOLD)
        linearLayoutDetail.addView(textViewItemVolumen)

        val separatorView10 = View(this)
        separatorView10.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        val params10 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2)
        params10.setMargins(0, 16, 0, 16)
        separatorView10.layoutParams = params10
        linearLayoutDetail.addView(separatorView10)



        // Agrega más TextViews según los datos que deseas mostrar

        // ...
    }
}
