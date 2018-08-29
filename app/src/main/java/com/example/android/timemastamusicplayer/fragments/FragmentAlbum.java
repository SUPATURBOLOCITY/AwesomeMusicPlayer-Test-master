package com.example.android.timemastamusicplayer.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.android.awesomemusicplayer.R;
import com.example.android.timemastamusicplayer.activity.AlbumTracksListActivity;
import com.example.android.timemastamusicplayer.adapter.AlbumAdapter;
import com.example.android.timemastamusicplayer.model.AlbumObj;
import com.example.android.timemastamusicplayer.utils.StorageUtil;
import com.example.android.timemastamusicplayer.utils.TracksUtils;

import java.util.ArrayList;

public class FragmentAlbum extends Fragment implements AlbumAdapter.CustomAlbumOnClickListener {

    private ArrayList<AlbumObj> albumObjArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    AlbumAdapter adapter;
    ProgressBar progressBar;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_list,container,false);


        progressBar = view.findViewById(R.id.progressBar_album);
        recyclerView = view.findViewById(R.id.recycler_view_album);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new AlbumAdapter(albumObjArrayList, getActivity(), this);
        recyclerView.setAdapter(adapter);

        new BackgroundThread2().execute();

        return view;
    }


    class BackgroundThread2 extends AsyncTask<Void,Void,ArrayList<AlbumObj>>{

        @Override
        protected ArrayList<AlbumObj> doInBackground(Void... voids) {
            return TracksUtils.getAlbums(StorageUtil.loadAudio(getActivity()));
        }

        @Override
        protected void onPostExecute(ArrayList<AlbumObj> albumObjs) {
            super.onPostExecute(albumObjs);
            progressBar.setVisibility(View.INVISIBLE);
            albumObjArrayList.addAll(albumObjs);
            adapter.notifyDataSetChanged();
            StorageUtil.storeAlbums(albumObjArrayList, getActivity());
        }
    }


    @Override
    public void onClick(long id, String name) {
        Intent in = new Intent(getContext(),
                AlbumTracksListActivity.class);

        in.putExtra("albumId", id);
        in.putExtra("albumName", name);

        startActivity(in);

    }

    public void searchIt(String q) {
        adapter.getFilter().filter(q);

    }

}
