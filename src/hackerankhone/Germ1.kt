package hackerankhone

fun main(){
    println(funWithAnagrams(arrayOf("code","doce","ecod","framer","framre")).contentToString())
}


fun funWithAnagrams(text: Array<String>): Array<String> {


    // Write your code here
    val sortedText = text.sortedArray()
    val final = mutableListOf<String>()
    val finalF = mutableMapOf<String,String>()
    text.forEach { text ->
        final.add(text.toSortedSet().toString())
    }

    val disFinal =  final.distinct()
    var currentIndex = 0
    text.forEach {txt ->
        val ff = txt.toSortedSet().toString()
        if (disFinal.contains(ff) && finalF[ff] == null){
            finalF[ff] = text[currentIndex]
        }
        currentIndex++
    }

    return finalF.values.toTypedArray()

}