package com.example.recycleviewone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewone.Adapters.ContactAdapter
import com.example.recycleviewone.Class.Contact
import com.example.recycleviewone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var contactList: ArrayList<Contact>
    lateinit var contactAdapter: ContactAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadContact()

        contactAdapter = ContactAdapter(contactList, object : ContactAdapter.OnMyItemClickListener {
            override fun onMyItemClick(contact: Contact) {

                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)

            }

            override fun onMyItemDeleteClick(contact: Contact, position: Int) {

                contactList.remove(contact)
                contactAdapter.notifyItemRemoved(position)
                contactAdapter.notifyItemRangeChanged(position,contactList.size)

            }

            override fun onMyItemChangeClick(contact: Contact, position: Int) {
                contact.name = "Name change"
                contact.number = "Number change"
                contactAdapter.notifyItemChanged(position) //item ni o'zgartiradi
            }
        })

        binding.rv.adapter = contactAdapter


        binding.saveButton.setOnClickListener {

            val contact = Contact(
                binding.usernameTextId.text.toString(),
                binding.numberTextId.text.toString()
            )

            contactList.add(contact)
            //contactAdapter.notifyDataSetChanged() //Umumiy update beradi
            contactAdapter.notifyItemInserted(contactList.size) // Bitta uchun ishlaydi

        }

    }

    private fun loadContact() {

        contactList = ArrayList()


    }
}