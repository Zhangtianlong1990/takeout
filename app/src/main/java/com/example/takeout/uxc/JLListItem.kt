package com.example.takeout.uxc

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.takeout.R
import com.example.takeout.base.JLBaseUIView
import com.example.takeout.utils.SingleLiveEvent

interface JLListItemViewModelInputs{
    fun viewDidLoad()
    fun viewDeinit()
    fun handleImageClick()
    fun updateRowData(title:String,detail: String)
    fun updateButtonVisibility(visible:Boolean)
    fun updateModuleVisibility(visible:Boolean)
}

interface JLListItemViewModelOutputs{
    var viewDidLoad: SingleLiveEvent<Any?>
    var viewDeinit: SingleLiveEvent<Any?>
    var title: LiveData<String>
    var subTitle: LiveData<String>
    var buttonVisibility: LiveData<Boolean>
    var moduleVisibility: LiveData<Boolean>
    var didClickImage: SingleLiveEvent<Any?>
}

class JLListItemViewModel: JLListItemViewModelInputs,JLListItemViewModelOutputs{

    private val _viewDidLoad: SingleLiveEvent<Any?> = SingleLiveEvent()
    override var viewDidLoad: SingleLiveEvent<Any?> = _viewDidLoad

    private val _viewDeinit: SingleLiveEvent<Any?> = SingleLiveEvent()
    override var viewDeinit: SingleLiveEvent<Any?> = _viewDeinit

    private val _title:MutableLiveData<String> = MutableLiveData()
    override var title: LiveData<String> = _title

    private val _subTitle: MutableLiveData<String> = MutableLiveData()
    override var subTitle: LiveData<String> = _subTitle

    private val _buttonVisibility: MutableLiveData<Boolean> = MutableLiveData()
    override var buttonVisibility: LiveData<Boolean> = _buttonVisibility

    private val _moduleVisibility: MutableLiveData<Boolean> = MutableLiveData()
    override var moduleVisibility: LiveData<Boolean> = _moduleVisibility

    private val _didClickImage: SingleLiveEvent<Any?> = SingleLiveEvent()
    override var didClickImage: SingleLiveEvent<Any?> = _didClickImage

    override fun viewDidLoad() {
        _viewDidLoad.call()
    }

    override fun viewDeinit() {
        _viewDeinit.call()
    }

    override fun handleImageClick() {
        _didClickImage.call()
    }

    override fun updateRowData(title: String, detail: String) {
        if (_title.value==title && _subTitle.value==detail){
            return
        }
        _title.value = title
        _subTitle.value = detail
    }

    override fun updateButtonVisibility(visible: Boolean) {
        if (_buttonVisibility.value == visible){
            return
        }
        _buttonVisibility.value = visible
    }

    override fun updateModuleVisibility(visible: Boolean) {
        if (_moduleVisibility.value == visible){
            return
        }
        _moduleVisibility.value = visible
    }

}

abstract class JLListItem @JvmOverloads  constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    JLBaseUIView(context, attrs, defStyleAttr) {

    lateinit var viewModel: JLListItemViewModel

    override fun getLayoutId(): Int {
        return R.layout.jl_row_menu
    }

    override fun initializeVariables() {
        /* empty implementation */
    }

    override fun setupViews() {
        val image_right_arrow =  findViewById<ImageView>(R.id.image_right_arrow)
        image_right_arrow.setOnClickListener {
            viewModel.handleImageClick()
        }
    }

    override fun initViewModel() {
        viewModel = JLListItemViewModel()
    }

    override fun bindViewModel() {
        viewModel.title.observe(this@JLListItem,{
            val text_one = findViewById<TextView>(R.id.text_one)
            text_one.text = it
        })

        viewModel.subTitle.observe(this@JLListItem,{
            val text_two = findViewById<TextView>(R.id.text_two)
            text_two.text = it
        })

        viewModel.buttonVisibility.observe(this@JLListItem,{
            val image_right_arrow =  findViewById<ImageView>(R.id.image_right_arrow)
            if (it){
                image_right_arrow.visibility = View.VISIBLE
            }else{
                image_right_arrow.visibility = View.GONE
            }
        })
        viewModel.moduleVisibility.observe(this@JLListItem,{
            val super_layout =  findViewById<LinearLayout>(R.id.super_layout)
            if (it){
                super_layout.visibility = View.VISIBLE
            }else{
                super_layout.visibility = View.GONE
            }
        })
    }

    override fun setupTrackDatas() {
        /* empty implementation */
    }

    override fun setupAccessibilitys() {
        /* empty implementation */
    }

    override fun viewDidLoad() {
        viewModel.viewDidLoad()
    }

    override fun viewDeinit() {
        viewModel.viewDeinit()
    }

}