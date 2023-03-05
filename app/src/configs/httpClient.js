import axios from "axios";

import { BASE_URL_API } from "../constants";

export const instance = axios.create({
    baseURL: BASE_URL_API,
    timeout: 5000,
    withCredentials: true
})