package com.example.caretones.data

import com.example.caretones.R
import com.example.caretones.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.logo_caretones),
            Affirmation(R.string.affirmation2, R.drawable.logo_caretones),
            Affirmation(R.string.affirmation3, R.drawable.logo_caretones))
    }
}