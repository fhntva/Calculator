package com.example.calculator

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.text.iterator

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityMainBinding must be not null")
    var string: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var text = binding.text

        let {
            binding.BTN1.setOnClickListener {
                var number: String = "1"
                string = string + number
                text.text = string
            }
            binding.BTN2.setOnClickListener {
                var number: String = "2"
                string = string + number
                text.text = string
            }
            binding.BTN3.setOnClickListener {
                var number: String = "3"
                string = string + number
                text.text = string
            }
            binding.BTN4.setOnClickListener {
                var number: String = "4"
                string = string + number
                text.text = string
            }
            binding.BTN5.setOnClickListener {
                var number: String = "6"
                string = string + number
                text.text = string
            }
            binding.BTN6.setOnClickListener {
                var number: String = "6"
                string = string + number
                text.text = string
            }
            binding.BTN7.setOnClickListener {
                var number: String = "7"
                string = string + number
                text.text = string
            }
            binding.BTN8.setOnClickListener {
                var number: String = "8"
                string = string + number
                text.text = string
            }
            binding.BTN9.setOnClickListener {
                var number: String = "9"
                string = string + number
                text.text = string
            }
            binding.BTNZero.setOnClickListener {
                var number: String = "0"
                string = string + number
                text.text = string
            }

            binding.BTNComa.setOnClickListener {
                var review = comaReview(string)
                if (review == false) {
                    var number: String = "."
                    string = string + number
                    text.text = string
                }
            }

            binding.BTNmunisone.setOnClickListener {
                string = string.dropLast(1)
                text.text = string
            }
            binding.BTNDell.setOnClickListener {
                string = ""
                text.text = string
            }



            binding.BTNMinus.setOnClickListener {
                var review = review(string)
                if (review == false) {
                    var number: String = "-"
                    string = string + number
                    text.text = string
                }


            }
            binding.BTNPlus.setOnClickListener {
                var review = review(string)
                if (review == false) {
                    var number: String = "+"
                    string = string + number
                    text.text = string

                }


            }
            binding.BTNMultiplication.setOnClickListener {
                var review = review(string)
                if (review == false) {
                    var number: String = "*"
                    string = string + number
                    text.text = string
                }


            }
            binding.BTNDivision.setOnClickListener {
                var review = review(string)
                if (review == false) {
                    var number: String = "/"
                    string = string + number
                    text.text = string
                }

            }
            binding.BTNSum.setOnClickListener {
                var sumReview = sumReview(string)
                if (sumReview == true) {
                    var ret = calc(string)
                    text.text = ret
                }

            }


        }
    }

}


fun calc(string: String): String {
    val list = mutableListOf<Any>()
    var digit = ""
    var runner = 0
    var lastChar = string.lastIndex.toString()
    var ret = ""

    for (character in string) {

        if (character.isDigit() || character == '.') {
            digit += character

        } else {
            list.add(digit.toFloat())
            digit = ""
            list.add(character)
        }

        if (runner.toString() == lastChar) {
            list.add(digit.toFloat())
        }
        runner++
    }

    if (list[1].toString() == "*") {
        var a: Float = list[0] as Float
        var b: Float = list[2] as Float
        ret = ((a * b).toString())
    }
    if (list[1].toString() == "/") {
        var a: Float = list[0] as Float
        var b: Float = list[2] as Float
        ret = ((a / b).toString())
    }
    if (list[1].toString() == "+") {
        var a: Float = list[0] as Float
        var b: Float = list[2] as Float
        ret = ((a + b).toString())
    }
    if (list[1].toString() == "-") {
        var a: Float = list[0] as Float
        var b: Float = list[2] as Float
        ret = ((a - b).toString())
    }
    return ret
}


fun review(string: String): Boolean {
    var charQuant = 0
    var check = false
    for (char in string) {
        if (char == '-' || char == '+' || char == '*' || char == '/') {
            charQuant++

        }

    }
    if (charQuant == 1) {

        check = true
    }
    if (charQuant >= 2) {
        check == false
    }
    return check

}

fun comaReview(string: String): Boolean {
    var charQuant = 0
    var check = false
    for (char in string) {
        if (char == '.') {
            check = true
        }
    }
    if (charQuant == 1) {

        check = true
    }
    if (charQuant >= 2) {
        check == false
    }
    return check
}

fun sumReview(string: String): Boolean {
    val list = mutableListOf<Any>()
    var digit = ""
    var runner = 0
    var lastChar = string.lastIndex.toString()
    var sumReview = false
    for (character in string) {

        if (character.isDigit() || character == '.') {
            digit += character

        } else {
            list.add(digit.toFloat())
            digit = ""
            list.add(character)
        }

        if (runner.toString() == lastChar) {
            list.add(digit.toFloat())
        }
        runner++
    }

    if (list.size.toString() == "3") {
        sumReview = true
    }
    if (list.size.toString() == "2") {
        sumReview = false
    }
    if (list.size.toString() == "1") {
        sumReview = false
    }

    return sumReview
}