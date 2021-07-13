package server_database.com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsRecyclerViewAdapter(var postList: List<Post>):RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.posts_list_item,parent,false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var currentPosts=postList[position]
        holder.user.text= currentPosts.userId.toString()
        holder.ID.text=currentPosts.id.toString()
        holder.head.text=currentPosts.title
        holder.anatomy.text=currentPosts.body
    }

    override fun getItemCount(): Int {
       return postList.size
    }
}

class PostsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var user=itemView.findViewById<TextView>(R.id.tvUserId)
    var ID=itemView.findViewById<TextView>(R.id.tvId)
    var head=itemView.findViewById<TextView>(R.id.tvTitle)
    var anatomy=itemView.findViewById<TextView>(R.id.tvBody)
}