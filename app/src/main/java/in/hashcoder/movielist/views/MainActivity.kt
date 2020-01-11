package `in`.hashcoder.movielist.views

import `in`.hashcoder.movielist.R
import `in`.hashcoder.movielist.adapters.MovieListAdapter
import `in`.hashcoder.movielist.viewmodels.MainViewModel
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var mainViewModel: MainViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        moviesRecyclerView.layoutManager = layoutManager
        moviesRecyclerView.itemAnimator = DefaultItemAnimator()

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.getMovies().observe(this, Observer {
            if (it != null) {
                val adapter = MovieListAdapter(it.results)
                moviesRecyclerView.adapter = adapter
                progressBar.visibility = View.GONE
            }
            else {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "Error. Cannot Connect", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
