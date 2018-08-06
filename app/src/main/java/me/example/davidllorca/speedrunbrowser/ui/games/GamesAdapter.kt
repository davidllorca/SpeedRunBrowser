package me.example.davidllorca.speedrunbrowser.ui.games

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_game.view.*
import me.example.davidllorca.speedrunbrowser.R
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.ui.common.ImageLoader

class GamesAdapter(private var items: List<Game>,
                   private val context: Context,
                   private val listener: Listener,
                   private val imageLoader: ImageLoader) : RecyclerView.Adapter<ViewHolder>() {

    interface Listener {
        fun onClickGame(game: Game)
    }

    fun setGames(items: List<Game>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_game, parent, false))


    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        val game = items[pos]
        viewHolder.name.text = game.name
        imageLoader.loadImage(game.logo?.url, viewHolder.logo)
        viewHolder.itemView.setOnClickListener {
            listener.onClickGame(game)
        }
    }

    override fun getItemCount(): Int = items.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val name = view.tv_game_item_name
    val logo = view.iv_game_item_logo

}