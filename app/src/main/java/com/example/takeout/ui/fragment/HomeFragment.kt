package com.example.takeout.ui.fragment

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.takeout.R
import com.example.takeout.contract.TakeoutMainScreenContract
import com.example.takeout.repository.TakeoutRepository
import com.example.takeout.viewmodel.TakeoutMainScreenViewModel

open class HomeFragment(val viewModel:TakeoutMainScreenViewModel?):Fragment(),TakeoutMainScreenContract.TakeoutMainScreenRouter{

//    var viewModel: TakeoutMainScreenViewModel? = null
    var searchButton: TextView? = null
    var menuButton: TextView? = null
    var learnMoreButton: TextView? = null
    var buyingPowerAmountLabel: TextView? = null
    var buyingPowerCurrencyLabel: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel?.viewDidLoad()
    }

    init {
        viewModel?.router = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity, R.layout.fragment_home,null)
        searchButton = view.findViewById<TextView>(R.id.search_button)
        menuButton = view.findViewById<TextView>(R.id.menu_button)
        learnMoreButton = view.findViewById<TextView>(R.id.learn_more_button)
        buyingPowerAmountLabel = view.findViewById<TextView>(R.id.buyingPowerAmountLabel)
        buyingPowerCurrencyLabel = view.findViewById<TextView>(R.id.buyingPowerCurrencyLabel)
        setupView()
        return view
    }

    private fun setupView() {
        searchButton?.setOnClickListener {
            viewModel?.didClickNavigationBarSearchButton()
        }
        menuButton?.setOnClickListener {
            viewModel?.didClickNavigationBarSlideMenuButton()
        }
        learnMoreButton?.setOnClickListener {
            viewModel?.didClickNavigationBarLearnMoreButton()
        }
        buyingPowerAmountLabel?.setOnClickListener{
            viewModel?.didClickBuyingPowerLearnMore()
        }
        viewModel?.run {
            gotoTakeoutSearchPage.observe(viewLifecycleOwner,{
                navigationToTakeoutSearchPage()
            })
            gotoTakeoutMenuPage.observe(viewLifecycleOwner,{
                navigationToTakeoutMenuPage()
            })
            gotoTakeoutLearnMorePage.observe(viewLifecycleOwner,{
                navigationToTakeoutLearnMorePage()
            })
            gotoBuyingPowerLearnMorePage.observe(viewLifecycleOwner,{
                navigationToBuyingPowerLearnMorePage()
            })
            buyingPowerUIModel.observe(viewLifecycleOwner,{
                buyingPowerAmountLabel?.text = it.buyingPowerAmount
                buyingPowerCurrencyLabel?.text = it.currencyCode
            })
        }
    }

    override fun navigationToTakeoutLearnMorePage() {
        println("navigationToTakeoutLearnMorePage")
    }

    override fun navigationToTakeoutSearchPage() {
        println("navigationToTakeoutSearchPage")
    }

    override fun navigationToTakeoutMenuPage() {
        println("navigationToTakeoutMenuPage")
    }

    override fun navigationToBuyingPowerLearnMorePage() {
        println("navigationToBuyingPowerLearnMorePage")
    }

}