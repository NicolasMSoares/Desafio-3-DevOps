import { instance } from "../../configs/httpClient";

export async function login({ username, password }) {
    const response = await instance.post('/login', {}, {
        auth: {
            username,
            password
        }
    })

    return response.data;
}