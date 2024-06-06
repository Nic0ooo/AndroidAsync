package com.fr.esgi.azyncapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String>{
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        //nombre random entre 0 et 10
        Random r = new Random();
        int n = r.nextInt(11);
        //Pour que le thread dorme plus longtemps
        int s = n * 500;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //renvoi le string
        return "Enfin réveillé après avoir dormi pendant " + s + " millisecondes !";
    }

    protected void onPostExecute(String result) {
        TextView tv = mTextView.get();
        if (tv != null) {
            tv.setText(result);
        }
        //mTextView.get().setText(result);
    }
}
