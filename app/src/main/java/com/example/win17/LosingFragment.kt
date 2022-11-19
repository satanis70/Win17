package com.example.win17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.win17.adapter.HowToAdapter
import com.example.win17.adapter.LosingAdapter
import com.example.win17.model.Losing
import com.example.win17.repository.LosingRepository
import com.example.win17.retrofit.AviatorApi
import com.example.win17.viewmodel.LosingViewModel
import com.example.win17.viewmodel.LosingViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LosingFragment : Fragment() {

    lateinit var losingViewModel: LosingViewModel
    val losingList = ArrayList<Losing>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_losing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://49.12.202.175/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AviatorApi::class.java)
        val losingRepository = LosingRepository(retrofit)

        losingViewModel = ViewModelProvider(
            this,
            LosingViewModelFactory(losingRepository)
        )[LosingViewModel::class.java]
        losingViewModel.losing.observe(requireActivity()){
            for (i in it.losing){
                losingList.add(i)
            }
            val recycler = requireActivity().findViewById<RecyclerView>(R.id.recycler_view_losing)
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.adapter = LosingAdapter(listLosing = losingList)
        }
    }
}