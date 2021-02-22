package com.example.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)

        image.setOnClickListener { openGallery() }
    }

    //Gallary Intent
    fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.options_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.option1){
            Toast.makeText(this,"Option1",Toast.LENGTH_SHORT).show()
        }
        else if(item.itemId==R.id.option2){
            Toast.makeText(this,"Option2",Toast.LENGTH_SHORT).show()
        }
        else if(item.itemId==R.id.option3){
            Toast.makeText(this,"Option3",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"No Option Selected",Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }
}