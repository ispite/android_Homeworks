package ru.skillbox.fragments_15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val screens: List<ArticlePage> = listOf(
        ArticlePage(
            textRes = R.string.onboarding_text_1,
            bgColorRes = R.color.onboarding_color_1,
            drawableRes = R.drawable.business_1
        ),
        ArticlePage(
            textRes = R.string.onboarding_text_2,
            bgColorRes = R.color.onboarding_color_2,
            drawableRes = R.drawable.business_2
        ),
        ArticlePage(
            textRes = R.string.onboarding_text_3,
            bgColorRes = R.color.onboarding_color_3,
            drawableRes = R.drawable.sport_1
        ),
        ArticlePage(
            textRes = R.string.onboarding_text_4,
            bgColorRes = R.color.onboarding_color_4,
            drawableRes = R.drawable.sport_2
        ),
        ArticlePage(
            textRes = R.string.onboarding_text_5,
            bgColorRes = R.color.onboarding_color_5,
            drawableRes = R.drawable.health_1
        ),
        ArticlePage(
            textRes = R.string.onboarding_text_6,
            bgColorRes = R.color.onboarding_color_6,
            drawableRes = R.drawable.health_2
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = OnBoardingAdapter(screens, this)
        viewPager.adapter = adapter
    }
}