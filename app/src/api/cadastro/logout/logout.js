import { instance } from "../../../configs/httpClient";

export async function logout() {
    const response = await instance.post("/logout");

    return response.data;
}