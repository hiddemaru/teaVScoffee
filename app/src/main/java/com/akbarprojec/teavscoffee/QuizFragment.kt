package com.akbarprojec.teavscoffee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.akbarprojec.teavscoffee.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    val questions = arrayOf(
        "Apa yang diminum saat kerja?",
        "Apa yang kamu minum saat sengan santai?",
        "Apa yang kamu minum saat belajar?"
    )

//    var brp banyaknya score dan brp banyak klik

    var coffee_score = 0
    var tea_score = 0
    var current_q = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //        mengganti tittle fragment actionbar
        (activity as AppCompatActivity).supportActionBar?.title = "Quiz"

//        set fragment quiz
        val binding: FragmentQuizBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz, container, false
        )

//        question dari current_q ++1
        binding.questionText.text = questions[current_q]

        binding.coffeeBtn.setOnClickListener {
            coffee_score++
            nextQuiz(binding)
        }

        binding.teaBtn.setOnClickListener {
            tea_score++
            nextQuiz(binding)
        }

        return binding.root
    }

    fun nextQuiz(binding: FragmentQuizBinding) {
        current_q++


//        membatasi dengan jumlah pertanyaan
        if (current_q < questions.size) {
            binding.questionText.text = questions[current_q]
            Toast.makeText(
                context, "berhasil coffee:" + coffee_score + "/tea:" + tea_score,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            var result = ""

            if (coffee_score >= 1 && tea_score >= 1) {
                result = "Kamu Suka Kopi dan Teh"
            } else if (coffee_score <= 1) {
                result = "kamu Pecinta Teh"
            } else {
                result = "Kamu pecinta Kopi"
            }

            requireView().findNavController()
                .navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }
    }

}
