package eu.tutorials.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import eu.tutorials.dictionary.adapter.LettersAdapter
import eu.tutorials.dictionary.databinding.FragmentLettersBinding
import eu.tutorials.dictionary.model.DictionaryViewModel

class LettersFragment : Fragment() {

    private lateinit var binding: FragmentLettersBinding
    private val sharedViewModel: DictionaryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLettersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            lettersViewModel = sharedViewModel
            lettersFragment = this@LettersFragment
            recyclerView.adapter = LettersAdapter()
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

}