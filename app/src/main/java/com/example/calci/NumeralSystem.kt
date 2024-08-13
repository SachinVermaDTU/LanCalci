package com.example.calci

enum class NumeralSystem {
    English,
    Gujarati,
    Kannada,
    Devanagari,
    Malayalam,
    Telugu,
    Urdu
}
fun getNumeralRepresentation(number: String, system: NumeralSystem): String {
    if(number == null){
        return "";
    }
    return when (system) {
        NumeralSystem.English -> toEnglish(number)
        NumeralSystem.Gujarati -> toGujarati(number)
        NumeralSystem.Kannada -> toKannada(number)
        NumeralSystem.Devanagari -> toDevanagari(number)
        NumeralSystem.Malayalam -> toMalayalam(number)
        NumeralSystem.Telugu -> toTelugu(number)
        NumeralSystem.Urdu -> toUrdu(number)
    }
}
fun toEnglish(number:String):String{
    return number
}
fun toGujarati(number: String): String {
    val gujaratiDigits = listOf('૦', '૧', '૨', '૩', '૪', '૫', '૬', '૭', '૮', '૯')
    return number.map { if (it.isDigit()) gujaratiDigits[it - '0'] else it }.joinToString("")
}

fun toKannada(number: String): String {
    val kannadaDigits = listOf('೦', '೧', '೨', '೩', '೪', '೫', '೬', '೭', '೮', '೯')
    return number.map { if (it.isDigit()) kannadaDigits[it - '0'] else it }.joinToString("")
}

fun toDevanagari(number: String): String {
    val devanagariDigits = listOf('०', '१', '२', '३', '४', '५', '६', '७', '८', '९')
    return number.map { if (it.isDigit()) devanagariDigits[it - '0'] else it }.joinToString("")
}

fun toMalayalam(number: String): String {
    val malayalamDigits = listOf('൦', '൧', '൨', '൩', '൪', '൫', '൬', '൭', '൮', '൯')
    return number.map { if (it.isDigit()) malayalamDigits[it - '0'] else it }.joinToString("")
}

fun toTelugu(number: String): String {
    val teluguDigits = listOf('౦', '౧', '౨', '౩', '౪', '౫', '౬', '౭', '౮', '౯')
    return number.map { if (it.isDigit()) teluguDigits[it - '0'] else it }.joinToString("")
}

fun toUrdu(number: String): String {
    val urduDigits = listOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
    return number.map { if (it.isDigit()) urduDigits[it - '0'] else it }.joinToString("")
}