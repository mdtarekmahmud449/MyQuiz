package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.adapter.QuizAdapter
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.model.QuizModel

class MainActivity : AppCompatActivity() {
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<QuizModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpView()
        setUpRecyclerViewAdapter()
        populateDummyData()
    }

    private fun populateDummyData() {
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
        quizList.add(QuizModel("12-10-2022","12-10-2022"))
    }

    private fun setUpRecyclerViewAdapter() {
        adapter = QuizAdapter(this, quizList)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setUpView(){
        setUpDrawerLayout()
    }
    private fun setUpDrawerLayout(){
        setSupportActionBar(binding.appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer, binding.appBar, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}