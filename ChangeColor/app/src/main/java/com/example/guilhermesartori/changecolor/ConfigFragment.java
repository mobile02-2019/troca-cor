package com.example.guilhermesartori.changecolor;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfigFragment extends Fragment {
    ListenerTrocaCores listenerTrocaCores;
    Switch troca;

    public ConfigFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerTrocaCores = (ListenerTrocaCores) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_config, container, false);

        troca = inflate.findViewById(R.id.troca_id);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("teste", troca.isChecked());
        editor.apply();


        Button buttonYellow = inflate.findViewById(R.id.change_color_yellow_bt);
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarCores(false);
            }
        });

        Button buttonGreen = inflate.findViewById(R.id.change_color_green_bt);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trocarCores(true);
            }
        });

        return inflate;
    }

    private void trocarCores(boolean tema) {

        listenerTrocaCores.trocarCores(tema);
    }

}
