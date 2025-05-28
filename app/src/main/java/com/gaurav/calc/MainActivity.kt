package com.gaurav.calc

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun updateDisplay(str1: String, str2: String, display1: TextView, display2: TextView) {

    val str2defaultSize = 50f  // Set a base text size (adjustable)
    val str2minSize = 25f      // Prevent font from shrinking too much
    val str1defaultSize = 30f
    val str1minSize = 15f

    // Dynamically adjust text size based on length
    display1.setTextSize(TypedValue.COMPLEX_UNIT_SP,
        if (str1.length > 10) (str1defaultSize / 2).coerceAtLeast(str1minSize) else str1defaultSize)

    display2.setTextSize(TypedValue.COMPLEX_UNIT_SP,
        if (str2.length > 10) (str2defaultSize / 2).coerceAtLeast(str2minSize) else str2defaultSize)

    if(str2.isEmpty()) display2.text = "0"
    else display2.text = str2
    display1.text = str1
}

fun getAdaptiveTextSize(context: Context): Float {
    val configuration = context.resources.configuration
    val fontScale = configuration.fontScale // Get system font scale setting
    val density = context.resources.displayMetrics.density // Screen density



    return 80f-20*fontScale-10*density // Adjust the formula as needed

}




class MainActivity : AppCompatActivity() {
    private lateinit var display1 : TextView
    private lateinit var display2 : TextView
    private var num1 : String = ""
    private var num2 : String = ""
    private var operator : Char = '\u0000'
    private var flag : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnScaledSize = getAdaptiveTextSize(this) // Scale based on user settings


        val btn0 : Button = findViewById<Button>(R.id.btn0)
        btn0.textSize = btnScaledSize
        val btn1 : Button = findViewById<Button>(R.id.btn1)
        btn1.textSize = btnScaledSize
        val btn2 : Button = findViewById<Button>(R.id.btn2)
        btn2.textSize = btnScaledSize
        val btn3 : Button = findViewById<Button>(R.id.btn3)
        btn3.textSize = btnScaledSize
        val btn4 : Button = findViewById<Button>(R.id.btn4)
        btn4.textSize = btnScaledSize
        val btn5 : Button = findViewById<Button>(R.id.btn5)
        btn5.textSize = btnScaledSize
        val btn6 : Button = findViewById<Button>(R.id.btn6)
        btn6.textSize = btnScaledSize
        val btn7 : Button = findViewById<Button>(R.id.btn7)
        btn7.textSize = btnScaledSize
        val btn8 : Button = findViewById<Button>(R.id.btn8)
        btn8.textSize = btnScaledSize
        val btn9 : Button = findViewById<Button>(R.id.btn9)
        btn9.textSize = btnScaledSize
        val btnDot : Button = findViewById<Button>(R.id.btnDot)
        btnDot.textSize = btnScaledSize
        val btnEqual : Button = findViewById<Button>(R.id.btnEqual)
        btnEqual.textSize = btnScaledSize
        val btnClear : Button = findViewById<Button>(R.id.btnC)
        btnClear.textSize = btnScaledSize
        val btnClearAll : Button = findViewById<Button>(R.id.btnCE)
        btnClearAll.textSize = btnScaledSize
        val btnPercent : Button = findViewById<Button>(R.id.btnPercent)
        btnPercent.textSize = btnScaledSize
        val btnInverse : Button = findViewById<Button>(R.id.btnInv)
        btnInverse.textSize = btnScaledSize
        val btnAdd : Button = findViewById<Button>(R.id.btnAdd)
        btnAdd.textSize = btnScaledSize
        val btnSub : Button = findViewById<Button>(R.id.btnSub)
        btnSub.textSize = btnScaledSize
        val btnMul : Button = findViewById<Button>(R.id.btnMul)
        btnMul.textSize = btnScaledSize
        val btnDiv : Button = findViewById<Button>(R.id.btnDiv)
        btnDiv.textSize = btnScaledSize
        val btnBack : Button = findViewById<Button>(R.id.btnBS)
        btnBack.textSize = btnScaledSize
        val btnSqr : Button = findViewById<Button>(R.id.btnSqr)
        btnSqr.textSize = btnScaledSize
        val btnSqrt : Button = findViewById<Button>(R.id.btnSqrt)
        btnSqrt.textSize = btnScaledSize
        val btnAddInv : Button = findViewById<Button>(R.id.btnAddInv)
        btnAddInv.textSize = btnScaledSize

        val display1 : TextView = findViewById<TextView>(R.id.display1)
        val display2 : TextView = findViewById<TextView>(R.id.display2)



        fun updateDisplayFunction() {
            if(num1.length>40) num1 = num1.toDouble().toString()
            if(num2.length>40) num2 = num2.toDouble().toString()
            if(!flag) updateDisplay("",num1,display1,display2)
            else updateDisplay("$num1$operator",num2,display1,display2)
        }


