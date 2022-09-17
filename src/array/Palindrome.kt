package array

fun main(){
    
}

fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    val regex = Regex("[a-z0-9]")
    val validAlphanumeric = s.filter { it.toString().isNotBlank() }.toLowerCase().filter { regex.matches(it.toString()) }

    val inReverse = validAlphanumeric.reversed()
    return inReverse.equals(validAlphanumeric)
}

