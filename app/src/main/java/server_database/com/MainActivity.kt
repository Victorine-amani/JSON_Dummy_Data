package server_database.com

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var postings:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postings=findViewById(R.id.rvPosts)
        getPosts()

    }
    fun getPosts(){

        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
               if(response.isSuccessful){
                   var posts=response.body()!!
                   var postsAdapter=PostsRecyclerViewAdapter(posts)
                   postings.adapter=postsAdapter
                   postings.layoutManager= LinearLayoutManager(baseContext)
                   d("Just add","onResponse: ${response.body()!![0].userId}")
                   var poster= mutableListOf<Post>()
                   for (i in 1..100){
                       poster.add(Post(3,89,"Just add","Hello sorry for the intrusion just chilling"))
                   }
               }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
               d("Just add","onFailure")
            }

        })
    }

}