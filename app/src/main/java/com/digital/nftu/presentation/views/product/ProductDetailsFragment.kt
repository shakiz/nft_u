package com.digital.nftu.presentation.views.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.digital.nftu.databinding.FragmentProductDetailsBinding
import com.digital.nftu.presentation.views.MainActivity

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObserver()
    }

    private fun initViews(){
        setupToolbar()
    }

    private fun setupToolbar(){
        (requireActivity() as MainActivity).setSupportActionBar(binding.toolbar)
    }

    private fun initObserver(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}