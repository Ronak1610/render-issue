package com.example.animequotes



import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.animequotes.ui.theme.AnimeQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeQuotesTheme {
                // A surface container using the 'background' color from the theme
                TopBar()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TopBar() {
    var states by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title =
                {
                    Text(text = "Anime Quote", fontWeight = FontWeight.Medium)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSecondary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.tertiary
                )
            )
        }
    )
    {
        innerPadding ->
        Surface (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            color = MaterialTheme.colorScheme.background

        )
        {
            when (states)
            {
                1-> {
                   quotesWithImage(textLabelResource = (R.string.its_our_name),
                       imageResource = R.drawable.ayase_1_,
                       contentDescs =R.string.its_our_name ,
                       onImageCick ={states=2})


                }
                2-> {
                    quotesWithImage(
                        textLabelResource = (R.string.kuso_gaki),
                        imageResource = (R.drawable.animediscover_com_1_),
                        contentDescs = (R.string.kuso_gaki),
                        onImageCick = { states = 3 }

                    )
                }
                3-> {
                    quotesWithImage(
                        textLabelResource = (R.string.kimoi),
                        imageResource = R.drawable.animediscover_com_2_,
                        contentDescs = R.string.kimoi,
                        onImageCick = { states = 4 }
                    )
                }
                else -> {
                    quotesWithImage(
                        textLabelResource = (R.string.bokurawa),
                        imageResource = R.drawable.animediscover_com_3_,
                        contentDescs = R.string.bokurawa,
                        onImageCick = { states = 1 }
                    )
                }

            }
        }


    }
}
@Composable
fun quotesWithImage(
    textLabelResource :Int,
    imageResource :Int,
    contentDescs :Int,
    onImageCick :() -> Unit,
    modifier: Modifier= Modifier.fillMaxSize()


)
{
Box (modifier=modifier)
{
Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier=Modifier.fillMaxSize()) {
    Button(onClick = onImageCick, shape = RoundedCornerShape(47.dp), colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer))
    {

        Image(painter = painterResource(imageResource), contentDescription = stringResource(contentDescs),modifier= Modifier
            .width(
                dimensionResource(id = R.dimen.button_image_width)
            )
            .height(dimensionResource(R.dimen.button_image_height))
            .padding(dimensionResource(id = R.dimen.button_interior_padding))



        )

    }
    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
    Text(text = stringResource(textLabelResource), style = MaterialTheme.typography.bodyLarge)

}

}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimeQuotesTheme {
TopBar()
    }
}