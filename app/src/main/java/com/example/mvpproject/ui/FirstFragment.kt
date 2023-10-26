package com.example.mvpproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvpproject.presentation.CounterView
import com.example.mvpproject.databinding.FragmentFirstBinding
import com.example.mvpproject.presentation.FirstPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter


class FirstFragment : MvpAppCompatFragment(), CounterView {

    @InjectPresenter
    lateinit var firstPresenter: FirstPresenter
    private lateinit var binding: FragmentFirstBinding
    private val args by navArgs<FirstFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textFirst.text = args.CounterSecond

        binding.minusFirst.setOnClickListener {
            firstPresenter.onMinusClick()
        }

        binding.plusFirst.setOnClickListener {
            firstPresenter.onPlusClick()
        }

        binding.btnFirst.setOnClickListener {
            findNavController()
                .navigate(
                    FirstFragmentDirections
                        .actionFirstFragmentToSecondFragment(binding.counterFirst.text.toString())
                )
        }
    }

    override fun showCount(count: Int) {
        binding.counterFirst.text = count.toString()
    }
}