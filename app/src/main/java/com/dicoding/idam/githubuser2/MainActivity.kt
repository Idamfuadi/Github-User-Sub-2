package com.dicoding.idam.githubuser2

import android.content.Intent
import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.idam.githubuser2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()
    private var users = arrayListOf<User>()
    private fun showSelectedHero(user: User) {
        Toast.makeText(this, "Kamu memilih ${user.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)

        list.addAll(getListUsers())
        showRecyclerList()
    }

    fun getListUsers() : ArrayList<User> {
        val dataPhoto = resources.getStringArray(R.array.avatar)
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataCompany = resources.getStringArray(R.array.company)

        val listUser = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                dataPhoto[position],
                dataName[position],
                dataUsername[position],
                dataCompany[position]
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                showSelectedHero(data)
                val moveIntent = Intent(this@MainActivity,DetailUserActivity::class.java)
                moveIntent.putExtra(DetailUserActivity.EXTRA_USER,users)
                startActivity(moveIntent)
            }
        })
    }
}