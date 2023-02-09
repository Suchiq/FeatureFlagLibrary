package com.example.demoproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demoproject.databinding.FragmentFirstBinding
import com.example.featureflaglibrary.FeatureFlagProvider

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var flag: FeatureFlagProvider
    val SHOULD_HIDE = "should_Hide"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureFlag()
        showHideButton()

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun configureFlag() {
        flag = FeatureFlagProvider()
        context?.let { flag.init(it) }
        flag.setKeyValue(SHOULD_HIDE, true)
    }

    private fun showHideButton() {
        if (flag.getValue(SHOULD_HIDE)) {
            binding.buttonFirst.visibility = View.GONE
        } else {
            binding.buttonFirst.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}