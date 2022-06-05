package com.example.recycleviewone.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewone.Class.Contact
import com.example.recycleviewone.R

class ContactAdapter(
    var contactList: List<Contact>,
    var onMyItemClickListener: OnMyItemClickListener
) :
    RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(contact: Contact,position: Int) {

            itemView.findViewById<TextView>(R.id.nameId).text = contact.name
            itemView.findViewById<TextView>(R.id.numberId).text = contact.number

            itemView.setOnClickListener {

                onMyItemClickListener.onMyItemClick(contact)

            }

            itemView.findViewById<Button>(R.id.editButton).setOnClickListener {

                onMyItemClickListener.onMyItemChangeClick(contact,position)

            }

            itemView.findViewById<Button>(R.id.deleteButton).setOnClickListener {

                onMyItemClickListener.onMyItemDeleteClick(contact, position)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val contact = contactList[position]
        holder.onBind(contact,position)

    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    interface OnMyItemClickListener {
        fun onMyItemClick(contact: Contact)
        fun onMyItemDeleteClick(contact: Contact,position: Int)
        fun onMyItemChangeClick(contact: Contact,position: Int)
    }

}