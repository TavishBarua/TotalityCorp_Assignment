package com.totalitycorp.tavishbarua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.totalitycorp.tavishbarua.Model.GameDto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mGameListAdapter: GameListAdapter
    private lateinit var mGameList: MutableList<GameDto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mGameList= mutableListOf()
        rr_play.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        mGameListAdapter= GameListAdapter(this)
        rr_play.adapter=mGameListAdapter
        setDummyData()
        loadData(mGameList)


    }

    fun loadData(list:MutableList<GameDto>){
        mGameListAdapter.updateContent(list)
    }

    fun setDummyData(){
        mGameList.add(GameDto("","Candy Bust","What is Loren Ipsum? Loren Ipsum is simply dummy text of the printing and typesetting industry.",30F))
        mGameList.add(GameDto("","Candy Crush","What is Loren Ipsum? Loren Ipsum is simply dummy text of the printing and typesetting industry.",21F))
        mGameList.add(GameDto("","Candy Saga","What is Loren Ipsum? Loren Ipsum is simply dummy text of the printing and typesetting industry.",20.3F))
        mGameList.add(GameDto("","Candy Baba","What is Loren Ipsum? Loren Ipsum is simply dummy text of the printing and typesetting industry.",9.5F))
        mGameList.add(GameDto("","Candy Queue","What is Loren Ipsum? Loren Ipsum is simply dummy text of the printing and typesetting industry.",50F))

    }
}
