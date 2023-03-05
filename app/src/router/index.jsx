import { createBrowserRouter } from "react-router-dom";
import { HomeScreen } from "../screens/home/home.screen";

import { LoginScreen } from "../screens/login/login.screen";


export const router = createBrowserRouter([

    {
        path: "/",
        element: <LoginScreen />
    },
    {
        path: "/home",
        element: <HomeScreen />
    }
]);