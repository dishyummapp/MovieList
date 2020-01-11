package `in`.hashcoder.movielist.views

import `in`.hashcoder.movielist.R
import `in`.hashcoder.movielist.model_classes.Character
import `in`.hashcoder.movielist.viewmodels.MainViewModel
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var id: String

    private lateinit var mainviewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        supportActionBar?.title = "Film Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        context = this@MovieDetailsActivity

        id = intent.getStringExtra("id")
        println("ID: $id")

        mainviewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainviewModel.getMovieDetails(id).observe(this, Observer {
            if (it != null) {

                titleText.text = it.title
                crawlText.text = it.openingCrawl?.replace("\n", "")?.replace("\r", "")
                directorText.text = it.director
                producerText.text = it.producer
                dateText.text = it.releaseDate



                detailsLayout.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
            else {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "Error. Cannot Connect", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
