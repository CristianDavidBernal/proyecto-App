package com.example.myapplicationappmillan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.*

class HomeActivity : AppCompatActivity() {
    var userList = arrayListOf<User>()
    var filteredList = arrayListOf<User>()
    val apiSample = "http://10.0.2.2:8000/order/list"
    var recyclerView: RecyclerView? = null
    lateinit var adapter: UserAdapter

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.setHasFixedSize(true)
        adapter = UserAdapter(userList)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter

        val logoutButton = findViewById<ImageView>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            // Muestra el diálogo de confirmación antes de salir
            AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Está seguro de que desea salir?")
                .setPositiveButton("Sí") { _, _ ->
                    val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    sharedPreferences.edit().clear().apply()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
        }


        val reqQueue: RequestQueue = Volley.newRequestQueue(this)
        val request = JsonArrayRequest(Request.Method.GET, apiSample, null, { res ->
            for (i in 0 until res.length()) {
                val jsonObj = res.getJSONObject(i)

                val user = User(
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("client_id")
                        .getString("name"), // obtiene el nombre del cliente
                    jsonObj.getInt("id"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getString("name"),
                    jsonObj.getJSONObject("process_id")
                        .getString("order_process"),
                    jsonObj.getJSONObject("payment_method")
                        .getString("payment_name"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("client_id")
                        .getInt("phone_number"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("client_id")
                        .getString("email"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("client_id")
                        .getString("address"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("client_id")
                        .getInt("nit"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getString("surface_finish"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getInt("tolerance"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getInt("linear"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getInt("angular"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getInt("size"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getInt("volume"),
                    jsonObj.getJSONObject("quote_number")
                        .getInt("quote_number"),
                    jsonObj.getInt("subtotal"),
                    jsonObj.getInt("freigth"),
                    jsonObj.getInt("various_expenses"),
                    jsonObj.getInt("amount_whitout_vat"),
                    jsonObj.getInt("total_amount"),
                    jsonObj.getString("delivery_address"),
                    jsonObj.getJSONObject("quote_number")
                        .getJSONObject("item_id")
                        .getString("plane"),



                    )

                userList.add(user)
            }

            adapter.notifyDataSetChanged()
        }, { err ->
            Log.d("Volley Sample Fail", err.message.toString())
        })

        reqQueue.add(request)

        val searchView = findViewById<SearchView>(R.id.searchEditText)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterUsers(newText)
                }

                return true
            }
        })
    }

    private fun filterUsers(query: String) {
        filteredList.clear()

        for (user in userList) {
            if (user.client.toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)) || user.id.toString().contains(query)) {
                filteredList.add(user)
            }

        }

        adapter.filterList(filteredList)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}