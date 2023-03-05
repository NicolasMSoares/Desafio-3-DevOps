import "./App.css";
import { RouterProvider } from "react-router-dom";
import { router } from "./router";
import { GlobalUserProvider } from "./context/user/useGlobalUser";

function App() {
  return (
    <GlobalUserProvider>
      <RouterProvider router={router} />
      </GlobalUserProvider>
  );
}

export default App;