        btn0.setOnClickListener{
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if(!flag && num1.isNotEmpty()){
                num1 += "0"
                updateDisplayFunction()
            }else if(flag && num2.isNotEmpty()){
                num2 += '0'
                updateDisplayFunction()
            }
        }
        btn1.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "1"; else num2 += '1'
            updateDisplayFunction()
        }
        btn2.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "2"; else num2 += '2'
            updateDisplayFunction()
        }
        btn3.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "3"; else num2 += '3'
            updateDisplayFunction()
        }
        btn4.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "4"; else num2 += '4'
            updateDisplayFunction()
        }
        btn5.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "5"; else num2 += '5'
            updateDisplayFunction()
        }
        btn6.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "6"; else num2 += '6'
            updateDisplayFunction()
        }
        btn7.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "7"; else num2 += '7'
            updateDisplayFunction()
        }
        btn8.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "8"; else num2 += '8'
            updateDisplayFunction()
        }
        btn9.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            if (!flag) num1 += "9"
            else num2 += '9'
            updateDisplayFunction()
        }
        btnDot.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(!flag && !num1.contains('.')){
                if(num1.isEmpty()) num1 += "0."
                else num1 += '.'

            }else if(flag && !num2.contains('.')){
                if(num2.isEmpty()) num2 += "0."
                else num2 += '.'
            }
            updateDisplayFunction()
        }

        btnClear.setOnClickListener {
            if(!flag){
                num1 = ""
            }else{
                num2 = ""
            }
            updateDisplayFunction()
        }
        btnClearAll.setOnClickListener {
            num1 = ""
            num2 = ""
            operator = '\u0000'
            updateDisplayFunction()
            flag = false
        }
        btnBack.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(!flag && num1.isNotEmpty()) num1 = num1.substring(0,num1.length-1)
            else if(flag && num2.isNotEmpty()) num2 = num2.substring(0,num2.length-1)
            updateDisplayFunction()
        }
        btnAdd.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if (num1.isNotEmpty() && !flag) {
                operator = '+'
                flag = true
            }
            else if (num2.isNotEmpty() && flag) {
                num1 = Calculation().doubleOp(num1, num2, operator, !num1.contains('.'))
                operator = '+'
                num2 = ""
            }
            else if(num2.isEmpty() && flag) {
                operator = '+'
            }
            updateDisplayFunction()
        }
        btnSub.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if (num1.isNotEmpty() && !flag) {
                operator = '-'
                flag = true
            }
            else if (num2.isNotEmpty() && flag) {
                num1 = Calculation().doubleOp(num1, num2, operator, !num1.contains('.'))
                operator = '-'
                num2 = ""
            }
            else if(num2.isEmpty() && flag) {
                operator = '-'
            }
            updateDisplayFunction()
        }
        btnMul.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(num1.isNotEmpty() && !flag){
                operator = '*'
                flag = true
            }else if(num2.isNotEmpty() && flag){
                num1 = Calculation().doubleOp(num1,num2,operator,!num1.contains('.'))
                operator = '*'
                num2 = ""
            }
            else if(num2.isEmpty() && flag) {
                if(num1[num1.length -1] == '%') num1 = (num1.substring(0,num1.length-1).toDouble()/100).toString()
                operator = '*'
            }
            updateDisplayFunction()
        }
        btnDiv.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(num1.isNotEmpty() && !flag){
                operator = '/'
                flag = true
            }else if(num2.isNotEmpty() && flag){
                num1 = Calculation().doubleOp(num1,num2,operator,!num1.contains('.'))
                operator = '/'
                num2 = ""
            }
            else if(num2.isEmpty() && flag) {
                if(num1[num1.length -1] == '%') num1 = (num1.substring(0,num1.length-1).toDouble()/100).toString()
                operator = '/'
            }
            updateDisplayFunction()
        }
        btnEqual.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(num1.isNotEmpty() && num2.isNotEmpty() && operator != '\u0000'){
                num1 = Calculation().doubleOp(num1,num2,operator,!num1.contains('.'))
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            else if(num1.isNotEmpty() && num2.isEmpty()){
                num1 = Calculation().doubleOp(num1,"0",operator,!num1.contains('.'))
                operator = '\u0000'
                flag = false
                num2 = ""
            }
            updateDisplayFunction()
        }
        btnSqr.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                num2 = ""
                operator = '\u0000'
                flag = false
            }
            else if(num1.isNotEmpty() && !flag){
                num1 = Calculation().singleOp(num1,'s')
            }
            else if(num2.isNotEmpty() && flag){
                num2 = Calculation().singleOp(num2,'s')
            }

            updateDisplayFunction()
        }
        btnSqrt.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                num2 = ""
                operator = '\u0000'
                flag = false
            }
            else if(num1.isNotEmpty() && !flag){
                num1 = Calculation().singleOp(num1,'r')
            }
            else if(num2.isNotEmpty() && flag){
                num2 = Calculation().singleOp(num2,'r')
            }
            updateDisplayFunction()
        }
        btnInverse.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                num2 = ""
                operator = '\u0000'
                flag = false
            }
            else if(num1.isNotEmpty() && !flag){
                num1 = Calculation().singleOp(num1,'i')
            }
            else if(num2.isNotEmpty() && flag){
                num2 = Calculation().singleOp(num2,'i')
            }
            updateDisplayFunction()
        }
        btnAddInv.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                num2 = ""
                operator = '\u0000'
                flag = false
            }
            else if(num1.isNotEmpty() && !flag){
                num1 = Calculation().singleOp(num1,'a')
            }
            else if(num2.isNotEmpty() && flag){
                num2 = Calculation().singleOp(num2,'a')
            }
            updateDisplayFunction()
        }
        btnPercent.setOnClickListener {
            if(num1 == "Invalid Operation" || num1 == "Infinity"){
                num1 = ""
                num2 = ""
                operator = '\u0000'
                flag = false
            }
            else if(num1.isNotEmpty() && !flag){
                if(num1.contains('.'))
                    num1 = Calculation().singleOp(num1,'p')
                else{
                    operator = '%'
                    flag = true
                }
            }
            else if(num2.isNotEmpty() && flag){
                if(num2.contains('.')){
                    num2 = Calculation().singleOp(num2,'p')
                }else{
                    num1 = Calculation().doubleOp(num1,num2,operator,!num1.contains('.'))
                    operator = '%'
                    num2 = ""
                }
            }
            else if(num2.isEmpty() && flag) {
                operator = '%'
            }
            updateDisplayFunction()

        }





    }
}