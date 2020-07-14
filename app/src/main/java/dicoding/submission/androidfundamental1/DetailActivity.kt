package dicoding.submission.androidfundamental1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = getIntent().getParcelableExtra<ItemModel>("item")

        name.text = data?.name
        name_detail.text = data?.name
        username.text = data?.username
        username_detail.text = data?.username
        following.text = "${data?.following} Following"
        follower.text = "${data?.follower} Follower"
        repository.text = "${data?.repository} Repository"
        company_detail.text = "${data?.company}"
        location_detail.text = "${data?.location}"
        val imageSource= ContextCompat.getDrawable(this,resources.getIdentifier(data?.avatar,"drawable",packageName))
        avatar.setImageDrawable(imageSource)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}