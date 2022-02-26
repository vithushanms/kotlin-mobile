package vithushan.iit.mobiledev.tiktactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textViews : List<TextView> = listOf(
            findViewById(R.id.box_01),
            findViewById(R.id.box_02),
            findViewById(R.id.box_03),
            findViewById(R.id.box_04),
            findViewById(R.id.box_05),
            findViewById(R.id.box_06),
            findViewById(R.id.box_07),
            findViewById(R.id.box_08),
            findViewById(R.id.box_09)
        );

        var winPossitions = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8),
            intArrayOf(0, 1, 2),
            intArrayOf(2, 4, 6),
        )

        for (textView in textViews){
            textView.setOnClickListener{
                if(textView.text.isNullOrEmpty()){
                    textView.text = "X"

                    for (winPosition in winPossitions){
                        var one = false
                        var two = false
                        var three = false
                        var checkedPos = 0;

                        for (position in winPosition){
                            if(checkedPos != position && position == textViews.indexOf(textView)){
                                one = true
                                checkedPos = position
                            }

                            if(checkedPos != position && textViews[position].text == "X"){
                                two = true
                            }

                            if(checkedPos != position && textViews[position].text == "X"){
                                three = true
                            }
                        }

                        if(one && two && three){
                            Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }
        }
    }
}