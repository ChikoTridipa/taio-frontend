import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.pager.*
import com.taio.taio.R
import com.taio.taio.ui.theme.Green500
import com.taio.taio.ui.theme.Typography

@OptIn(ExperimentalPagerApi::class)
@Composable
fun EmailCheckScreen() {
    val pages = listOf(R.drawable.isi_form, R.drawable.ttd, R.drawable.generate)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(color = White)
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .heightIn(min = maxHeight)
        ) {
            Row(
                modifier = Modifier
                    .height(45.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_taio_rectangle),
                    contentDescription = stringResource(R.string.logo_taio),
                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = stringResource(id = R.string.name),
                    style = Typography.h4,
                    color = Black
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = stringResource(id = R.string.email_check),
                    style = Typography.h2,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.85f),
                    painter = painterResource(id = R.drawable.email_check_campaign),
                    contentDescription = "Email Check Campaign",
                )
            }
            
            Spacer(modifier = Modifier.size(40.dp))
            
            BottomLanding(label = stringResource(id = R.string.login_label)) {
                
            }




        }
    }
}

@Composable
fun BottomLanding(
    label: String,
    onButtonClick: () -> Unit
)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Button(
            onClick = {
                onButtonClick()
            },
            content = {
                Text(
                    text = label,
                    style = Typography.button,
                    color = White
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Green500)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        EmailCheckScreen()
    }
}