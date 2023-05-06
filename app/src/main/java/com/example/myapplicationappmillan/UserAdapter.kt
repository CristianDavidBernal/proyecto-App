package com.example.myapplicationappmillan


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class UserAdapter(private var userList: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    private lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.imageView)
        val cliente = itemView.findViewById<TextView>(R.id.tvCliente)
        val id = itemView.findViewById<TextView>(R.id.tvid)
        val nameItem = itemView.findViewById<TextView>(R.id.tvNameItem)
    }


    //

    fun updateList(userList: ArrayList<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.user_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        // Glide.with(context).load(user.pic).into(holder.img)

        val stringBuilder = StringBuilder()
        stringBuilder.append(user.client)//.append(" ").append(user.total_amount)

        holder.cliente.text = stringBuilder
        holder.id.text = user.id.toString()
        holder.nameItem.text = user.item

        holder.cliente.setOnClickListener {
            val user = userList[position]
            val intent = Intent(context, Detail::class.java)
            intent.putExtra("user_client", user.client)
            intent.putExtra("user_id", user.id)
            intent.putExtra("user_nameItem", user.item)
            intent.putExtra("user_orderProcess", user.order_process)
            intent.putExtra("user_payment", user.payment_name)
            intent.putExtra("user_phoneNC", user.phone_numberCli)
            intent.putExtra("user_emailC", user.emailCli)
            intent.putExtra("user_addresC", user.addressCli)
            intent.putExtra("user_nitC", user.nitCLi)
            intent.putExtra("user_surfaceI", user.surface_finish)
            intent.putExtra("user_toleranceI", user.tolerance)
            intent.putExtra("user_linearI", user.linear)
            intent.putExtra("user_angularI", user.angular)
            intent.putExtra("user_sizeI", user.size)
            intent.putExtra("user_volumeI", user.volume)
            intent.putExtra("user_quoteN", user.quote_number)
            intent.putExtra("user_subtotal", user.subtotal)
            intent.putExtra("user_freigth", user.freigth)
            intent.putExtra("user_varius", user.various_expenses)
            intent.putExtra("user_amount_whitout_vat", user.amount_whitout_vat)
            intent.putExtra("user_totalAmo", user.total_amount)
            intent.putExtra("user_deliverA", user.delivery_address)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun filterList(filteredList: ArrayList<User>) {
        this.userList = filteredList
        notifyDataSetChanged()

    }
}