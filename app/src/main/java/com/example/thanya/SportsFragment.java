package com.example.thanya;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class SportsFragment extends Fragment {
    ProgressDialog progressDialog;
    ArrayList<NewsItems> data;
    Adapter2 adapt;
    ListView news;
    String imgurl;
    String content;
    String date="";
    String title;
    String des;
    String newfeed = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sports, container, false);
        // Inflate the layout for this fragment
        news = (ListView) root.findViewById(R.id.listofnews);

        data = new ArrayList<NewsItems> ();


        adapt = new Adapter2(data, getActivity());
        data.add(new NewsItems(null,null,null,null,"loading" , null));

        new GetLatestNews().execute(
                "https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=fc183d7a06f24301ae2dea58a313ab2a");
        new GetLatestNews().execute(
                "https://newsapi.org/v1/articles?source=sky-sports-news&sortBy=top&apiKey=fc183d7a06f24301ae2dea58a313ab2a");
        new GetLatestNews().execute(
                "https://newsapi.org/v1/articles?source=talksport&sortBy=top&apiKey=fc183d7a06f24301ae2dea58a313ab2a");
        new GetLatestNews().execute(
                "https://newsapi.org/v1/articles?source=fox-sports&sortBy=top&apiKey=fc183d7a06f24301ae2dea58a313ab2a");

        return root;
    }
    class GetLatestNews extends AsyncTask<String, String, String>
    {
        String line = "";

        @Override
        protected void onPreExecute() {
            news.setAdapter(adapt);
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... arg0) {
            try
            {
                URL url = new URL(arg0[0]);
                URLConnection conn = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream() ));
                while ((line=br.readLine())!=null) {
                    newfeed+= line;


                }

            }
            catch (Exception e)
            {

            }
            return newfeed;
        }
        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub

//			Toast.makeText(getApplicationContext(), result, 10000).show();
            try
            {
//                data.clear();
                JSONObject j1 = new JSONObject(result);
                JSONArray a = j1.getJSONArray("articles");
                for (int i = 0 ; i<a.length() ; i++)
                {
                    String article = a.getString(i);
                    JSONObject object = new JSONObject(article);
                    title = object.getString("title");
                    des = object.getString("description");
                    imgurl = object.getString("urlToImage");
                    content = object.getString("url");
                    date = object.getString("publishedAt");

                    data.add(new NewsItems(title, des, imgurl,content , "new"  ,date));


                    news.setAdapter(adapt);
                }


            }
            catch (Exception e)
            {

            }

            super.onPostExecute(result);
        }

}}
