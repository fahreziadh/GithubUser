package dicoding.submission.androidfundamental1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.submission.androidfundamental1.ItemAdapter
import dicoding.submission.androidfundamental1.ItemModel
import dicoding.submission.androidfundamental1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var UserGithubList = ArrayList<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        val layoutManager = LinearLayoutManager(this)
        layoutManager.isSmoothScrollbarEnabled = true
        github_user_list.layoutManager = layoutManager
        github_user_list.adapter =
            ItemAdapter(UserGithubList)
        getData()
    }

    fun getData() {
        for (i in 0..9) {
            val names = resources.getStringArray(R.array.name)
            val username = resources.getStringArray(R.array.username)
            val location = resources.getStringArray(R.array.location)
            val follower = resources.getIntArray(R.array.followers)
            val following = resources.getIntArray(R.array.following)
            val avatar = resources.getStringArray(R.array.avatar)
            val company = resources.getStringArray(R.array.company)
            val repository = resources.getIntArray(R.array.repository)
            val item = ItemModel(
                names[i],
                username[i],
                avatar[i],
                company[i],
                location[i],
                repository[i],
                follower[i],
                following[i]
            )
            UserGithubList.add(item)
            github_user_list.adapter?.notifyDataSetChanged()
        }
    }
}