package com.abrahamgudratli.androidfundamentals6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            ToDo("Kiss your girlfriend", false),
            ToDo("Learn RecyclerView", false),
            ToDo("Wash your clothes", false),
            ToDo("Eat your meal", false),
            ToDo("Pet your  cat", false),
            ToDo("Drink water", false),
            ToDo("Charge your phone", false),
            ToDo("Complete your application", false)
        )

        val adapter = ToDoAdapter(todoList)
        rvToDoList.adapter = adapter
        rvToDoList.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            todoList.add(ToDo(etvTitle.text.toString(), false))
            adapter.notifyItemInserted(todoList.size - 1)
            etvTitle.text.clear()
        }

    }
}