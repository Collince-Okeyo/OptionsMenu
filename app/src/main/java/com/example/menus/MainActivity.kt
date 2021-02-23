package com.example.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.*
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var image:ImageView
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //splashscreen
       /* val intent = Intent(this@MainActivity,SplashScreen::class.java)
        startActivity(intent)
        finish()*/

        image = findViewById(R.id.imageView)
        text = findViewById(R.id.textView2)
        //registering textview for context menu
        registerForContextMenu(text)
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
        if (item.itemId==R.id.option1){
            Toast.makeText(this,"Option1 Selected",Toast.LENGTH_SHORT).show()
        }
        else if(item.itemId==R.id.option2){
            Toast.makeText(this,"Option2 Selected",Toast.LENGTH_SHORT).show()
        }
        else if(item.itemId==R.id.option3){
            Toast.makeText(this,"Option3 Selected",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"No Option Selected",Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        val menuInflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.floating_context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}