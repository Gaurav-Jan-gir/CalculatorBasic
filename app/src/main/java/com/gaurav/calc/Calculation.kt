package com.gaurav.calc
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.sqrt


class Calculation {
    fun singleOp(num: String,operator:Char) :String{
        when(operator){
            'a' -> {
                if(num[0] == '-')
                    return num.substring(1)
                else
                    return "-$num"
            }
            'p' -> return (num.toDouble()/100).toString()
            'i' -> return (1/num.toDouble()).toString()
            'r' -> return (sqrt(num.toDouble())).toString()
            's' -> {
                if(!num.contains('.')) return (num.toBigInteger()*num.toBigInteger()).toString()
                else return (num.toDouble()*num.toDouble()).toString()
            }
            
            else -> return ""
        }
    }

    fun operate2(num1: String, num2: String, operator: Char, optypeInt : Boolean) : String{
        if(optypeInt){
            when(operator){
                '+' -> return (num1.toBigInteger()+num2.toBigInteger()).toString()
                '-' -> return (num1.toBigInteger()-num2.toBigInteger()).toString()
                '*' -> return (num1.toBigInteger()*num2.toBigInteger()).toString()
                '/' -> {
                    if(num2.toInt() == 0) return "Invalid Operation"
                    return (num1.toBigInteger()/num2.toBigInteger()).toString()
                }
                '%' ->
                {
                    if(num2.toInt() == 0) return "Invalid Operation"
                    if(num1.toInt()%num2.toInt()<0) return ((num1.toBigInteger()%num2.toBigInteger())+num2.toBigInteger()).toString()
                    else return (num1.toBigInteger()%num2.toBigInteger()).toString()
                }
            }
        }
        else {
            when(operator){
                '+' -> return (num1.toDouble()+num2.toDouble()).toString()
                '-' -> return (num1.toDouble()-num2.toDouble()).toString()
                '*' -> return (num1.toDouble()*num2.toDouble()).toString()
                '/' -> {
                    if(num2.toDouble() == 0.0) return "Invalid Operation"
                    return (num1.toDouble()/num2.toDouble()).toString()
                }
            }
        }
        return "Invalid Operation"
    }


    fun doubleOp(num1 : String, num2 : String, operator: Char, intflag : Boolean) : String{
        when(operator){
            '/' -> return operate2(num1,num2,operator,intflag && !num2.contains('.') && num1.toBigInteger()%num2.toBigInteger()== BigInteger.ZERO)
            '*','-','+','%' -> return operate2(num1,num2,operator,intflag && !num2.contains('.'))
            '\u0000' -> return num1
        }
        return "Invalid Operation"
    }

}