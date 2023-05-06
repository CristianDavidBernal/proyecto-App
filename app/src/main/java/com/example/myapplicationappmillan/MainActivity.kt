package com.example.myapplicationappmillan

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONArray
import java.lang.System.err

class MainActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignIn: Button
    private lateinit var buttonSignUp: Button

    override fun onBackPressed() {
        // Si el usuario presiona el botón de retroceso, cerrar la sesión y vaciar los campos de texto del login
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        editTextEmail.text.clear()
        editTextPassword.text.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignIn = findViewById(R.id.buttonSignIn)


        val passwordTextInputLayout = findViewById<TextInputLayout>(R.id.passwordTextInputLayout)
        val eyeIcon: Drawable = resources.getDrawable(R.drawable.ojo2, null)
        eyeIcon.setBounds(0, 0, eyeIcon.intrinsicWidth, eyeIcon.intrinsicHeight)

        editTextPassword.setCompoundDrawables(null, null, eyeIcon, null)

        editTextPassword.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableRightIndex = 2
                val drawable = editTextPassword.compoundDrawables[drawableRightIndex]
                if (event.rawX >= (editTextPassword.right - drawable.bounds.width())) {
                    togglePasswordVisibility()
                    return@setOnTouchListener true
                }
            }
            false
        }


        buttonSignIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            // Validar que el correo y la contraseña no estén vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese un correo y/o contraseña válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar que el correo tenga un formato válido
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Por favor ingrese un correo válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val url = "http://10.0.2.2:8000/employee/list/"

            val queue = Volley.newRequestQueue(this)

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    Log.d("RESPONSE", response)
                    val jsonArray = JSONArray(response)
                    var isAuthenticated = false
                    for (i in 0 until jsonArray.length()) {
                        val employee = jsonArray.getJSONObject(i)
                        if (employee.getString("email") == email && employee.getString("password") == password) {
                            isAuthenticated = true
                            break
                        }
                    }
                    if (isAuthenticated) {
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                },
                { error ->
                    // Manejar errores
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )

            queue.add(stringRequest)

            Toast.makeText(this, "Validando correo y contraseña...", Toast.LENGTH_SHORT).show()
        }




    }

    private fun togglePasswordVisibility() {
        if (editTextPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
            editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        editTextPassword.setSelection(editTextPassword.text.length)
    }


}
