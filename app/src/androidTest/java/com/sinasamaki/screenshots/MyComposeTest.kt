package com.sinasamaki.screenshots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.sinasamaki.screenshots.ui.theme.ScreenshotsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule

@ExperimentalAnimationApi
class MyComposeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Before
    fun init() {
        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
    }

    @Test
    fun simpleScreenshot() {
        composeTestRule.setContent {
            ScreenshotsTheme {
                App()
            }
        }
        composeTestRule.takeScreenshot("simpleScreenshot")
    }

    @Test
    fun screenshotInCard() {
        composeTestRule.setContent {
            ScreenshotsTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                        .shadow(elevation = 18.dp, shape = RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    App()
                }
            }
        }
        composeTestRule.takeScreenshot("screenshotInCard")
    }

    @Test
    fun titleScreenshot() {
        composeTestRule.setContent {
            ScreenshotsTheme {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(x = 10.dp, y = 30.dp)
                            .size(200.dp)
                            .background(color = MaterialTheme.colors.secondary, shape = CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = 40.dp, y = 130.dp)
                            .size(50.dp)
                            .background(color = MaterialTheme.colors.primary, shape = CircleShape)
                    )
                    Column(
                        modifier = Modifier
                            .verticalScroll(state = rememberScrollState(), reverseScrolling = false)
                            .fillMaxSize()
                    ) {

                        Text(
                            text = "Tasks app",
                            textAlign = TextAlign.Center,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 94.dp)
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(640.dp)
                                .padding(horizontal = 30.dp)
                                .shadow(elevation = 18.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            App()
                        }
                    }
                }
            }
        }
        composeTestRule.takeScreenshot("title")
    }

    @Test
    fun subtitleScreenshot() {
        composeTestRule.setContent {
            ScreenshotsTheme {
                Box(
                    Modifier
                        .background(Color.White)
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .offset(x = 10.dp, y = 30.dp)
                            .size(200.dp)
                            .background(color = MaterialTheme.colors.secondary, shape = CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(x = (-40).dp, y = (-130).dp)
                            .size(50.dp)
                            .background(color = MaterialTheme.colors.primary, shape = CircleShape)
                    )
                    Column(
                        modifier = Modifier
                            .verticalScroll(state = rememberScrollState(), reverseScrolling = true)
                            .fillMaxSize()
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(800.dp)
                                .padding(horizontal = 30.dp)
                                .shadow(elevation = 18.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            App()
                        }

                        Text(
                            text = "Manage tasks",
                            textAlign = TextAlign.Center,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 94.dp)
                        )
                    }
                }
            }
        }
        composeTestRule.takeScreenshot("subtitle")
    }

    @Test
    fun themeScreenshot() {
        composeTestRule.setContent {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 10.dp, y = 30.dp)
                        .size(200.dp)
                        .background(color = MaterialTheme.colors.secondary, shape = CircleShape)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 40.dp, y = 140.dp)
                        .size(50.dp)
                        .background(color = MaterialTheme.colors.primary, shape = CircleShape)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    Text(
                        text = "Light or Dark",
                        textAlign = TextAlign.Center,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 94.dp)
                    )

                    val config = LocalConfiguration.current

                    Row(
                        modifier = Modifier
                            .requiredWidth(config.screenWidthDp.dp * 2)
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(config.screenWidthDp.dp)
                                .padding(horizontal = 30.dp)
                                .shadow(elevation = 18.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Green)
                        ) {
                            ScreenshotsTheme(darkTheme = false) {
                                App()
                            }

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(config.screenWidthDp.dp)
                                .padding(horizontal = 30.dp)
                                .shadow(elevation = 18.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Green)
                        ) {
                            ScreenshotsTheme(darkTheme = true) {
                                App()
                            }

                        }
                    }
                }
            }
        }
        composeTestRule.takeScreenshot("theme")
    }
}

private fun AndroidComposeTestRule<ActivityScenarioRule<TestActivity>, TestActivity>.takeScreenshot(
    screenshotName: String
) {
    runBlocking {
        awaitIdle()
        delay(100)
        Screengrab.screenshot(screenshotName)
    }
}