package com.example.win17

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.win17.adapter.HowToAdapter
import com.example.win17.model.HowToModel
import com.example.win17.model.Howto
import com.example.win17.repository.HowToRepository
import com.example.win17.retrofit.AviatorApi
import com.example.win17.viewmodel.HowToViewModel
import com.example.win17.viewmodel.HowToViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainFragment : Fragment() {
    lateinit var howToViewModel: HowToViewModel
    val tipsList = ArrayList<Howto>()
    lateinit var navigationController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        val losingButton = requireActivity().findViewById<AppCompatImageView>(R.id.button_loosing)
        losingButton.setOnClickListener {
            navigationController.navigate(R.id.action_mainFragment_to_losingFragment)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://49.12.202.175/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AviatorApi::class.java)
        val howToRepository = HowToRepository(retrofit)

        howToViewModel = ViewModelProvider(
            this,
            HowToViewModelFactory(howToRepository)
        )[HowToViewModel::class.java]
        howToViewModel.tips.observe(requireActivity()){
            for (i in it.howto){
                tipsList.add(i)
            }
            val recycler = requireActivity().findViewById<RecyclerView>(R.id.recycler_view)
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = HowToAdapter(tipsList)
        }
    }
}