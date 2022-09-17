package array

fun main() {
    val arr = arrayOf("test1a", "test2", "test1b", "test3a")
    val arr2 = arrayOf("Wrong answer", "OK", "Runtime error", "OK")
    println(solution(arr, arr2))
}

fun solution(T: Array<String>, R: Array<String>): Int {
    // write your code in Kotlin 1.3.11 (Linux)

    val testCaseNumbers = mutableListOf<String>()
    val regex = Regex("[0-9]")

    T.forEach { testCase ->
        val groupnumber = testCase.filter { regex.matches(it.toString()) }
        testCaseNumbers.add(groupnumber)
    }

   // println(testCaseNumbers.toTypedArray().contentToString())

    val totalNumberOfGroups = testCaseNumbers.distinct().size
    var numberPassed = 0
    val groups = testCaseNumbers.distinct()
    val mapOfTestCaseGroupAndCorrect = mutableMapOf<String, Int>()
    val mapOfNumberOfEachGroup = mutableMapOf<String,Int>()





    groups.forEach { group ->
        mapOfTestCaseGroupAndCorrect[group] = 0
        mapOfNumberOfEachGroup[group] = 0
        testCaseNumbers.forEach { nums ->
            if (mapOfNumberOfEachGroup[group] != null && nums == group){
                mapOfNumberOfEachGroup[group] = mapOfNumberOfEachGroup[group]!! + 1
            }

        }
    }


    T.forEachIndexed { index, testCase ->
        val answer = R.get(index)
        if (answer == "OK") {
            val getGroup = testCase.filter { regex.matches(it.toString()) }
            val numberPassed = mapOfTestCaseGroupAndCorrect[getGroup]!! + 1
            mapOfTestCaseGroupAndCorrect[getGroup] = numberPassed
        }
    }

    mapOfTestCaseGroupAndCorrect.forEach { group, number ->
        if (mapOfNumberOfEachGroup[group]!! == number){
            numberPassed++
        }
    }

    val Score = (numberPassed * 100) / totalNumberOfGroups


    return Score
}
