package com.totalitycorp.tavishbarua

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.totalitycorp.tavishbarua.Model.GameDto
import kotlinx.android.synthetic.main.placeholder_play_item.view.*


class GameListAdapter(context: Context) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {


    private val mContext = context
    private var mGame: MutableList<GameDto>? = null
    //  private var mApp: Common? = Common.getInstance() as Common //activity?.applicationContext!! as Common
    // private var mSongDtos: ArrayList<SongDto>? = songDtos


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.placeholder_play_item, parent, false)
        return GameViewHolder(view)
    }


    override fun getItemCount(): Int {
        return try {
            mGame?.size!!
        } catch (ex: NullPointerException) {
            0
        }
    }

    fun updateContent(content: MutableList<GameDto>) {
        mGame = content
        notifyDataSetChanged()

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.itemView.tv_game_name.text = mGame?.get(position)?.name
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, GameActivity::class.java)
            val pair = androidx.core.util.Pair<View, String>(
                holder.itemView.img_list_game,
                holder.itemView.img_list_game.transitionName
            )
            val pair1 = androidx.core.util.Pair<View, String>(
                holder.itemView.btn_download,
                holder.itemView.btn_download.transitionName
            )

            val options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(mContext as Activity, pair, pair1)
            intent.putExtra("data", mGame?.get(position))
            mContext.startActivity(intent, options.toBundle())
        }

    }


    inner class GameViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {



        /*  val txt_song_name:AppCompatTextView = itemView?.findViewById(R.id.txt_song_name)!!
          val txt_song_album:AppCompatTextView = itemView?.findViewById(R.id.txt_song_album)!!*/


    }

}
