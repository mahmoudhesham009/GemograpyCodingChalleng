package com.mahmoudh.gemography_coding_challenge.repository;

import com.google.gson.Gson;
import com.mahmoudh.gemography_coding_challenge.model.Data;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Repository
public class HttpFetchRepository {
    private URL url;
    private HttpURLConnection con;
    private String formatted;

    public Data getResponce() throws IOException {
        LocalDate date = LocalDate.now().minusDays(30);
        formatted = date.toString();
        url= new URL("https://api.github.com/search/repositories?q=created:"+formatted+"%3E2021-07-15&sort=stars&order=desc");
        con= (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        InputStream in = con.getInputStream();
        InputStreamReader isw = new InputStreamReader(in);
        StringBuilder stringBuilder=new StringBuilder();

        int data = isw.read();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            stringBuilder.append(current);
        }
        con.disconnect();
        Gson gson = new Gson();
        return gson.fromJson(stringBuilder.toString(), Data.class);
    }
}
