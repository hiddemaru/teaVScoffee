package com.akbarprojec.teavscoffee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.akbarprojec.teavscoffee.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //        mengganti tittle fragment actionbar
        (activity as AppCompatActivity).supportActionBar?.title = "Selesai!!"

//        set fragment finish
        val binding: FragmentFinishBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false)

//        get data dari args result ke epaintext
        val args = FinishFragmentArgs.fromBundle(requireArguments())
        binding.expaintText.text = args.result

//        klik btntry untuk kembali ke introFragment
        binding.btnTry.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_finishFragment_to_introFragment)
        )

        return binding.root
    }


}
