
fun main() {
//higher order fonksiyon parametre olarak fonksiyon gelmiş
    yazdir(10,12,::topla)
// higher order fonksiyon parametre olarak değişken gelmiş ama içinde fonksiyon tutuyor lambda gösterim olarak.
    yazdir(20,12,modAl)
//normal fonksiyon
    calculateAndPrint(10,5,'*')

// Higher Order Fonksiyon
    calculateAndPrintHof(10,5,{numberOne, numberTwo -> numberOne + numberTwo })
    calculateAndPrintHof(10,5,{numberOne, numberTwo -> numberOne - numberTwo })
    calculateAndPrintHof(10,5,{numberOne, numberTwo -> numberOne * numberTwo })
    calculateAndPrintHof(10,5,{numberOne, numberTwo -> numberOne / numberTwo })
// böyle de lambda gösterimi yapılabilir
    calculateAndPrintHof(10,5){numberOne, numberTwo -> numberOne % numberTwo}


// Higher Order fonksiyon default değer içeriyor numberOne = 3 ve numberTwo =10 default değer verildi ve
// operation fonksiyonuna  numberOne + numberTwo default değeri verildi.

    calculateAndPrintHof2()

// Higher Order fonksiyon default değer içeriyor numberOne = 3 ve numberTwo =10 default değer kullanılmadı ama
// operation fonksiyonuna  verilen  numberOne + numberTwo default değeri kullanıldı.

    calculateAndPrintHof2(12,65) // default değer çalıştı yani numberOne + numberTwo

// Higher Order Fonksiyon Default değeri vardı fonksiyonun ama kullanılmadı onun yerine operation a topla fonksiyonu verildi.
    calculateAndPrintHof2(10,5,::topla)
}

//değişken tanımladım ama içinde lambda gösterim olarak fonksiyon tutuyor.
val modAl = {x: Int,y: Int -> x%y }

//normal fonksiyon
fun topla (a: Int, b: Int): Int {
    return a+b
}


//higher order fonksiyon
fun yazdir(x: Int, y: Int, operation: (Int,Int) -> Int){
    val sonuc = operation(x,y)
    println(sonuc)

}
// normal fonksiyon
fun calculateAndPrint(x: Int,y:Int,operation: Char){
  val sonuc =  when(operation){
        '+' -> x+y
        '-' -> x-y
        '*' -> x*y
        '/' -> x/y
       else -> x+y
    }
    println(sonuc)
}
//higher order fonksiyon
fun calculateAndPrintHof(numberOne: Int,numberTwo: Int, operation:(numberOne: Int, numberTwo: Int)->Int){

val sonuc = operation(numberOne,numberTwo)
    println("Sonuc: $sonuc")

    }
// Hof fonksiyona default değer vermek
 fun calculateAndPrintHof2(numberOne: Int = 3,numberTwo: Int = 10,operation: ((Int,Int) -> Int) = {numberOne: Int,NumberTwo: Int -> numberOne + numberTwo}) :Int {
     val sonuc = operation(numberOne, numberTwo)
    println(sonuc)
     return sonuc
 }
//Hof = Higher Order Function
// Higher Order Functions bir fonksiyon başka bir fonksiyonu içinde kullanıyor ise bu
// higher order function dır diyemeyiz. Bunun High Order Function olması için
//bir fonksiyonun başka bir fonksiyonu parametre ya da geri dönüş tipi olarak alıyor olması gerekir.
// ilk örnekteki :: nın anlamı bu fonksiyonun body sini yani {} içini istiyorum demek