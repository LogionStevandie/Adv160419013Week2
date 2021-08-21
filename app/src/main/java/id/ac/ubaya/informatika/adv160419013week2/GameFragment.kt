package id.ac.ubaya.informatika.adv160419013week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nilai1 = 0
        var nilai2 = 0
        var point = 0

        if (arguments != null){
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
            nilai1 = Random.nextInt(1, 100)
            nilai2 = Random.nextInt(1, 100)
            txtQuestion.text = "$nilai1 + $nilai2"
        }

        btnSubmit.setOnClickListener {
            if (txtAnswer.text.toString() != null){
                if (txtAnswer.text.toString().toInt() == nilai1 + nilai2){
                    point += 1
                    nilai1 = Random.nextInt(1, 100)
                    nilai2 = Random.nextInt(1, 100)
                    txtQuestion.text = "$nilai1 + $nilai2"
                }
                else{
                    val action = GameFragmentDirections.actionResultFragment(point)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
}