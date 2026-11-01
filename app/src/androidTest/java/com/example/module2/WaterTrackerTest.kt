package com.example.module2

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent {
            WaterTracker()
        }
    }

    @Test
    fun checkButtonsExist() {
        composeRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Закончить день").assertIsDisplayed()
    }

    @Test
    fun checkWaterButtonAdds250ml() {
        composeRule.onNodeWithText("+250 мл").performClick()
        composeRule.onNodeWithText("Выпито: 250 мл").assertIsDisplayed()
    }

    @Test
    fun checkStreakDaysCounter() {
        repeat(6) {
            composeRule.onNodeWithText("+250 мл").performClick()
        }
        composeRule.onNodeWithText("Закончить день").performClick()
        composeRule.onNodeWithText("Серия дней: 1").assertIsDisplayed()
        composeRule.onNodeWithText("Выпито: 0 мл").assertIsDisplayed()
    }

    @Test
    fun checkStreakResetsWhenGoalNotReached() {
        repeat(6) {
            composeRule.onNodeWithText("+250 мл").performClick()
        }
        composeRule.onNodeWithText("Закончить день").performClick()

        repeat(4) {
            composeRule.onNodeWithText("+250 мл").performClick()
        }
        composeRule.onNodeWithText("Закончить день").performClick()

        composeRule.onNodeWithText("Серия дней: 0").assertIsDisplayed()
    }
}