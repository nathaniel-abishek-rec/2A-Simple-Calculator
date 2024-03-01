package com.example.app2a

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app2a.databinding.ActivityMainBinding
import com.example.app2a.ui.theme.App2ATheme
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import javax.xml.xpath.XPathExpression

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onAllClearClick(view: View)
    {
        binding.textView1.text = ""
        binding.textView2.text = "0"
    }

    fun onBackClick(view: View)
    {
        binding.textView1.text = binding.textView1.text.toString().dropLast(1)
    }

    fun onDigitClick(view: View)
    {
        binding.textView1.append((view as Button).text)
    }

    fun onEqualClick (view: View)
    {
        var last = binding.textView1.text.toString().last()

        if (last.equals("+") || last.equals("-") || last.equals("*") || last.equals("/")) {
            val text = "Enter expression after operator"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

        else {
            onEqual()
        }
    }

    private fun onEqual()
    {
        val txt = binding.textView1.text.toString()
        expression = ExpressionBuilder(txt).build()

        val result = expression.evaluate()

        binding.textView2.text = result.toString()
    }

    fun onOperatorClick(view: View)
    {
        binding.textView1.append((view as Button).text)
    }
}