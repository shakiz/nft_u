package com.digital.nftu.presentation.views.home

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digital.nftu.R
import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.databinding.FragmentHomeBinding
import com.digital.nftu.presentation.adapter.CategoryAdapter
import com.digital.nftu.presentation.adapter.NFTProductAdapter
import com.digital.nftu.presentation.adapter.TopNFTProductAdapter
import com.digital.nftu.presentation.views.MainActivity
import com.digital.nftu.utils.SpaceItemDecoration

class HomeFragment : Fragment(), NFTProductAdapter.OnNftItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private var categoryAdapter = CategoryAdapter()
    private var nftAdapter = NFTProductAdapter()
    private var topNftAdapter = TopNFTProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObserver()
        viewModel.fetchCategoryItems()
        viewModel.fetchNftItems()
        viewModel.fetchTopNftItems()
    }

    private fun initViews(){
        setupToolbar()
        prepareToolbarMenus()
        setUpCategoryRecyclerView()
        setUpNFTRecyclerView()
        setUpPopularNftProductRecyclerView()
    }

    private fun setupToolbar(){
        (requireActivity() as MainActivity).setSupportActionBar(binding.toolbar)
    }

    private fun prepareToolbarMenus() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                super.onPrepareMenu(menu)
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.home_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId){
                    R.id.navigation_notifications -> {
                        true
                    }
                    R.id.navigation_wallet -> {
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initObserver(){
        viewModel.onCategoryItemsUpdated().observe(viewLifecycleOwner){
            categories -> categoryAdapter.setCategoryItems(categories)
        }

        viewModel.onNftItemsUpdated().observe(viewLifecycleOwner){
                nftItems -> nftAdapter.setNFTItems(nftItems)
        }

        viewModel.onTopNftProductsUpdated().observe(viewLifecycleOwner){
                nftItems -> topNftAdapter.setNFTItems(nftItems)
        }
    }

    private fun setUpCategoryRecyclerView(){
        binding.rvCategory.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvCategory.addItemDecoration(SpaceItemDecoration(32, false))
        binding.rvCategory.adapter = categoryAdapter
    }

    private fun setUpNFTRecyclerView(){
        binding.rvNftProduct.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvNftProduct.addItemDecoration(SpaceItemDecoration(32, false))
        binding.rvNftProduct.adapter = nftAdapter
        nftAdapter.setOnItemClicked(this)
    }

    private fun setUpPopularNftProductRecyclerView(){
        binding.rvAllNftProduct.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvAllNftProduct.addItemDecoration(SpaceItemDecoration(32, false))
        binding.rvAllNftProduct.adapter = topNftAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(nftItem: NFTItem) {
        findNavController().navigate(R.id.navigation_product_details)
    }
}