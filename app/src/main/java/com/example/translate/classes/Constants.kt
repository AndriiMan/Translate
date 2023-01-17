package com.example.translate.classes

object Constants {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        //1
        var que1 = Question(
            1, "Jeden",
            "один",
            "два",
            "три",
            "чотири",
            1
        )
        questionList.add(que1)

        //2
        que1 = Question(
            2, "Dwa",
            "два",
            "шість",
            "три",
            "чотири",
            1
        )
        questionList.add(que1)

        //3
        que1 = Question(
            3, "Trzy",
            "чотири",
            "три",
            "шість",
            "сім",
            2
        )
        questionList.add(que1)

        //4
        que1 = Question(
            4, "Cztery",
            "два",
            "три",
            "сім",
            "чотири",
            4
        )
        questionList.add(que1)

        //5
        que1 = Question(
            5, "Pięć",
            "два",
            "три",
            "п'ять",
            "сім",
            3
        )
        questionList.add(que1)

        //6
        que1 = Question(
            6, "Sześć",
            "шість",
            "три",
            "п'ять",
            "сім",
            1
        )
        questionList.add(que1)

        //7
        que1 = Question(
            7, "Siedem",
            "шість",
            "три",
            "сім",
            "п'ять",
            3
        )
        questionList.add(que1)

        //8
        que1 = Question(
            8, "Ośiem",
            "вісім",
            "три",
            "сім",
            "п'ять",
            1
        )
        questionList.add(que1)

        //9
        que1 = Question(
            9, "Dziewięć",
            "п'ять",
            "дев'ять",
            "три",
            "сім",
            2
        )
        questionList.add(que1)

        return questionList
    }
}