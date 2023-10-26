package com.example.mvpproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvpproject.presentation.CounterView
import com.example.mvpproject.databinding.FragmentSecondBinding
import com.example.mvpproject.presentation.SecondPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter


class SecondFragment : MvpAppCompatFragment(), CounterView {

    @InjectPresenter
    lateinit var secondPresenter: SecondPresenter
    private lateinit var binding: FragmentSecondBinding
    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textSecond.text = args.CounterFirst

        binding.minusSecond.setOnClickListener {
            secondPresenter.onMinusClick()
        }

        binding.plusSecond.setOnClickListener {
            secondPresenter.onPlusClick()
        }

        binding.btnSecond.setOnClickListener {
            findNavController()
                .popBackStack()
//                .navigate(SecondFragmentDirections
//                    .actionSecondFragmentToFirstFragment(binding.counterSecond.text.toString()))
        }
    }

    override fun showCount(count: Int) {
        binding.counterSecond.text = count.toString()
    }
}