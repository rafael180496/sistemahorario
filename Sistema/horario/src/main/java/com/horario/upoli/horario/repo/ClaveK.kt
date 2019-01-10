
package com.horario.upoli.horario.repo

/*ejemplo*/
/*PasswordGenerator.getPassword(
    PasswordGenerator.MINUSCULAS+
    PasswordGenerator.MAYUSCULAS+
    PasswordGenerator.ESPECIALES,10);*/
class ClaveK{
    companion object {
        val  NUMEROS:String = "0123456789"
        val MAYUSCULAS:String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val MINUSCULAS:String = "abcdefghijklmnopqrstuvwxyz"
        val ESPECIALES:String = "ñÑ"
        fun getPinNumber()= getClave("$NUMEROS", 4)
        fun getClave()= getClave(8)
        fun getClave(len:Int)= getClave("$NUMEROS$MAYUSCULAS$MINUSCULAS", len)
        fun getClave(serial:String,len:Int):String{
            var pswd:String=""
            for(i:Int in 0..len){
                pswd+= serial.get((Math.random()*serial.length).toInt())
            }
            return  pswd
        }
    }

}