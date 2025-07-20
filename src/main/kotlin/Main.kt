// File: Main.kt
fun main() {
    val studentNames: List<String> = listOf("Ahmed", "Sara", "Omar", "Laila", "Nour")
    val mutableScores: MutableMap<String, Int> = mutableMapOf(
        "Ahmed" to 85,
        "Sara"  to 92,
        "Omar"  to 58,
        "Laila" to 72,
        "Nour"  to 95
    )
    val graduatedStudents: Set<String> = setOf("Omar", "Laila")
    println("Initial data:")
    println("Names: $studentNames")
    println("Scores: $mutableScores")
    println("Graduated: $graduatedStudents")
    println()

    println("Active students and their scores:")
    studentNames.forEach { name ->
        if (name in graduatedStudents) return@forEach
        val score = mutableScores[name] ?: "N/A"
        println(" - $name : $score")
    }
    println()

    println("Students with score > 80:")
    studentNames
        .filter { (mutableScores[it] ?: 0) > 80 }
        .map(String::uppercase)
        .forEach { println(" * $it") }
    println()

    val totalScore = mutableScores.values.reduce { acc, s -> acc + s }
    println("Total of all scores: $totalScore")

    val formatted = mutableScores.entries
        .fold("") { acc, (name, score) ->
            if (acc.isEmpty()) "$name: $score"
            else "$acc | $name: $score"
        }
    println("Formatted string: $formatted")
    println()

    println("Pass report:")
    generateReport(mutableScores)
}
fun generateReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No students to report.")
        return
    }
    scores
        .filter { it.value >= 60 }
        .map { (name, score) -> "$name: ${when (score) {
            in 90..100 -> "A"
            in 80..89  -> "B"
            in 70..79  -> "C"
            in 60..69  -> "D"
            else       -> "F"
        }}" }
        .forEach { println(it) }
}