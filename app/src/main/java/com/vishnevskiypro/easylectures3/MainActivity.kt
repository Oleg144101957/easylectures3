package com.vishnevskiypro.easylectures3

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.vishnevskiypro.easylectures3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val netImage = NetImage(URL, object : ImageCallback{
            override fun success(bitmap: Bitmap) = runOnUiThread {
                binding.imageContainer.setImageBitmap(bitmap)
            }

            override fun failed() = runOnUiThread {
                Snackbar.make(binding.imageContainer, "Failed", Snackbar.LENGTH_LONG).show()
            }
        })

        netImage.start()

    }


    companion object{
        const val URL =
            "https://www.wallpaperup.com/uploads/wallpapers/2014/10/21/489485/b807c2282ab0a491bd5c5c1051c6d312-1000.jpg"
    }
}