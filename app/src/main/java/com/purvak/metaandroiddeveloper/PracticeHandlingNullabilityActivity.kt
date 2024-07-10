package com.purvak.metaandroiddeveloper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticeHandlingNullabilityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practice_handling_nullability)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    //    step 4
        println("Please, Enter the student's ID")
//        val id = readln().toInt()
        val id :Int = 781
        println( getStudentById(id))
        println("Please, Enter the student's name")
//        val name= readln()
        val name:String = "Adam"
        println(searchInStudents(name)?:"the student is not found")

        
    }

    data class Student(val fullName: String, var id: Int,var grade:Double)

    val students = listOf<Student>(
        Student("John", 223,140.0),
        Student("Mark", 548,120.0),
        Student("Natali", 342,150.0),
        Student("Sara", 781,130.0)
    )

    //step 2
    fun getStudentById(id:Int):Student{
        return  students.find { it.id==id }!!
    }
    //step 3
    fun searchInStudents(name:String):Student?{
        return students.find { it.fullName.lowercase()==name.lowercase()}
    }
}