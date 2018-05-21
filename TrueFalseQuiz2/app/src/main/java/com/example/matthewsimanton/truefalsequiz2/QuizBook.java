package com.example.matthewsimanton.truefalsequiz2;

import android.app.Activity;

public class QuizBook extends Activity {
    public static String[] questions = new String[] {
            "If a ball lands in the ivy and gets stuck there it’s considered a foul ball.",
            "Ernie Banks is the only Cub to win back to back MVP awards.",
            "When a die-hard Cubs fan dies, the fan can have his or her ashes scattered at Wrigley Field.",
            "The Beach Boys recorded a Cubs themed song called ‘Here Come the Cubs’ to the tune of ‘Barbara Ann’.",
            "Fergie Jenkins, Cubs pitcher, was also a Harlem Globetrotter. ",
            "In the early 1900’s, the Cubs had a 3-fingered pitcher named Mordecai Brown.",
            "The Cubs have only been to the World Series 4 times.",
            "After every victory, Cubs fans raise a ‘C’ flag to celebrate the win.",
            "No Cubs pitchers have ever thrown a perfect game.",
            "Kerry Wood injured his chest when he slipped getting out of a hot tub."
    };

    public static int[] images = new int[] {
            R.drawable.unnamed,R.drawable.unnamed2,R.drawable.unnamed3,R.drawable.unnamed4,R.drawable.unnamed5,R.drawable.unnamed6,
            R.drawable.unnamed7,R.drawable.unnamed8,R.drawable.unnamed9,R.drawable.unnamed10
    };

    public static boolean[] answers = new boolean[] {
            false,true,false,true,true,true,false,false,true,true,
    };


}
