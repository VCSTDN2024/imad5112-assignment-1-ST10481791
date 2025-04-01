package vcmsa.ci.mealapp

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.mealcreator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Time Of Day
        val timeList = listOf("Morning", "Mid-Morning", "Afternoon", "Mid-Afternoon", "Dinner")

        // Meals
        val meals = mapOf(
            "Morning" to listOf("Pancakes", "Omelette", "Toast & Jam", "Smoothie", "Cereal"),
            "Mid-Morning" to listOf("Granola Bar", "Yogurt", "Fruit Salad", "Boiled Eggs", "Tea & Biscuits"),
            "Afternoon" to listOf("Sandwich", "Burger", "Salad", "Pasta", "Soup"),
            "Mid-Afternoon" to listOf("Cookies", "Chips & Dip", "Fruit", "Muffin", "Energy Bar"),
            "Dinner" to listOf("Steak & Pap", "Grilled Chicken", "Vegetable Stir-Fry", "Rice & Beans", "Fish & Chips")
        )


        //Declaring variables
        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)
        val btnGenerate: Button = findViewById(R.id.btnGenerate)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnExit: Button = findViewById(R.id.btnExit)
        val txtMeal: TextView = findViewById(R.id.editTextText2)

        // The dropdown code
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, timeList)
        autoComplete.setAdapter(adapter)

        // Generate button
        btnGenerate.setOnClickListener {
            val selectedTime = autoComplete.text.toString()
            if (meals.containsKey(selectedTime)) {
                val randomMeal = meals[selectedTime]?.random()
                txtMeal.text = " $randomMeal"
            } else {
                Toast.makeText(this, "Please select a valid time", Toast.LENGTH_SHORT).show()
            }
            // Clear button
            btnClear.setOnClickListener {
                txtMeal.text = ""
            }

            // Exit button
            btnExit.setOnClickListener {
                finish()
            }
        }
    }
}