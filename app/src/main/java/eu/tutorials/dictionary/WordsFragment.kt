package eu.tutorials.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import eu.tutorials.dictionary.adapter.WordsAdapter
import eu.tutorials.dictionary.databinding.FragmentWordsBinding
import eu.tutorials.dictionary.model.DictionaryViewModel

class WordsFragment : Fragment() {

    private lateinit var letter: String
    private lateinit var binding: FragmentWordsBinding
    private val sharedViewModel: DictionaryViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letter = it.getString("letter").toString()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            wordsViewModel = sharedViewModel
            wordsFragment = this@WordsFragment
            recyclerView.adapter = WordsAdapter(requireContext(), letter)
            recyclerView.setHasFixedSize(true)
        }
    }

    companion object {
        const val TAG = "WordListFragment"
        const val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

}