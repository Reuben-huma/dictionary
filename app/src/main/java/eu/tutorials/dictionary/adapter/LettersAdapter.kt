package eu.tutorials.dictionary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.dictionary.R

class LettersAdapter : RecyclerView.Adapter<LettersViewHolder>() {

    private val dataSet = ('A').rangeTo('Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LettersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return LettersViewHolder(view)
    }

    override fun onBindViewHolder(holder: LettersViewHolder, position: Int) {
        holder.button.text = dataSet[position].toString()

        holder.button.setOnClickListener {
            holder.view.findNavController().navigate(R.id.action_lettersFragment_to_wordsFragment)
        }
    }

    override fun getItemCount() = dataSet.size
}

class LettersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val button: Button = view.findViewById(R.id.button)
}