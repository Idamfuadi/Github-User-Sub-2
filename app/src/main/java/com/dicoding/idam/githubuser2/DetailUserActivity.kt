package com.dicoding.idam.githubuser2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.idam.githubuser2.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        actionbar!!.title = "User Information"
        actionbar.setDisplayHomeAsUpEnabled(true)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailUser = intent.getParcelableExtra<User>(EXTRA_USER) as User
//        binding.imgPhoto.setImageResource(detailUser.photo)
        binding.tvDetailName.text = detailUser.name
//        binding.tvDetailUsername.text = detailUser.username
//        binding.tvDetailCompany.text = detailUser.company
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}