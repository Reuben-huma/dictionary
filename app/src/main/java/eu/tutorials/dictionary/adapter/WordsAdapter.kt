package eu.tutorials.dictionary.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.dictionary.R
import eu.tutorials.dictionary.WordsFragment

class WordsAdapter(context: Context, letter: String) : RecyclerView.Adapter<WordsViewHolder>() {
    private val filteredWords: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words
            .filter { it.startsWith(letter[0], ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return WordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.button.text = filteredWords[position]

        holder.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${WordsFragment.SEARCH_PREFIX}${filteredWords[position]}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount() = filteredWords.size
}

class WordsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val button: Button = view.findViewById(R.id.button)
}