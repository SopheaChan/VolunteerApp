package com.example.dell.valenteercontroller.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.dell.valenteercontroller.R
import com.example.dell.valenteercontroller.model.VolunteerInDataClass

class AdapterClass(val data: List<VolunteerInDataClass>) :
    RecyclerView.Adapter<AdapterClass.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*internal var product_image: ImageView
        internal var product_name: TextView
        internal var product_quantity_in_stock: TextView
        internal var product_import_date: TextView*/
        lateinit var name : TextView
        lateinit var id : TextView
        lateinit var gender : TextView
        lateinit var age : TextView
        lateinit var address : TextView

        init {
            name = itemView.findViewById(R.id.txtVolunteerName)
            id = itemView.findViewById(R.id.txtVolunteerID)
            gender = itemView.findViewById(R.id.txtVolunteerGender)
            age = itemView.findViewById(R.id.txtVolunteerAge)
            address = itemView.findViewById(R.id.txtVolunteerAddress)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val v = inflater.inflate(R.layout.member_list_rv_row, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val volunteerData:  VolunteerInDataClass= data[position]
        viewHolder.name.text = volunteerData.name
        viewHolder.id.text = volunteerData.id
        viewHolder.gender.text = volunteerData.sex
        viewHolder.age.text = volunteerData.age.toString()
        viewHolder.address.text = volunteerData.address
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /*interface eventCallBack {
        fun onImageClickListener(productUpload1: ProductUpload)
    }*/
}
