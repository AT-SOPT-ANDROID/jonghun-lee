package org.sopt.at.component

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.at.login.util.LoginRepository
import org.sopt.at.login.util.LoginViewModelFactory
import org.sopt.at.main.MainScreen
import org.sopt.at.my.MyScreen
import org.sopt.at.my.MyViewModel
import org.sopt.at.navigation.NavItem

@Composable
fun AppNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        composable(NavItem.MAIN){
            MainScreen(rootNavController = navController)
        }
        composable(NavItem.MY) {
            val context = LocalContext.current
            val loginRepository = LoginRepository(context.getSharedPreferences("prefs", Context.MODE_PRIVATE))
            val factory =LoginViewModelFactory(loginRepository)
            val viewModel: MyViewModel = viewModel(factory = factory)

            MyScreen(viewModel = viewModel, navController = navController)
        }


    }
}