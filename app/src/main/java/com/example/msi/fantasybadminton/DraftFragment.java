
package com.example.msi.fantasybadminton;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DraftFragment extends Fragment {
    private Draft draft;
    private TextView textViewPlayerLeft;
    private TextView textViewPlayerMiddle;
    private TextView textViewPlayerRight;
    private TextView buttonTeam;
    private ImageView imageViewPlayerLeft;
    private ImageView imageViewPlayerMiddle;
    private ImageView imageViewPlayerRight;
    private View rootView;
    OnItemSelectedListener mCallBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_draft, container, false);

        InputStream JSONFileInputStream = getResources().openRawResource(R.raw.player);
        String sJSON = readTextFile(JSONFileInputStream);

        Gson gson = new Gson();
        // read your json file into an array of questions
        Player[] players = gson.fromJson(sJSON, Player[].class);
        // convert your array to a list using the Arrays utility class
        List<Player> draftList = Arrays.asList(players);


        draft = new Draft(draftList, 0, 1, 2);

        wireWidgets();
        setListeners();


        buttonTeam.setText("Click to view team");
        textViewPlayerLeft.setText(draft.getPlayers().get(draft.getLeftPlayer()).getName() + "\n" +
                "Power: " + draft.getPlayers().get(draft.getLeftPlayer()).getPower() + "\n" +
                "Gender: " + draft.getPlayers().get(draft.getLeftPlayer()).getGender() + "\n" +
                "Nationality: " + draft.getPlayers().get(draft.getLeftPlayer()).getNationality() + "\n" +
                "Discipline: " + draft.getPlayers().get(draft.getLeftPlayer()).getDiscipline() + "\n" +
                "Partner: " + draft.getPlayers().get(draft.getLeftPlayer()).getPartner());
        textViewPlayerRight.setText(draft.getPlayers().get(draft.getRightPlayer()).getName() + "\n" +
                "Power: " + draft.getPlayers().get(draft.getRightPlayer()).getPower() + "\n" +
                "Gender: " + draft.getPlayers().get(draft.getRightPlayer()).getGender() + "\n" +
                "Nationality: " + draft.getPlayers().get(draft.getRightPlayer()).getNationality() + "\n" +
                "Discipline: " + draft.getPlayers().get(draft.getRightPlayer()).getDiscipline() + "\n" +
                "Partner: " + draft.getPlayers().get(draft.getRightPlayer()).getPartner());
        textViewPlayerMiddle.setText(draft.getPlayers().get(draft.getMiddlePlayer()).getName() + "\n" +
                "Power: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPower() + "\n" +
                "Gender: " + draft.getPlayers().get(draft.getMiddlePlayer()).getGender() + "\n" +
                "Nationality: " + draft.getPlayers().get(draft.getMiddlePlayer()).getNationality() + "\n" +
                "Discipline: " + draft.getPlayers().get(draft.getMiddlePlayer()).getDiscipline() + "\n" +
                "Partner: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPartner());
        imageViewPlayerLeft.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getLeftPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
        imageViewPlayerRight.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getRightPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
        imageViewPlayerMiddle.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getMiddlePlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
        return rootView;
    }

    private void setListeners() {
        ChoosePlayer listener = new ChoosePlayer();
        imageViewPlayerLeft.setOnClickListener(listener);
        imageViewPlayerRight.setOnClickListener(listener);
        imageViewPlayerMiddle.setOnClickListener(listener);
        buttonTeam.setOnClickListener(listener);
    }

    private void wireWidgets() {
        buttonTeam = rootView.findViewById(R.id.button_draft_team);
        textViewPlayerLeft = rootView.findViewById(R.id.textView_draft_leftPlayer);
        textViewPlayerMiddle = rootView.findViewById(R.id.textView_draft_middlePlayer);
        textViewPlayerRight = rootView.findViewById(R.id.textView_draft_rightPlayer);
        imageViewPlayerLeft = rootView.findViewById(R.id.imageView_draft_leftPlayer);
        imageViewPlayerMiddle = rootView.findViewById(R.id.imageView_draft_middlePlayer);
        imageViewPlayerRight = rootView.findViewById(R.id.imageView_draft_rightPlayer);
    }


    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    private class ChoosePlayer implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_draft_team:
                    mCallBack.OnItemSelected();
                    break;
                case R.id.imageView_draft_leftPlayer:

                    draft.nextRound();
                    textViewPlayerLeft.setText(draft.getPlayers().get(draft.getLeftPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getLeftPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getLeftPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getLeftPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getLeftPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getLeftPlayer()).getPartner());
                    textViewPlayerRight.setText(draft.getPlayers().get(draft.getRightPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getRightPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getRightPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getRightPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getRightPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getRightPlayer()).getPartner());
                    textViewPlayerMiddle.setText(draft.getPlayers().get(draft.getMiddlePlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getMiddlePlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getMiddlePlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getMiddlePlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPartner());
                    imageViewPlayerLeft.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getLeftPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerRight.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getRightPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerMiddle.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getMiddlePlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    break;
                case R.id.imageView_draft_middlePlayer:

                    draft.nextRound();
                    textViewPlayerLeft.setText(draft.getPlayers().get(draft.getLeftPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getLeftPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getLeftPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getLeftPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getLeftPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getLeftPlayer()).getPartner());
                    textViewPlayerRight.setText(draft.getPlayers().get(draft.getRightPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getRightPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getRightPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getRightPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getRightPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getRightPlayer()).getPartner());
                    textViewPlayerMiddle.setText(draft.getPlayers().get(draft.getMiddlePlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getMiddlePlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getMiddlePlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getMiddlePlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPartner());
                    imageViewPlayerLeft.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getLeftPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerRight.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getRightPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerMiddle.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getMiddlePlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    break;
                case R.id.imageView_draft_rightPlayer:

                    draft.nextRound();
                    textViewPlayerLeft.setText(draft.getPlayers().get(draft.getLeftPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getLeftPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getLeftPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getLeftPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getLeftPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getLeftPlayer()).getPartner());
                    textViewPlayerRight.setText(draft.getPlayers().get(draft.getRightPlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getRightPlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getRightPlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getRightPlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getRightPlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getRightPlayer()).getPartner());
                    textViewPlayerMiddle.setText(draft.getPlayers().get(draft.getMiddlePlayer()).getName() + "\n" +
                            "Power: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPower() + "\n" +
                            "Gender: " + draft.getPlayers().get(draft.getMiddlePlayer()).getGender() + "\n" +
                            "Nationality: " + draft.getPlayers().get(draft.getMiddlePlayer()).getNationality() + "\n" +
                            "Discipline: " + draft.getPlayers().get(draft.getMiddlePlayer()).getDiscipline() + "\n" +
                            "Partner: " + draft.getPlayers().get(draft.getMiddlePlayer()).getPartner());
                    imageViewPlayerLeft.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getLeftPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerRight.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getRightPlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    imageViewPlayerMiddle.setImageResource(getResources().getIdentifier((draft.getPlayers().get(draft.getMiddlePlayer())).getImageId(), "drawable", "com.example.msi.fantasybadminton"));
                    break;
            }
        }

    }

    public void setOnItemSelectedListener(Activity activity){
        mCallBack = (OnItemSelectedListener) activity;
    }

    public interface OnItemSelectedListener{
        public void OnItemSelected();
    }
}
