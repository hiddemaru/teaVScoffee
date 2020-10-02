package com.akbarprojec.teavscoffee


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.akbarprojec.teavscoffee.databinding.FragmentIntroBinding
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        mengganti tittle fragment actionbar
        (activity as AppCompatActivity).supportActionBar?.title = "Game Teh VS Coffee"

//        set intro fragment
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false
        )

//        berpindah fragment saat di klik
        binding.stratBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_introFragment_to_quizFragment)
        )

//        untuk menu about
        setHasOptionsMenu(true)

        return binding.root
    }

//    metode saat membuat menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
//    memangil overflow_menu
    inflater?.inflate(R.menu.overflow_menu,menu)

    }

 //    overed sethasOptionMenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
//        atau jika tidak di temukan panggil super nya
                || super.onOptionsItemSelected(item)
    }
}
